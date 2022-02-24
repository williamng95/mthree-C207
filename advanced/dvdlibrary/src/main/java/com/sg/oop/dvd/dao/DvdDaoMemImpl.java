package com.sg.oop.dvd.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (dvdToEdit != null) {
            return dvdDB.replace(dvdToEdit.getTitle(), dvdToEdit);
        }
        return null;
    }

    @Override
    public Dvd removeDvd(String removeTitlename) {
        return dvdDB.remove(removeTitlename);
    }

    @Override
    public List<Dvd> dvdByMPAA(String MPAARating) {
        return dvdDB.values().stream()
                .filter(dvd -> dvd.getMpaaRating().equals(MPAARating))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> lookBackByYear(int numYears) {
        return dvdDB.values().stream()
                .filter(dvd -> dvd.getReleaseDate().getYear() > (LocalDate.now().getYear() - numYears))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> dvdByDirector(String directorName) {
        return dvdDB.values().stream()
                .filter(dvd -> dvd.getDirectorName().equals(directorName))
                .collect(Collectors.groupingBy(Dvd::getMpaaRating));
    }

    @Override
    public List<Dvd> dvdByStudio(String studioName) {
        return dvdDB.values().stream()
                .filter(dvd -> dvd.getStudioName().equals(studioName))
                .collect(Collectors.toList());
    }

    @Override
    public double dvdAverageAge() {
        // require or else, as average provides an optionalDouble
        return dvdDB.values().stream()
                .mapToDouble(dvd -> dvd.getReleaseDate().until(LocalDate.now(), ChronoUnit.DAYS))
                .average()
                .orElse(Double.NaN);
    }

    public Dvd oldestMovie(){
        return dvdDB.values().stream()
        .max(Comparator.comparing((dvd)->dvd.getReleaseDate().until(LocalDate.now(), ChronoUnit.DAYS)))
        .orElse(null);
    }

    public Dvd newestMovie(){
        return dvdDB.values().stream()
        .min(Comparator.comparing((dvd)->dvd.getReleaseDate().until(LocalDate.now(), ChronoUnit.DAYS)))
        .orElse(null);
    }
}
