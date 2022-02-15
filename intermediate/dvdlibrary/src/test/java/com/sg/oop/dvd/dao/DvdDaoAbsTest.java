package com.sg.oop.dvd.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.sg.oop.dvd.dto.Dvd;

import org.junit.jupiter.api.Test;

public abstract class DvdDaoAbsTest {
        DvdDao testdao;

        Dvd dvd1 = new Dvd("Matirx", "Wachoski", "Fox", "R", "", LocalDate.of(1999, 1, 1), 10);
        Dvd dvd2 = new Dvd("Emoji", "Leondis", "Sony", "PG", "bad", LocalDate.of(2017, 1, 1), 0);

        // to implement setup tests separately
        abstract void setUp() throws Exception;

        @Test
        void testAddGetDvd() throws DvdDaoException {
                assertEquals(0, testdao.dvdList().length, "There should be 0 items");

                testdao.addDvd(dvd1);

                Dvd retrievedDvd = testdao.dvdByTitle(dvd1.getTitle());

                assertEquals(dvd1.getTitle(), retrievedDvd.getTitle(),
                                String.format("Title should be %s, but got %s", dvd1.getTitle(),
                                                retrievedDvd.getTitle()));
                assertEquals(dvd1.getDirectorName(), retrievedDvd.getDirectorName(), String
                                .format("Director should be %s, but got %s", dvd1.getDirectorName(),
                                                retrievedDvd.getDirectorName()));
                assertEquals(dvd1.getStudioName(), retrievedDvd.getStudioName(),
                                String.format("Studio should be %s, but got %s", dvd1.getStudioName(),
                                                retrievedDvd.getStudioName()));
                assertEquals(dvd1.getMpaaRating(), retrievedDvd.getMpaaRating(), String
                                .format("MPAA rating should be %s, but got %s", dvd1.getMpaaRating(),
                                                retrievedDvd.getMpaaRating()));
                assertEquals(dvd1.getNote(), retrievedDvd.getNote(),
                                String.format("Note should be %s, but got %s", dvd1.getNote(), retrievedDvd.getNote()));
                assertEquals(dvd1.getReleaseDate(), retrievedDvd.getReleaseDate(),
                                String.format("Release Date should be %s, but got %s", dvd1.getReleaseDate().toString(),
                                                retrievedDvd.getReleaseDate().toString()));
                assertEquals(dvd1.getUserRating(), retrievedDvd.getUserRating(), String
                                .format("User rating should be %d, but got %d", dvd1.getUserRating(),
                                                retrievedDvd.getUserRating()));

                // try retrieving again, ite should still be there.
                assertEquals(dvd1, testdao.dvdByTitle(dvd1.getTitle()));

        }

        @Test
        void testDvdList() throws DvdDaoException {

                List<Dvd> retrievedList = Arrays.asList(testdao.dvdList());
                assertNotNull(retrievedList, "List should not be null");

                testdao.addDvd(dvd1);
                testdao.addDvd(dvd2);

                retrievedList = Arrays.asList(testdao.dvdList());

                assertNotNull(retrievedList, "List should not be null");
                assertEquals(2, retrievedList.size(), "There should be 2 dvds total");

                for (Dvd dvd : new Dvd[] { dvd1, dvd2 }) {
                        assertTrue(retrievedList.contains(dvd),
                                        String.format("Array should contain %s", dvd.toString()));
                }

        }

        @Test
        void testEditDvd() throws DvdDaoException {
                Dvd newDvd = new Dvd("Matirx", "Wachowski", "Fox", "R", "", LocalDate.of(1999, 10, 1), 7);

                // no items yet, should be null and no insertion
                assertNull(testdao.editDvd(newDvd));
                assertEquals(0, testdao.dvdList().length);
                assertNull(testdao.dvdByTitle(newDvd.getTitle()));

                // act
                testdao.addDvd(dvd1);
                testdao.editDvd(newDvd);
                Dvd retrievedDvd = testdao.dvdByTitle(dvd1.getTitle());

                // assert
                // only 3 fields were changed

                assertEquals(newDvd.getDirectorName(), retrievedDvd.getDirectorName(),
                                "Director name should have changed");
                assertEquals(newDvd.getReleaseDate(), retrievedDvd.getReleaseDate(),
                                "Release Date should have changed");
                assertEquals(newDvd.getUserRating(), retrievedDvd.getUserRating(), "User should have changed");

        }

        @Test
        void testRemoveDvd() throws DvdDaoException {
                testdao.addDvd(dvd1);
                testdao.addDvd(dvd2);

                Dvd[] dvdList = { dvd1, dvd2 };
                for (int i = 0; i < dvdList.length; i++) {
                        Dvd dvd = dvdList[i];
                        Dvd removeDvd = testdao.removeDvd(dvd.getTitle());
                        // remaining items
                        List<Dvd> remainingDvd = Arrays.asList(testdao.dvdList());

                        assertEquals(dvd, removeDvd, String.format("Removed Dvd should be %s instead got %s",
                                        dvd.toString(), removeDvd.toString()));
                        assertEquals(1 - i, remainingDvd.size(), String.format("There should be %d dvds left", 1 - i));
                        assertFalse(remainingDvd.contains(dvd), String.format("%s should not exist", dvd.toString()));
                        for (int j = i + 1; j < dvdList.length; j++) {
                                // iterate over remaining items
                                assertTrue(remainingDvd.contains(dvdList[j]),
                                                String.format("%s should be in remaining list", dvdList[j].toString()));
                        }

                }
        }
}
