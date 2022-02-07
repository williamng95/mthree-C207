package com.sg.intermediate.carlot.service;

import java.math.BigDecimal;
import java.util.List;

import com.sg.intermediate.carlot.dto.Car;
import com.sg.intermediate.carlot.dto.CarKey;

public interface CarLotService {
    public Car getACar(String VIN);

    public List<Car> getAllCars();

    public List<Car> getCarsByColor(String color);

    public List<Car> getCarsInBudget(BigDecimal maxPrice);

    public List<Car> getCarByMakeAndModel(String make, String model);

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
            throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException,
            OverpaidPriceException,
            UnderpaidPriceException;
}
