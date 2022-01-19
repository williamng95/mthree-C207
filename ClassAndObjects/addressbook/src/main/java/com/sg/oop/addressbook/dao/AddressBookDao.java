package com.sg.oop.addressbook.dao;

import java.util.List;

import com.sg.oop.addressbook.dto.Address;

public interface AddressBookDao {
    /**
     * Adds a given address to the dao.
     * if object already exists, return the previously associated address.
     * 
     * @param addressToAdd the address object to add
     * @return address object previously associated with last name
     * @throws AddressBookDaoException
     */
    Address addAddress(Address addressToAdd) throws AddressBookDaoException;

    /**
     * remove the given address object from the dao
     * 
     * @param addressToRemove the address object to remove
     * @return the address object if found
     * @throws AddressBookDaoException
     */
    Address removeAddress(Address addressToRemove) throws AddressBookDaoException;

    /**
     * find the list of addresses, given a last name
     * 
     * @param lastName
     * @return last address associated with last name.
     * @throws AddressBookDaoException
     */
    Address addressByLastName(String lastName) throws AddressBookDaoException;

    /**
     * Counts the number of addresses contained in the dao
     * 
     * @return number of addresses in dao
     * @throws AddressBookDaoException
     */
    int countAddress() throws AddressBookDaoException;

    /**
     * Return all of the Addresses in the AddressBookDao
     * 
     * @return list of all address objects in the dao
     * @throws AddressBookDaoException
     */
    List<Address> getAllAddress() throws AddressBookDaoException;
}
