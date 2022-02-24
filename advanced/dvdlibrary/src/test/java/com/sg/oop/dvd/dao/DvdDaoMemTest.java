package com.sg.oop.dvd.dao;

import org.junit.jupiter.api.BeforeEach;

public class DvdDaoMemTest extends DvdDaoAbsTest {

    @Override
    @BeforeEach
    void setUp() {
        testdao = new DvdDaoMemImpl();
    }

}
