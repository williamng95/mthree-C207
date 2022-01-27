package com.sg.classroster.service;

import java.util.List;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;

public class ClassRosterDaoStubImpl implements ClassRosterDao {
    private Student onlyStudent;

    /**
     * Initlaize DAO with a given student
     * 
     * @param onlyStudent
     */
    public ClassRosterDaoStubImpl(Student onlyStudent) {
        this.onlyStudent = onlyStudent;
    }

    /**
     * Initilaize with deefault settings.
     */
    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return List.of(onlyStudent);
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

}
