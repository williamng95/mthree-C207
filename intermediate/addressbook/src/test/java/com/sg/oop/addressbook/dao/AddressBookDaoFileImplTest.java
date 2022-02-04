package com.sg.oop.addressbook.dao;

import java.io.FileWriter;

import org.junit.jupiter.api.BeforeEach;

public class AddressBookDaoFileImplTest  extends AddressBookDaoAbsTest{

    @Override
    @BeforeEach
    void setUp() throws Exception{
        String testPath = "test.txt";
        new FileWriter(testPath);
        testdao = new AddressBookDaoFileImpl(new AddressBookDaoMemImpl(), testPath);
        
    }
    
}
