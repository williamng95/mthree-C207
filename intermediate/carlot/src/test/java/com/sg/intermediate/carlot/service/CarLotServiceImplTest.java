package com.sg.intermediate.carlot.service;


import com.sg.intermediate.carlot.dao.CarLotDaoMemImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarLotServiceImplTest {
    CarLotServiceImpl testService;
    @BeforeEach
    void setUp() {
        testService = new CarLotServiceImpl(new CarLotDaoMemImpl());        
    }

    @Test
    void testDiscountCar() {

    }

    @Test
    void testGetACar() {

    }

    @Test
    void testGetAllCars() {

    }

    @Test
    void testGetCarByMakeAndModel() {

    }

    @Test
    void testGetCarsByColor() {

    }

    @Test
    void testGetCarsInBudget() {

    }

    @Test
    void testSellCar() {

    }
}
