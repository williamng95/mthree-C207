package com.sg.oop.dvd.dao;

import java.util.HashMap;
import java.util.Map;

import com.sg.oop.dvd.dto.Dvd;

public class DvdDaoMemImpl implements DvdDao {
    private Map<String, Dvd> dvdDB = new HashMap<>();

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
        if (dvdToEdit != null){
            return dvdDB.replace(dvdToEdit.getTitle(), dvdToEdit);
        }
        return null;
    }

    @Override
    public Dvd removeDvd(String removeTitlename) {
        return dvdDB.remove(removeTitlename);
    }
}
