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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((directorName == null) ? 0 : directorName.hashCode());
        result = prime * result + ((mpaaRating == null) ? 0 : mpaaRating.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
        result = prime * result + ((studioName == null) ? 0 : studioName.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + userRating;
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dvd other = (Dvd) obj;
        if (directorName == null) {
            if (other.directorName != null)
                return false;
        } else if (!directorName.equals(other.directorName))
            return false;
        if (mpaaRating == null) {
            if (other.mpaaRating != null)
                return false;
        } else if (!mpaaRating.equals(other.mpaaRating))
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (releaseDate == null) {
            if (other.releaseDate != null)
                return false;
        } else if (!releaseDate.equals(other.releaseDate))
            return false;
        if (studioName == null) {
            if (other.studioName != null)
                return false;
        } else if (!studioName.equals(other.studioName))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (userRating != other.userRating)
            return false;
        return true;
    }

}
