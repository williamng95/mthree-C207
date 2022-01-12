package com.sg.oop.addressbook.dao;

import java.util.List;

import com.sg.oop.addressbook.dto.Address;

public interface AddressBookDao {
    /**
     * Adds a given address to the dao.
     * if object already exists, return false.
     * 
     * @param addressToAdd the address object to add
     * @return if creation of entry is successful
     */
    boolean addAddress(Address addressToAdd);

    /**
     * remove the given address object from the dao
     * 
     * @param addressToRemove the address object to remove
     * @return the address object if found
     */
    Address removeAddress(Address addressToRemove);

    /**
     * find the list of addresses, given a last name
     * 
     * @param lastName
     * @return List of address associated with lastName.
     */
    List<Address> addressByLastName(String lastName);

    /**
     * Counts the number of addresses contained in the dao
     * 
     * @return number of addresses in dao
     */
    int countAddress();

    /**
     * Return all of the Addresses in the AddressBookDao
     * 
     * @return list of all address objects in the dao
     */
    List<Address> getAllAddress();
}
