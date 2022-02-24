package com.sg.classroster.service;

import java.util.List;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {
    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    // internal validation methods

    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null || student.getFirstName().trim().length() == 0
                || student.getLastName() == null || student.getLastName().trim().length() == 0
                || student.getCohort() == null || student.getCohort().trim().length() == 0) {
            throw new ClassRosterDataValidationException("All fields [First Name, Last Name, Cohort] are required");
        }
    }

    // interface methods
    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException,
            ClassRosterDataValidationException, ClassRosterPersistenceException {
        // check if studentid already exists
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(String
                    .format("ERROR. Cannot create student. Student ID %s already exists.", student.getStudentId()));
        }
        // validate student data fields
        validateStudentData(student);

        // checks passed; call addStudent and write to audit log
        dao.addStudent(student.getStudentId(), student);
        auditDao.writeAuditEntry(String.format("Student %s CREATED", student.getStudentId()));

    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry(String.format("Student %s REMOVED", studentId));
        return removedStudent;
    }

}
