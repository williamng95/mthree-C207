package com.sg.intermediate.carlot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sg.intermediate.carlot.dto.Car;

public class CarLotDaoMemImpl implements CarLotDao {
    // no tests for dao, since all are one liner bodies.
    Map<String, Car> carDB = new HashMap<>();

    @Override
    public Car addCar(String VIN, Car car) {
        return carDB.put(VIN, car);
    }

    @Override
    public void editCar(String VIN, Car car) {
        carDB.replace(VIN, car);
    }

    @Override

    public Car getCar(String VIN) {
        return carDB.get(VIN);
    }

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(carDB.values());
    }

    @Override
    public Car removeCar(String VIN) {
        return carDB.remove(VIN);
    }

}
