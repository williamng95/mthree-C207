package com.sg.intermediate.carlot.dao;

import java.util.List;

import com.sg.intermediate.carlot.dto.Car;

public interface CarLotDao {
    /**
     * Add a new car to the database
     * 
     * @param VIN VIN of the car
     * @param car car object to store
     * @return car object previously associated with VIN, null otherwise.
     */
    public Car addCar(String VIN, Car car);

    /**
     * Get car from database
     * 
     * @param VIN VIN of the car
     * @return car object associated with VIN, null otherwise.
     */
    public Car getCar(String VIN);

    /**
     * Generate list of all cars currently in database
     * 
     * @return ArrayList of cars
     */
    public List<Car> getCars();

    /**
     * Replace the car of the given VIN
     * 
     * @param VIN VIN to edit
     * @param car new car object to associate
     */
    public void editCar(String VIN, Car car);

    /**
     * remove a car from the database
     * 
     * @param VIN VIN of the car to remove
     * @return car object previously associated with the VIN
     */
    public Car removeCar(String VIN);
}
