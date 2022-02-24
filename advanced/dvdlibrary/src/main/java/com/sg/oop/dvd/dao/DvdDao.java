package com.sg.oop.dvd.dao;

import java.util.List;
import java.util.Map;

import com.sg.oop.dvd.dto.Dvd;

public interface DvdDao {

    public Dvd addDvd(Dvd dvdToAdd) throws DvdDaoException;

    public Dvd removeDvd(String titleName) throws DvdDaoException;

    public Dvd editDvd(Dvd newDvd) throws DvdDaoException;

    public Dvd[] dvdList() throws DvdDaoException;

    public Dvd dvdByTitle(String titleName) throws DvdDaoException;

    public List<Dvd> lookBackByYear(int numYears) throws DvdDaoException;

    public List<Dvd> dvdByMPAA(String MPAARating) throws DvdDaoException;

    public Map<String,List<Dvd>> dvdByDirector(String directorName) throws DvdDaoException;

    public List<Dvd> dvdByStudio(String studioName) throws DvdDaoException;

    public double dvdAverageAge() throws DvdDaoException;

    public Dvd oldestMovie() throws DvdDaoException;

    public Dvd newestMovie() throws DvdDaoException;
}
