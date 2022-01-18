package com.sg.oop.addressbook.ui;

import java.util.List;

import com.sg.oop.addressbook.dto.Address;

public class AddressBookView {
    private UserIO io;
    private String[] menuOptions = { "Add Address", "Delete Address", "Find Address", "List Address Count",
            "List All Addresses", "Exit" };

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetOption() {
        io.print("Initial Menu:");
        for (int i = 0; i < menuOptions.length; i++) {
            io.print(String.format("%d. %s", i + 1, menuOptions[i]));
        }
        return io.readInt("Please select the operation you wish to perform:", 1, menuOptions.length);
    }

    public Address getAddressInfo() {
        Address newAddress = new Address();
        newAddress.setFirstName(io.readString("Please Enter First Name:"));
        newAddress.setLastname(io.readString("Please Enter Last Name:"));
        newAddress.setStreetAddress(io.readString("Please Enter Street Address:"));
        newAddress.setTownName(io.readString("Please Enter Town Name:"));
        newAddress.setState(io.readString("Please Enter State Name:"));
        // enforce only 6 digit postal codes
        newAddress.setZipCode(io.readInt("Please Enter Zip Code:", 10000, 999999));

        return newAddress;
    }

    private void printAddress(Address address) {
        io.print("");
        io.print(address.toString());
    }

    private String getLastName(String findType) {
        return io.readString(String.format("Please enter last name of address to %s:", findType));
    }

    private void returnToMenu(String prompt) {
        String combinePrompt = String.format("%s Press 1 to go to Main Menu.", prompt);
        io.readInt(combinePrompt, 1, 1);
    }

    private void printBanner(String menuType) {
        String[] menuTokens = menuType.split(" ");
        io.print(String.format("%s Address %sMenu", menuTokens[0], menuTokens.length > 1 ? menuTokens[1] + " " : ""));
    }

    // option 1: add a new address
    public void printAddBanner() {
        printBanner("Add");
    }

    public void addAddressSuccess() {
        returnToMenu("Address added.");
    }

    // option 2: delete an address
    public void printDeleteBanner() {
        printBanner("Delete");
    }

    public String getDeleteName() {
        return getLastName("delete");
    }

    public boolean getDeleteConfirm() {
        if (io.readString("Really Delete? (y/n)").equals("y")) {
            return true;
        } else {
            return false;
        }
    }
    public void printDeleteSuccess(){
        returnToMenu("Address Deleted.");
    }

    // option 3: find an address given a last name
    public void printFindBanner() {
        printBanner("Find");
    }

    public String getFindName() {
        return getLastName("find");
    }

    public boolean printFindResults(Address addressFound) {
        if (addressFound!=null){
            printAddress(addressFound);
            return true;
        }else{
            io.print("No address found.");
            return false;
        }
    }

    public void defaultReturntoMenu() {
        returnToMenu("");
    }

    // option 4: count total number of addreses
    public void printCountBanner() {
        printBanner("List Count");
    }

    public void printAddressCount(int count) {
        returnToMenu(String.format("There are %d addresses in the book.", count));
    }

    // option 5: list all addresses
    public void printListBanner() {
        printBanner("List");
    }

    public void printAddressList(List<Address> addressList) {
        for (Address address : addressList) {
            printAddress(address);
        }
        io.print("");
    }

    public void printExceptionMessage(Exception e){
        io.print(e.getMessage());
    }

}
