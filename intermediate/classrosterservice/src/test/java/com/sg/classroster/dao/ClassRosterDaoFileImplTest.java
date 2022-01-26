package com.sg.classroster.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileWriter;
import java.util.List;

import com.sg.classroster.dto.Student;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassRosterDaoFileImplTest {
    ClassRosterDao testDao;

    @BeforeEach
    void setUp() throws Exception {
        String testFile = "testroster.txt";
        // blank the test file
        try (FileWriter out = new FileWriter(testFile)) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    void testGetAddStudent() throws Exception {
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");
        // add student
        testDao.addStudent(studentId, student);
        // retrieve back same stduent for check
        Student retrievedStudent = testDao.getStudent(studentId);

        // check equality
        assertEquals(student.getStudentId(), retrievedStudent.getStudentId(), "Checking Student ID");
        assertEquals(student.getFirstName(), retrievedStudent.getFirstName(), "Checking Student First Name");
        assertEquals(student.getLastName(), retrievedStudent.getLastName(), "Checking Student Last Name");
        assertEquals(student.getCohort(), retrievedStudent.getCohort(), "Checking Student Cohort");

    }

    @Test
    void testAddGetAllStudents() throws Exception {
        // Create our first student
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        // Create our second student
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");
        // add both students to dao
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);
        // retrieve back list of students
        List<Student> allStudents = testDao.getAllStudents();

        // check general contents
        assertNotNull(allStudents, "List must not be empty");
        assertEquals(2, allStudents.size(), "There should be 2 students in the list");

        // specifics check
        assertTrue(allStudents.contains(firstStudent),
                String.format("List should contain %s", firstStudent.getFirstName()));
        assertTrue(allStudents.contains(secondStudent),
                String.format("List should contain %s", secondStudent.getFirstName()));

    }

    @Test
    void testRemoveStudent() throws Exception {
        // Create our first student
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        // Create our second student
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");
        // add both students to dao
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);
        // remove first student
        Student removedStudent = testDao.removeStudent(firstStudent.getStudentId());

        assertEquals(firstStudent, removedStudent, "removed Student should be Ada");

        // check the remaining list

        List<Student> allStudents = testDao.getAllStudents();

        // check properties of list
        assertNotNull(allStudents, "List must not be empty");
        assertEquals(1, allStudents.size(), "There should be 1 student in the list");

        // specifics check
        assertFalse(allStudents.contains(firstStudent),
                String.format("List should not contain %s", firstStudent.getFirstName()));
        assertTrue(allStudents.contains(secondStudent),
                String.format("List should contain %s", secondStudent.getFirstName()));

        // remove second student
        removedStudent = testDao.removeStudent(secondStudent.getStudentId());

        assertEquals(secondStudent, removedStudent, "removed Student should be Charles");

        // check the remaining list

        allStudents = testDao.getAllStudents();

        // check if list is empty
        assertTrue(allStudents.isEmpty(), "There should not be any students remaining on the list");

        // specifics check
        Student retrievedStudent = testDao.getStudent(firstStudent.getStudentId());
        assertNull(retrievedStudent, "Ada was removed, should be null");
        retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
        assertNull(retrievedStudent, "Charles was removed, should be null");

    }

    @BeforeAll
    static void beforeClass() {

    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void afterClass() {

    }

}
