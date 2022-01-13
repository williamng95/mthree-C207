package com.sg.oop.addressbook.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sg.oop.addressbook.dto.Address;

public class AddressBookDaoMemImpl implements AddressBookDao {
    // keep a map of address list, associate with lastname.
    protected Map<String, List<Address>> addressBook = new HashMap<>();

    @Override
    public boolean addAddress(Address addressToAdd) {
        String lastName = addressToAdd.getLastname();
        List<Address> addressAsList = new ArrayList<>();
        addressAsList.add(addressToAdd);
        if (addressBook.containsKey(lastName)){
            addressBook.get(lastName).addAll(addressAsList);
            return true;
        }
        addressBook.put(lastName, addressAsList);
        return true;
    }

    @Override
    public List<Address> addressByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countAddress() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Address> getAllAddress() {
        List<Address> allAddress = new ArrayList<>();
        System.out.println(addressBook.values().toString());
        return allAddress;
    }

    @Override
    public Address removeAddress(Address addressToRemove) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
