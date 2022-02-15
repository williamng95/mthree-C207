package com.sg.oop.dvd.dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

import com.sg.oop.dvd.dto.Dvd;

public class DvdDaoFileImpl implements DvdDao {
    // a file writing wrapper for dao, able to inject other implementations/ use
    // default memory backend
    private DvdDao memImpl;
    private final String DELIMITER = "::";
    private final String FILE_PATH;

    public DvdDaoFileImpl() {
        this("dvdLibrary.txt");
    }

    public DvdDaoFileImpl(String filePath) {
        this.memImpl = new DvdDaoMemImpl();
        this.FILE_PATH = filePath;
    }

    public DvdDaoFileImpl(DvdDao memImpl, String filePath) {
        this.memImpl = memImpl;
        this.FILE_PATH = filePath;
    }

    public DvdDaoFileImpl(DvdDao memImpl) {
        this(memImpl, "dvdLibrary.txt");
    }

    private String marshallDvd(Dvd dvdToMarshall) {
        return String.join(DELIMITER, dvdToMarshall.getTitle(), dvdToMarshall.getDirectorName(),
                dvdToMarshall.getStudioName(), dvdToMarshall.getMpaaRating(), dvdToMarshall.getNote(),
                dvdToMarshall.getReleaseDate().toString(),
                String.valueOf(dvdToMarshall.getUserRating()));
    }

    private Dvd unmarshallDvd(String parseLine) {
        String[] dvdToken = parseLine.split(DELIMITER);

        return new Dvd(dvdToken[0], dvdToken[1], dvdToken[2], dvdToken[3], dvdToken[4], LocalDate.parse(dvdToken[5]),
                Integer.parseInt(dvdToken[6]));

    }

    private void writeFile() throws DvdDaoException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Dvd currentDvd : memImpl.dvdList()) {
                out.println(marshallDvd(currentDvd));
                out.flush();
            }
        } catch (Exception e) {
            throw new DvdDaoException("file write failed.");
        }
    }

    private void loadFile() throws DvdDaoException {
        try (Scanner fileScan = new Scanner(Paths.get(FILE_PATH))) {
            while (fileScan.hasNextLine()) {
                memImpl.addDvd(unmarshallDvd(fileScan.nextLine()));
            }
        } catch (Exception e) {
            throw new DvdDaoException("file read failed.");
        }
    }

    // interface methods
    @Override
    public Dvd addDvd(Dvd dvdToAdd) throws DvdDaoException {
        loadFile();
        Dvd result = memImpl.addDvd(dvdToAdd);
        writeFile();
        return result;
    }

    @Override
    public Dvd dvdByTitle(String titleName) throws DvdDaoException {
        loadFile();
        return memImpl.dvdByTitle(titleName);
    }

    @Override
    public Dvd[] dvdList() throws DvdDaoException {
        loadFile();
        return memImpl.dvdList();
    }

    @Override
    public Dvd editDvd(Dvd newDvd) throws DvdDaoException {
        loadFile();
        Dvd result = memImpl.editDvd(newDvd);
        writeFile();
        return result;
    }

    @Override
    public Dvd removeDvd(String titleName) throws DvdDaoException {
        loadFile();
        Dvd result = memImpl.removeDvd(titleName);
        writeFile();
        return result;
    }

}
