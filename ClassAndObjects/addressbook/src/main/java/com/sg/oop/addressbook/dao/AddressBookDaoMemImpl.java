package com.sg.oop.addressbook.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sg.oop.addressbook.dto.Address;

public class AddressBookDaoMemImpl implements AddressBookDao {
    // keep a map of address, associate with lastname. Assume last name is unique key, no duplicates
    protected Map<String, Address> addressBook = new HashMap<>();

    @Override
    public boolean addAddress(Address addressToAdd) {
        addressBook.put(addressToAdd.getLastname(), addressToAdd);
        return true;
    }

    @Override
    public Address addressByLastName(String lastName) {
        return addressBook.get(lastName);
    }

    @Override
    public int countAddress() {
        return addressBook.values().size();
    }

    @Override
    public List<Address> getAllAddress() {
        return new ArrayList<Address>(addressBook.values());
    }

    @Override
    public Address removeAddress(Address addressToRemove) {
        return addressBook.remove(addressToRemove.getLastname());
    }
    
}
