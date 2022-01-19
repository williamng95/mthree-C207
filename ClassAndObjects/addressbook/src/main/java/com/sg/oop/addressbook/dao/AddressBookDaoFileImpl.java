package com.sg.oop.addressbook.dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.sg.oop.addressbook.dto.Address;

public class AddressBookDaoFileImpl implements AddressBookDao {
    private AddressBookDao memImpl;
    public static final String ADDRESS_FILE = "addressbook.txt";
    public static final String DELIMITER = "::";

    public AddressBookDaoFileImpl(AddressBookDao memImpl) {
        this.memImpl = memImpl;
    }

    private String marshallAddress(Address nextAddress) {
        return String.join(DELIMITER, nextAddress.getFirstName(), nextAddress.getLastname(),
                nextAddress.getStreetAddress(), nextAddress.getTownName(), nextAddress.getState(),
                String.valueOf(nextAddress.getZipCode()));
    }

    private Address unmarshallAddress(String nextLine) {
        String[] addressToken = nextLine.split(DELIMITER);
        Address currentAddress = new Address();

        currentAddress.setFirstName(addressToken[0]);
        currentAddress.setLastname(addressToken[1]);
        currentAddress.setStreetAddress(addressToken[2]);
        currentAddress.setTownName(addressToken[3]);
        currentAddress.setState(addressToken[4]);
        currentAddress.setZipCode(Integer.parseInt(addressToken[5]));

        return currentAddress;

    }

    private void loadAddressBook() throws AddressBookDaoException {
        try (Scanner filesScan = new Scanner(Paths.get(ADDRESS_FILE))) {
            while (filesScan.hasNextLine()) {
                Address currentAddress = unmarshallAddress(filesScan.nextLine());
                memImpl.addAddress(currentAddress);
            }
        } catch (Exception e) {
            throw new AddressBookDaoException("load failed.");
        }
    }

    private void writeAddressBook() throws AddressBookDaoException{
        try (PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE))) {
            for (Address nextAddress : memImpl.getAllAddress()) {
                out.println(marshallAddress(nextAddress));
                out.flush();
            }
        } catch (Exception e) {
            throw new AddressBookDaoException("write failed.");
        }
    }

    @Override
    public Address addAddress(Address addressToAdd) throws AddressBookDaoException {
        loadAddressBook();
        Address retAddress = memImpl.addAddress(addressToAdd);
        writeAddressBook();
        return retAddress;
    }

    @Override
    public Address addressByLastName(String lastName) throws AddressBookDaoException {
        loadAddressBook();
        return memImpl.addressByLastName(lastName);

    }

    @Override
    public int countAddress() throws AddressBookDaoException {
        loadAddressBook();
        return memImpl.countAddress();
    }

    @Override
    public List<Address> getAllAddress() throws AddressBookDaoException {
        loadAddressBook();
        return memImpl.getAllAddress();
    }

    @Override
    public Address removeAddress(Address addressToRemove) throws AddressBookDaoException {
        loadAddressBook();
        Address prevAddress = memImpl.removeAddress(addressToRemove);
        writeAddressBook();
        return prevAddress;
    }

}
