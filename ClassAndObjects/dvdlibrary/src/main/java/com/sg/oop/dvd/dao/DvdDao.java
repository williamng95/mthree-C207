package com.sg.oop.dvd.dao;

import com.sg.oop.dvd.dto.Dvd;

public interface DvdDao {

    public Dvd addDvd(Dvd dvdToAdd) throws DvdDaoException;

    public Dvd removeDvd(String titleName) throws DvdDaoException;

    public Dvd editDvd(Dvd newDvd) throws DvdDaoException;

    public Dvd[] dvdList() throws DvdDaoException;

    public Dvd dvdByTitle(String titleName) throws DvdDaoException;

}
