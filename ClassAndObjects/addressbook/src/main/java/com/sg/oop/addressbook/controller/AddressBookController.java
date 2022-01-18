package com.sg.oop.addressbook.controller;

import com.sg.oop.addressbook.dao.AddressBookDao;
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
                        addressCount();
                        break;
                    case 5:
                        displayAllAddress();
                        break;
                    case 6:
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

    private void addAddressMenu() {
        ui.printAddBanner();
        if (dao.addAddress(ui.getAddressInfo())) {
            ui.addAddressSuccess();
        }
    }

    private void deleteAddress() {
        ui.printDeleteBanner();
        Address addressToRemove = dao.addressByLastName(ui.getDeleteName());
        if (ui.printFindResults(addressToRemove) && ui.getDeleteConfirm()){
            dao.removeAddress(addressToRemove);
            ui.printDeleteSuccess();
        }else{
            ui.defaultReturntoMenu();
        }

    }

    private void findAddress() {
        ui.printFindBanner();
        ui.printFindResults(dao.addressByLastName(ui.getFindName()));
        ui.defaultReturntoMenu();
    }

    private void addressCount() {
        ui.printCountBanner();
        ui.printAddressCount(dao.countAddress());
    }

    private void displayAllAddress() {
        ui.printListBanner();
        ui.printAddressList(dao.getAllAddress());
    }
}
