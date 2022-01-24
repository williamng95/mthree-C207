package com.sg.oop.dvd.controller;

import com.sg.oop.dvd.dao.DvdDao;
import com.sg.oop.dvd.ui.DvdLibraryView;

public class DvdController {
    private DvdDao dao;
    private DvdLibraryView ui;

    public DvdController(DvdDao dao, DvdLibraryView ui) {
        this.dao = dao;
        this.ui = ui;
    }

    public void run() {
        while (true) {
            try {
                switch (menuSelection()) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 4:
                        printDvdList();
                        break;
                    default:
                        return;
                }
                pause();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    private int menuSelection() {
        return ui.mainMenuSelection();
    }

    private void pause() {
        ui.endOpPause();
    }

    private void addDvd() {
        ui.addDvdStatus(dao.editDvd(ui.getNewDvd()));
    }

    private void removeDvd() {
        ui.removeDvdStatus(dao.removeDvd(ui.getRemoveDvdTitle()));
    }

    private void printDvdList() {
        ui.printDvdList(dao.dvdList());
    }

}
