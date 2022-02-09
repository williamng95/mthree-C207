package com.sg.intermediate.carlot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import com.sg.intermediate.carlot.dao.CarLotDao;
import com.sg.intermediate.carlot.dao.CarLotDaoMemImpl;
import com.sg.intermediate.carlot.dto.Car;
import com.sg.intermediate.carlot.dto.CarKey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarLotServiceImplTest {
    CarLotServiceImpl testService;
    // declare 2 constant lists for use in tests, keep one VIN as invalid
    private static final String[] CAR_VINS = { "AAA1234", "XYZ999", "YSA110", "SS000", "ZZZ000" };

    private final Car[] CAR_LIST = {
            new Car(CAR_VINS[0], "TOYOTA", "CAMRY", "YELLOW", new BigDecimal("50000"), 4532,
                    new CarKey(CAR_VINS[0], false)),
            new Car(CAR_VINS[1], "FERRARI", "911", "BLACK", new BigDecimal("44443333"), 123434,
                    new CarKey(CAR_VINS[1], true)),
            new Car(CAR_VINS[2], "PORSHE", "ENZO", "BLACK", new BigDecimal("999999"), 333,
                    new CarKey(CAR_VINS[2], true)),
            new Car(CAR_VINS[3], "PORSHE", "ENZO", "RED", new BigDecimal("5"), 4323255,
                    new CarKey(CAR_VINS[3], true))
    };

    @BeforeEach
    void setUp() {
        CarLotDao testdao = new CarLotDaoMemImpl();
        for (Car car : CAR_LIST) {
            testdao.addCar(car.getVIN(), car);
        }
        testService = new CarLotServiceImpl(testdao);
    }

    @Test
    void testInvalidDiscountCar() {
        // check that exception is thrown when VIN invalid VIN requested
        assertThrows(NoSuchCarException.class, () -> testService.discountCar(CAR_VINS[CAR_VINS.length - 1], new BigDecimal("1")));
    }

    @Test
    void testDiscountCar() throws NoSuchCarException {
        final BigDecimal percentDiscount = new BigDecimal("15");
        BigDecimal costPercent = new BigDecimal("1").subtract(percentDiscount.divide(new BigDecimal("100")));

        BigDecimal initialPrice = CAR_LIST[0].getPrice();
        BigDecimal returnPrice = testService.discountCar(CAR_VINS[0], percentDiscount);
        BigDecimal discountedPrice = initialPrice.multiply(costPercent);

        assertTrue(returnPrice.compareTo(discountedPrice) == 0,
                String.format("Discount not performed correctly, should be %f", discountedPrice));
        assertEquals(discountedPrice, testService.getACar(CAR_VINS[0]).getPrice(),
                "Discount Car should also edit the underlying Car object");
    }

    @Test
    void testGetACar() {
        Car retrievedCar = testService.getACar(CAR_VINS[0]);
        assertEquals(CAR_LIST[0], retrievedCar,
                String.format("Expected %s but got %s", CAR_LIST[0].toString(), retrievedCar.toString()));

        // check null for invalid ID
        retrievedCar = testService.getACar(CAR_VINS[CAR_VINS.length - 1]);
        assertNull(retrievedCar);
    }

    @Test
    void testGetAllCars() {
        List<Car> retrievedList = testService.getAllCars();
        // check list props
        assertNotNull(retrievedList, "GetAll should not return null");
        assertEquals(CAR_LIST.length, retrievedList.size(),
                String.format("List should contain %d cars", CAR_LIST.length));
        // check items
        for (Car car : CAR_LIST) {
            assertTrue(retrievedList.contains(car), String.format("List should contain the car: %s", car.toString()));
        }

    }

    @Test
    void testGetCarByMakeAndModel() {
        String make = "PORSHE";
        String model = "ENZO";

        List<Car> retrievedList = testService.getCarByMakeAndModel(make, model);

        assertEquals(2, retrievedList.size(), "There should be 2 PORSHE ENZO cars");

        for (Car car : retrievedList) {
            assertEquals(make, car.getMake(), String.format("Car should be of %s make", make));
            assertEquals(model, car.getModel(), String.format("Car shoule be of %s model", model));
        }
    }

    @Test
    void testGetCarsByColor() {
        String testColor = "BLACK";
        List<Car> retrievedList = testService.getCarsByColor(testColor);
        // there should only be 2 black cars
        assertEquals(2, retrievedList.size(), "There should only be 2 black cars");
        for (Car car : retrievedList) {
            assertEquals(testColor, car.getColor(),
                    String.format("Car should be %s in color, but got %s", testColor, car.toString()));
        }

    }

    @Test
    void testGetCarsInBudget() {
        BigDecimal maxPrice = new BigDecimal("100000");
        List<Car> retrievedList = testService.getCarsInBudget(maxPrice);

        assertEquals(2, retrievedList.size(), "There should only be one car within the price budget");
        for (Car car : retrievedList) {
            // bigdecimal requires compareTo, -1 indicates caller is less than arg, 0 indicates equality
            assertTrue(car.getPrice().compareTo(maxPrice) <= 0,
                    String.format("Car should cost less than %.2f, but got %s", maxPrice, car.toString()));
        }
    }

    @Test
    void testSellCar() throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        Random rng = new Random();
        int rngBound = 10000;
        // use random to offset price randomly
        for (Car car : CAR_LIST) {
            BigDecimal currentPrice = car.getPrice();
            BigDecimal underPrice = currentPrice.subtract(new BigDecimal(rng.nextInt(rngBound)));
            BigDecimal overPrice = currentPrice.add(new BigDecimal(rng.nextInt(rngBound)));

            // test under
            assertThrows(UnderpaidPriceException.class, () -> testService.sellCar(car.getVIN(), underPrice));
            // test
            assertThrows(OverpaidPriceException.class, () -> testService.sellCar(car.getVIN(), overPrice));
            // test exact
            CarKey returnKey = testService.sellCar(car.getVIN(), currentPrice);
            assertEquals(car.getKey(), returnKey, "wrong car key");
            assertNull(testService.getACar(car.getVIN()), "sold car should be removed from the inventory");
        }
        assertEquals(0, testService.getAllCars().size(), "there should not be any cars left");

    }

    @Test
    void testInvalidSellCar() {
        // check that exception is thrown when VIN invalid VIN requested
        // cash paid set as 1, not important since car does not exist
        assertThrows(NoSuchCarException.class, () -> testService.sellCar(CAR_VINS[CAR_VINS.length - 1], new BigDecimal("1")));
    }
}
