package com.sg.oop.dvd.controller;

import com.sg.oop.dvd.dao.DvdDao;
import com.sg.oop.dvd.dao.DvdDaoException;
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
                    case 3:
                        editDvd();
                    case 4:
                        printDvdList();
                        break;
                    case 5:
                        findDvdByTitle();
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

    private void addDvd() throws DvdDaoException {
        ui.addDvdStatus(dao.addDvd(ui.getNewDvd()));
    }

    private void removeDvd() throws DvdDaoException {
        ui.removeDvdStatus(dao.removeDvd(ui.getRemoveDvdTitle()));
    }

    private void editDvd() throws DvdDaoException{
        String editTitle= ui.getEditDvdTitle();
        ui.printEditStatus(dao.editDvd(ui.getEditDvdDetails(editTitle, dao.dvdByTitle(editTitle))));
    }

    private void printDvdList() throws DvdDaoException {
        ui.printDvdList(dao.dvdList());
    }

    private void findDvdByTitle() throws DvdDaoException{
        ui.printSearchResults(dao.dvdByTitle(ui.getFindDvdTitle()));
    }

}
