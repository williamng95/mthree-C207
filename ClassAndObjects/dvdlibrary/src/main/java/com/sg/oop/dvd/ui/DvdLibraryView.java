package com.sg.oop.dvd.ui;

import java.time.LocalDate;

import com.sg.oop.dvd.dto.Dvd;

public class DvdLibraryView {
    private UserIO io;
    private String[] menuOptions = {
            "Add new DVD",
            "Remove a DVD",
            "Edit information for a DVD",
            "List All DVDs",
            "Find a DVD",
            "Exit"
    };

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    private Dvd getDvdInfo() {
        String title = io.readString("Movie Title:");
        String directorName = io.readString("Director's Name:");
        String studioName = io.readString("Studio Name");
        String mpaaRating = io.readString("MPAA rating:");
        LocalDate releaseDate = io.readDate("Movie release date:");
        int userRating = io.readInt("User rating 1-10:", 1, 10);
        String note = io.readString("Any other notes?");
        return new Dvd(title, directorName, studioName, mpaaRating, note, releaseDate, userRating);
    }

    private String getDvdTitle(String purpose) {
        return io.readString(String.format("Title of DVD to %s:", purpose.toLowerCase()));
    }

    public int mainMenuSelection() {
        printMenuBanner("Main menu");
        for (int i = 0; i < menuOptions.length; i++) {
            io.print(String.format("%d. %s", i + 1, menuOptions[i]));
        }
        return io.readInt("", 1, menuOptions.length);
    }

    private void printMenuBanner(String menuType) {
        io.print("");
        io.print(String.format("===== %s =====", menuType));
    }

    public Dvd getNewDvd() {
        printMenuBanner("Add a New DVD");
        return getDvdInfo();
    }

    public void endOpPause(){
        io.readString("Press Enter to continue...");
    }

    private void dvdDBStatus(Dvd dvdStatus, String nullPrompt, String valuePurpose) {
        if (dvdStatus == null) {
            io.print(nullPrompt);
        } else {
            io.print(String.format("Movie %s has been %s.", dvdStatus.getTitle(), valuePurpose));
        }

    }

    public void addDvdStatus(Dvd dvdStatus) {
        dvdDBStatus(dvdStatus, "New movie has been added.", "edited");
    }

    public String getRemoveDvdTitle() {
        printMenuBanner("Remove a DVD");
        return getDvdTitle("remove");
    }

    public void removeDvdStatus(Dvd dvdStatus){
        dvdDBStatus(dvdStatus, "No such DVD found", "removed");
    }

    public void printDvdList(Dvd[] dvdList) {
        for (Dvd dvd : dvdList) {
            io.print(dvd.toString());
        }

    }
}
