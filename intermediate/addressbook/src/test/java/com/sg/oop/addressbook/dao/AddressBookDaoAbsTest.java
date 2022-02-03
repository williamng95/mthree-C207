package com.sg.oop.addressbook.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.sg.oop.addressbook.dto.Address;

import org.junit.jupiter.api.Test;

public abstract class AddressBookDaoAbsTest {
    // base test case
    // static AddressBookDao testdao;
    AddressBookDao testdao;
    final Address ADDRESS_1, ADDRESS_2;

    /**
     * @param ADDRESS_1
     * @param ADDRESS_2
     */
    public AddressBookDaoAbsTest() {
        // pre arrange into easy to use constant variables
        // set first address
        Address address1 = new Address();
        address1.setFirstName("John");
        address1.setLastname("Doe");
        address1.setStreetAddress("123 Main Street");
        address1.setTownName("Hometown");
        address1.setState("OH");
        address1.setZipCode(123456);

        this.ADDRESS_1 = address1;

        Address address2 = new Address();
        address2.setFirstName("Sally");
        address2.setLastname("Jones");
        address2.setStreetAddress("45 Elm Street");
        address2.setTownName("Applgrove");
        address2.setState("AK");
        address2.setZipCode(44231);

        this.ADDRESS_2 = address2;
    }

    abstract void setUp();

    @Test
    void testAddGetAddress() throws AddressBookDaoException {
        // arrange
        testdao.addAddress(ADDRESS_1);
        // act
        Address retrieveAddress = testdao.addressByLastName(ADDRESS_1.getLastname());

        // assert
        assertEquals(ADDRESS_1.getFirstName(), retrieveAddress.getFirstName(), "First Name does not match.");
        assertEquals(ADDRESS_1.getLastname(), retrieveAddress.getLastname(), "Last Name does not match.");
        assertEquals(ADDRESS_1.getStreetAddress(), retrieveAddress.getStreetAddress(),
                "Street Address does not match.");
        assertEquals(ADDRESS_1.getTownName(), retrieveAddress.getTownName(), "Town Name does not match.");
        assertEquals(ADDRESS_1.getState(), retrieveAddress.getState(), "State Name does not match.");
        assertEquals(ADDRESS_1.getZipCode(), retrieveAddress.getZipCode(), "Zip code does not match.");

    }

    @Test

    void testGetCountAllAddress() throws AddressBookDaoException {
        testdao.addAddress(ADDRESS_1);
        testdao.addAddress(ADDRESS_2);

        // test count first
        assertEquals(2, testdao.countAddress(), "There should only be 2 addresses in the address book.");

        // test get all
        List<Address> allAddress = testdao.getAllAddress();
        // check contents
        assertNotNull(allAddress, "List should not be null");
        assertEquals(2, allAddress.size(), "There should only be 2 addresses in the address book.");
        // check items
        for (Address address : new Address[] { ADDRESS_1, ADDRESS_2 }) {
            System.out.println(address);
            assertTrue(allAddress.contains(address),
                    String.format("List should contain the following address:%n%s%n", address.toString()));
        }

    }

    @Test

    void testRemoveAddress() throws AddressBookDaoException {

        testdao.addAddress(ADDRESS_1);
        testdao.addAddress(ADDRESS_2);

        Address removedAddress = testdao.removeAddress(ADDRESS_1);
        // check removal
        assertEquals(ADDRESS_1, removedAddress, String.format("Removed Address should be:%n%s%n", ADDRESS_1));
        // check remaining items
        List<Address> allAddress = testdao.getAllAddress();

        assertNotNull(allAddress, "List should not be null");
        assertEquals(1, allAddress.size(), "There should only be one address remaining");

        assertFalse(allAddress.contains(ADDRESS_1), String.format("List should not contain:%n%s%n", ADDRESS_1));
        assertTrue(allAddress.contains(ADDRESS_2), String.format("List should contain:%n%s%n", ADDRESS_2));
        // remove once more
        removedAddress = testdao.removeAddress(ADDRESS_2);

        // check remaining items
        allAddress = testdao.getAllAddress();

        assertTrue(allAddress.isEmpty(), "There should only be no addresses left");

        for (Address address : new Address[] { ADDRESS_1, ADDRESS_2 }) {
            assertNull(testdao.addressByLastName(address.getLastname()),
                    String.format("Null expected for:%n%s%n", address));
        }

    }

}
