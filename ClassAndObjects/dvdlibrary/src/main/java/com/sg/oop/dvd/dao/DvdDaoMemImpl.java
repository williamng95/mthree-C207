package com.sg.oop.dvd.dao;

import java.util.HashMap;
import java.util.Map;

import com.sg.oop.dvd.dto.Dvd;

public class DvdDaoMemImpl implements DvdDao {
    private Map<String, Dvd> dvdDB = new HashMap<>();

    public void loadDvdFile(String filePath) {
        // TODO Auto-generated method stub

    }

    public void saveDvdFile(String filePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public Dvd addDvd(Dvd dvdToAdd) {
        return dvdDB.put(dvdToAdd.getTitle(), dvdToAdd);
    }

    @Override
    public Dvd dvdByTitle(String titleName) {
        return dvdDB.get(titleName);
    }

    @Override
    public Dvd[] dvdList() {
        return dvdDB.values().toArray(new Dvd[0]);
    }

    @Override
    public Dvd editDvd(Dvd dvdToEdit) {
        return dvdDB.replace(dvdToEdit.getTitle(), dvdToEdit);
    }

    @Override
    public Dvd removeDvd(String removeTitlename) {
        return dvdDB.remove(removeTitlename);
    }
}
