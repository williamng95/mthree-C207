package com.sg.classroster.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sg.classroster.dto.Student;

public class ClassRosterDaoMemImpl implements ClassRosterDao {
    protected Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterDaoException {
        return this.students.put(studentId, student);
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterDaoException {
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterDaoException {
        return students.remove(studentId);
    }

}
