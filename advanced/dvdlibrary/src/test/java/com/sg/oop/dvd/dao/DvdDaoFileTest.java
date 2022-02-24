package com.sg.oop.dvd.dao;

import java.io.FileWriter;

import org.junit.jupiter.api.BeforeEach;

public class DvdDaoFileTest extends DvdDaoAbsTest {

    @Override
    @BeforeEach
    void setUp() throws Exception {
        String testPath = "test.txt";
        new FileWriter(testPath);
        testdao = new DvdDaoFileImpl(testPath);
    }

}
