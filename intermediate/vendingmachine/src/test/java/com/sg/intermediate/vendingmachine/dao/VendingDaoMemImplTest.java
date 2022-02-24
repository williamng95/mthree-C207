package com.sg.intermediate.vendingmachine.dao;

import org.junit.jupiter.api.BeforeEach;

public class VendingDaoMemImplTest extends VendingDaoTest{

    @BeforeEach
    void setUp() {
        dao = new VendingDaoMemImpl();
    }
    
}
