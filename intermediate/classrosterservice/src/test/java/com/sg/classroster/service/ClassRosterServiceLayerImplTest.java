package com.sg.classroster.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassRosterServiceLayerImplTest {
    private ClassRosterServiceLayer service;

    /**
     * intialize service with stub dao and audit
     */
    public ClassRosterServiceLayerImplTest() {
        service = new ClassRosterServiceLayerImpl(new ClassRosterDaoStubImpl(), new ClassRosterAuditDaoStubImpl());
    }

    @Test
    void testCreateStudent() {
        // arrange
        Student student = new Student("0002");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        // act
        try {
            service.createStudent(student);
        } catch (ClassRosterDataValidationException
                | ClassRosterDuplicateIdException
                | ClassRosterPersistenceException e) {
            // assert
            fail("Student was valid, no exception should be thrown");
        }

    }

    @Test
    void testCreateDuplicateStudent() {
        // arrange
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        // act+assert, follow JUnit5 best practice
        assertThrows(ClassRosterDuplicateIdException.class, () -> service.createStudent(student),
                "DupeID exception expected");
    }

    @Test
    void testCreateInvalidStudent() {
        // arrange
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        // act+assert, folow JUnit5 docs
        assertThrows(ClassRosterDataValidationException.class, () -> service.createStudent(student),
                "Validation Exception Expected");
        // // act
        // try {
        // service.createStudent(student);
        // fail("Validation exception expected");
        // } catch (ClassRosterDuplicateIdException
        // | ClassRosterPersistenceException e) {
        // // assert
        // fail("wrong exception should be thrown");
        // } catch (ClassRosterDataValidationException e) {

        // return;
        // }
    }

    @Test
    void testGetAllStudents() throws Exception {
        // arrange
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // act+assert
        assertEquals(1, service.getAllStudents().size(), "Shold only have one student");
        assertTrue(service.getAllStudents().contains(testClone), "the one student should be Ada.");

    }

    @Test
    void testGetStudent() throws Exception {
        // arrange
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // act on existing student
        Student retrievedStudent = service.getStudent("0001");

        // assert
        assertNotNull(retrievedStudent, "Getting 0001 should not be null");
        assertEquals(testClone, retrievedStudent, "Student 0001 should be Ada");

        // act on non existing student

        retrievedStudent = service.getStudent("0042");
        assertNull(retrievedStudent, "Getting 0042 should be null");

    }

    @Test
    void testRemoveStudent() throws Exception{
        // arrange
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // act
        Student removedStudent = service.removeStudent("0001");
        // assert
        assertNotNull(removedStudent, "Removing 0001 should not be null");
        assertEquals(testClone, removedStudent, "Student removed from 0001 should be Ada");

        // act on non existing student

        removedStudent = service.getStudent("0042");
        assertNull(removedStudent, "Removing 0042 should be null");

    }

    @BeforeAll
    static void beforeClass() {

    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void afterClass() {

    }

}
