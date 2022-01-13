package com.sg.oop.addressbook;

import com.sg.oop.addressbook.controller.AddressBookController;
import com.sg.oop.addressbook.dao.AddressBookDao;
import com.sg.oop.addressbook.dao.AddressBookDaoMemImpl;
import com.sg.oop.addressbook.ui.AddressBookView;
import com.sg.oop.addressbook.ui.UserIOConsoleImpl;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        AddressBookView ui = new AddressBookView(new UserIOConsoleImpl());
        AddressBookDao dao = new AddressBookDaoMemImpl();
        AddressBookController controller = new AddressBookController(dao, ui);
        controller.run();
    }
}
