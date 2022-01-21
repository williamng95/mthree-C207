package com.sg.oop.dvd.dao;

import com.sg.oop.dvd.dto.Dvd;

public interface DvdDao {

    public boolean addDvd(Dvd dvdToAdd);

    public boolean removeDvd(Dvd dvdToRemove);

    public boolean editDvd(Dvd newDvd);

    public Dvd[] dvdList();

    public Dvd dvdByTitle(String titleName);

}
