package com.sg.oop.addressbook.controller;

import com.sg.oop.addressbook.dao.AddressBookDao;
import com.sg.oop.addressbook.ui.AddressBookView;
import com.sg.oop.addressbook.ui.UserIO;
import com.sg.oop.addressbook.ui.UserIOConsoleImpl;

public class AddressBookController {
    private AddressBookDao dao;
    private AddressBookView ui;
    private UserIO io = new UserIOConsoleImpl();

    public AddressBookController(AddressBookDao dao, AddressBookView ui) {
        this.dao = dao;
        this.ui = ui;
    }

    public void run() {
        try {
            switch (getMenuSelction()) {
                case 1:
                    io.print("1.");
                    break;
                case 5:
                    dao.getAllAddress();
                default:
                    break;
            }
        } catch (Exception e) {
            io.print(e.getMessage());
        }
    }

    private int getMenuSelction() {
        return ui.displayMenuAndGetOption();
    }
    private void addAddressMenu(){
        if (dao.addAddress(ui.getAddressInfo())){
            ui.returnToMenu("");
        }
    }
}
