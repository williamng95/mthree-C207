package com.sg.intermediate.carlot.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sg.intermediate.carlot.dao.CarLotDao;
import com.sg.intermediate.carlot.dto.Car;
import com.sg.intermediate.carlot.dto.CarKey;

public class CarLotServiceImpl implements CarLotService {
    private CarLotDao dao;

    /**
     * @param dao
     */
    public CarLotServiceImpl(CarLotDao dao) {
        this.dao = dao;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        Car carToDiscount = dao.getCar(VIN);
        if (carToDiscount == null){
            throw new NoSuchCarException("No such car exists");
        }
        // calculate percent value remaining of car (1-(discount/100))
        BigDecimal carPricePercent = new BigDecimal("1").subtract(percentDiscount.divide(new BigDecimal(100)));
        // multiply in remaining percent value for enw sale price
        BigDecimal newCarPrice = carToDiscount.getPrice().multiply(carPricePercent);

        carToDiscount.setPrice(newCarPrice);
        return newCarPrice;
    }

    @Override
    public Car getACar(String VIN) {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> carByMakeModel = new ArrayList<>();
        for (Car car : dao.getCars()) {
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                carByMakeModel.add(car);
            }
        }
        return carByMakeModel;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> carByColor = new ArrayList<>();
        for (Car car : dao.getCars()) {
            if (car.getColor().equals(color)) {
                carByColor.add(car);
            }
        }
        return carByColor;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        List<Car> carByPrice = new ArrayList<>();
        for (Car car : dao.getCars()) {
            if (car.getPrice().compareTo(maxPrice) <= 0) {
                carByPrice.add(car);
            }
        }
        return carByPrice;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        Car retrievedCar = getACar(VIN);
        if (retrievedCar == null){
            throw new NoSuchCarException("Car does not exist");
        }
        switch (dao.getCar(VIN).getPrice().compareTo(cashPaid)) {
            case -1:
                throw new OverpaidPriceException("Cash paid is more than price of car");
            case 1:
                throw new UnderpaidPriceException("Insufficient cash");
            case 0:
               return dao.removeCar(VIN).getKey();
        }
        return null;
    }

}
