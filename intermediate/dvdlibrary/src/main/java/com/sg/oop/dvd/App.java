package com.sg.oop.dvd;

import com.sg.oop.dvd.controller.DvdController;
import com.sg.oop.dvd.dao.DvdDaoFileImpl;
import com.sg.oop.dvd.ui.DvdLibraryView;
import com.sg.oop.dvd.ui.UserIOConsoleImpl;

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
        DvdController dvdControl = new DvdController(new DvdDaoFileImpl(), new DvdLibraryView(new UserIOConsoleImpl()));
        dvdControl.run();
    }
}
