package com.sg.oop.addressbook.controller;

import com.sg.oop.addressbook.dao.AddressBookDao;
import com.sg.oop.addressbook.dao.AddressBookDaoException;
import com.sg.oop.addressbook.dto.Address;
import com.sg.oop.addressbook.ui.AddressBookView;

public class AddressBookController {
    private AddressBookDao dao;
    private AddressBookView ui;

    public AddressBookController(AddressBookDao dao, AddressBookView ui) {
        this.dao = dao;
        this.ui = ui;
    }

    public void run() {
        boolean continueRun = true;
        while (continueRun) {
            try {
                switch (getMenuSelction()) {
                    case 1:
                        addAddressMenu();
                        break;
                    case 2:
                        deleteAddress();
                        break;
                    case 3:
                        findAddress();
                        break;
                    case 4:
                        editAddress();
                        break;
                    case 5:
                        addressCount();
                        break;
                    case 6:
                        displayAllAddress();
                        break;
                    case 7:
                    default:
                        continueRun = false;
                        break;
                }
            } catch (Exception e) {
                ui.printExceptionMessage(e);
            }
        }
    }

    private int getMenuSelction() {
        return ui.displayMenuAndGetOption();
    }

    private void addAddressMenu() throws AddressBookDaoException {
        ui.printAddBanner();
        ui.putAddressResult(dao.addAddress(ui.getAddressInfo()));
    }

    private void deleteAddress() throws AddressBookDaoException {
        ui.printDeleteBanner();
        Address addressToRemove = dao.addressByLastName(ui.getDeleteName());
        if (ui.printFindResults(addressToRemove) && ui.getDeleteConfirm()) {
            dao.removeAddress(addressToRemove);
            ui.printDeleteSuccess();
        } else {
            ui.defaultReturntoMenu();
        }

    }

    private void findAddress() throws AddressBookDaoException {
        ui.printFindBanner();
        ui.printFindResults(dao.addressByLastName(ui.getFindName()));
        ui.defaultReturntoMenu();
    }

    private void editAddress() throws AddressBookDaoException {
        ui.printEditBanner();
        ui.putAddressResult(dao.addAddress(ui.getAddressInfo()));
    }

    private void addressCount() throws AddressBookDaoException {
        ui.printCountBanner();
        ui.printAddressCount(dao.countAddress());
    }

    private void displayAllAddress() throws AddressBookDaoException {
        ui.printListBanner();
        ui.printAddressList(dao.getAllAddress());
    }
}
