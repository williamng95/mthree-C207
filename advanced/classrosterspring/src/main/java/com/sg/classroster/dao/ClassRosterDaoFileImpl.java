package com.sg.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.sg.classroster.dto.Student;

public class ClassRosterDaoFileImpl extends ClassRosterDaoMemImpl {
    public final String ROSTER_FILE;
    public static final String DELIMITER = "::";

    

    public ClassRosterDaoFileImpl() {
        ROSTER_FILE = "roster.txt";
    }

    public ClassRosterDaoFileImpl(String rosterFilePath) {
        ROSTER_FILE = rosterFilePath;
    }

    private void loadRoster() throws ClassRosterPersistenceException {
        try (Scanner fileScan = new Scanner(Paths.get(ROSTER_FILE))) {
            while (fileScan.hasNextLine()) {
                Student currentStudent = unmarshallStudent(fileScan.nextLine());
                students.put(currentStudent.getStudentId(), currentStudent);
            }
        } catch (Exception e) {
            throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
        }
    }

    private String marshallStudent(Student student) {
        return String.join(DELIMITER, student.getStudentId(), student.getFirstName(), student.getLastName(),
                student.getCohort());
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     * 
     * @throws ClassRosterPersistenceException if an error occurs writing to the file
     */
    private void writeRoster() throws ClassRosterPersistenceException {
        // manually close the stream instead of using try-resource
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Couldnt save to roster file", e);
        }
        for (Student student : this.getAllStudents()) {
            out.println(marshallStudent(student));
            out.flush();
        }
        out.close();
    }

    private Student unmarshallStudent(String stduentAsText) {
        String[] studentTokens = stduentAsText.split(DELIMITER);
        Student currentStudent = new Student(studentTokens[0]);
        currentStudent.setFirstName(studentTokens[1]);
        currentStudent.setLastName(studentTokens[2]);
        currentStudent.setCohort(studentTokens[3]);
        return currentStudent;
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = super.addStudent(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return super.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        return super.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        Student removeStudent = super.removeStudent(studentId);
        writeRoster();
        return removeStudent;
    }

}
