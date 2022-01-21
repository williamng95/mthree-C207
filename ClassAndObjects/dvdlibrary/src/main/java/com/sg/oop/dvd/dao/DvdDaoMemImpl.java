package com.sg.oop.dvd.dao;

import java.util.HashSet;
import java.util.Set;

import com.sg.oop.dvd.dto.Dvd;

public class DvdDaoMemImpl implements DvdDao{
    private Set<Dvd> dvdDB = new HashSet<>();

    public void loadDvdFile(String filePath) {
        // TODO Auto-generated method stub
        
    }

    public void saveDvdFile(String filePath) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean addDvd(Dvd dvdToAdd) {
        return dvdDB.add(dvdToAdd);
    }

    @Override
    public Dvd dvdByTitle(String titleName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dvd[] dvdList() {
        return dvdDB.toArray(new Dvd[0]);
    }

    @Override
    public boolean editDvd(Dvd newDvd) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeDvd(Dvd dvdToRemove) {
        return dvdDB.remove(dvdToRemove);
    }

    
    
    
}
