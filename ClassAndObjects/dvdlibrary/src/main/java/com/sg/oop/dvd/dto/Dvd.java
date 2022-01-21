package com.sg.oop.dvd.dto;

import java.time.LocalDate;

public class Dvd {
    private String title, directorName, studioName, mpaaRating, note;
    private LocalDate releaseDate;
    private int userRating;

    @Override
    public String toString() {
        return "Dvd [directorName=" + directorName + ", mpaaRating=" + mpaaRating + ", note=" + note + ", releaseDate="
                + releaseDate + ", studioName=" + studioName + ", title=" + title + ", userRating=" + userRating + "]";
    }

    public Dvd(String title, String directorName, String studioName, String mpaaRating, String note,
            LocalDate releaseDate, int userRating) {
        this.title = title;
        this.directorName = directorName;
        this.studioName = studioName;
        this.mpaaRating = mpaaRating;
        this.note = note;
        this.releaseDate = releaseDate;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

}
