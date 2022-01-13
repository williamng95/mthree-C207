package com.sg.oop.addressbook.ui;

import com.sg.oop.addressbook.dto.Address;

public class AddressBookView {
    private UserIO io;
    private String[] menuOptions = { "Add Address", "Delete Address", "Find Address", "List Address Count",
            "List All Addresses" };

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetOption() {
        io.print("Initial Menu:");
        for (int i = 0; i < menuOptions.length; i++) {
            io.print(String.format("%d. %s", i + 1, menuOptions[i]));
        }
        return io.readInt("Please select the operation you wish to perform:");
    }

    public Address getAddressInfo() {
        Address newAddress = new Address();
        newAddress.setFirstName(io.readString("Please Enter First Name:"));
        newAddress.setLastname(io.readString("Please Enter Last Name:"));
        newAddress.setState(io.readString("Please Enter State Name:"));
        // enforce only 6 digit postal codes
        newAddress.setZipCode(io.readInt("Please Enter Zip Code:", 10000, 999999));

        return newAddress;
    }

    public void returnToMenu(String prompt){
        String combinePrompt = String.format("%s Press 1 to go to Main Menu.", prompt);
        io.readInt(combinePrompt, 1, 1);
    }

}
