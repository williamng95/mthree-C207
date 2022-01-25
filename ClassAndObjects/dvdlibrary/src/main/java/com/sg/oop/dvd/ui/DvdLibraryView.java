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

    private Dvd getDvdInfo(String title) {
        if (title == null) {
            // share method for create and edit
            title = io.readString("Movie Title:");
        }
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

    private void printDvdInfo(Dvd dvd) {
        io.print(dvd.toString());
    }

    private void printMenuBanner(String menuType) {
        io.print("");
        io.print(String.format("===== %s =====", menuType));
    }

    public void endOpPause() {
        io.readString("Press Enter to continue...");
    }

    private void dvdDBStatus(Dvd dvdStatus, String nullPrompt, String valuePurpose) {
        if (dvdStatus == null) {
            io.print(nullPrompt);
        } else {
            io.print(String.format("Movie %s has been %s.", dvdStatus.getTitle(), valuePurpose));
        }

    }

    // 1. add DVD
    public Dvd getNewDvd() {
        printMenuBanner("Add a New DVD");
        return getDvdInfo(null);
    }

    public void addDvdStatus(Dvd dvdStatus) {
        dvdDBStatus(dvdStatus, "New movie has been added.", "edited");
    }

    // 2: remove DVD

    public String getRemoveDvdTitle() {
        printMenuBanner("Remove a DVD");
        return getDvdTitle("remove");
    }

    public void removeDvdStatus(Dvd dvdStatus) {
        dvdDBStatus(dvdStatus, "No such DVD found", "removed");
    }
    // 3. edit a DVD

    public String getEditDvdTitle() {
        printMenuBanner("Edit a DVD");
        return getDvdTitle("edit");
    }

    public Dvd getEditDvdDetails(String dvdTitle, Dvd currentDvd) {
        // only retrieve info from user if there is a DVD matching
        if (currentDvd != null){
            return getDvdInfo(dvdTitle);
        }else{
            return null;
        }
        
    }

    public void printEditStatus(Dvd editStatus){
        dvdDBStatus(editStatus, "No such DVD found", "edited");
    }

    // 4. print list of DVDs
    public void printDvdList(Dvd[] dvdList) {
        for (Dvd dvd : dvdList) {
            printDvdInfo(dvd);
        }

    }

    // 5. find a DVD

    public String getFindDvdTitle() {
        printMenuBanner("Search for DVD by title");
        return getDvdTitle("find");
    }

    public void printSearchResults(Dvd dvd) {
        if (dvd != null) {
            io.print("DVD found:");
            printDvdInfo(dvd);
        } else {
            io.print("No DVD with that title was found.");
        }
    }
}
