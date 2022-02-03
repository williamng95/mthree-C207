package com.sg.oop.addressbook.dao;

import org.junit.jupiter.api.BeforeEach;

// @ExtendWith(AddressBookDaoAbsTest.class)
public class AddressBookDaoMemImplTest extends AddressBookDaoAbsTest {

    @Override
    @BeforeEach
    void setUp() {
        testdao = new AddressBookDaoMemImpl();
    }

}
