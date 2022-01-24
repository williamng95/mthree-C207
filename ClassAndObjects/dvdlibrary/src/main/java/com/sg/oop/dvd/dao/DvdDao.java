package com.sg.oop.dvd.dao;

import com.sg.oop.dvd.dto.Dvd;

public interface DvdDao {

    public Dvd addDvd(Dvd dvdToAdd);

    public Dvd removeDvd(String titleName);

    public Dvd editDvd(Dvd newDvd);

    public Dvd[] dvdList();

    public Dvd dvdByTitle(String titleName);

}
