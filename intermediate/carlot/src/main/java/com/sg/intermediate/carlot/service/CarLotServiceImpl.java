package com.sg.intermediate.carlot.service;

import java.math.BigDecimal;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Car getACar(String VIN) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        // TODO Auto-generated method stub
        return null;
    }

}
