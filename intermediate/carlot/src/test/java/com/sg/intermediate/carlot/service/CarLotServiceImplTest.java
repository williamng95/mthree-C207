package com.sg.intermediate.carlot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import com.sg.intermediate.carlot.dao.CarLotDao;
import com.sg.intermediate.carlot.dao.CarLotDaoMemImpl;
import com.sg.intermediate.carlot.dto.Car;
import com.sg.intermediate.carlot.dto.CarKey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarLotServiceImplTest {
    CarLotServiceImpl testService;
    // declare 2 constant lists for use in tests, keep one VIN as invalid
    private static final String[] CAR_VINS = { "AAA1234", "XYZ999", "YSA110", "ZZZ000" };

    private final Car[] CAR_LIST = {
            new Car(CAR_VINS[0], "TOYOTA", "CAMRY", "YELLOW", new BigDecimal("10000"), 4532,
                    new CarKey(CAR_VINS[0], false)),
            new Car(CAR_VINS[1], "FERRARI", "911", "BLACK", new BigDecimal("44443333"), 123434,
                    new CarKey(CAR_VINS[1], true)),
            new Car(CAR_VINS[2], "PORSHE", "ENZO", "BLACK", new BigDecimal("999999"), 333,
                    new CarKey(CAR_VINS[2], true))
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
        assertThrows(NoSuchCarException.class, () -> testService.getACar(CAR_VINS[CAR_VINS.length - 1]));
    }

    @Test
    void testDiscountCar() {

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

        assertEquals(1, retrievedList.size(), "There should only be one car within the price budget");
        for (Car car : retrievedList) {
            // bigdecimal requires compareTo, -1 indicates caller is less than arg
            assertTrue(car.getPrice().compareTo(maxPrice) < -1,
                    String.format("Car should cost less than %.2f, but got %s", maxPrice, car.toString()));
        }
    }

    @Test
    void testSellCar() {

    }
}
