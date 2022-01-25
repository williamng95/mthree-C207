package com.sg.classroster.ui;

import java.util.List;

import com.sg.classroster.dto.Student;

public class ClassRosterView {
    private UserIO io;
    private String[] menuOptions = { "Main Menu", "1. List Students", "2. Create New Student", "3. View a Student",
            "4. Remove a Student", "5. Exit" };

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetOption() {
        for (String string : menuOptions) {
            this.io.print(string);
        }
        return io.readInt("Please select from the above choices.", 1, menuOptions.length - 1);
    }

    public Student getNewStudentInfo() {
        Student newStudent = new Student(io.readString("Please enter Student ID"));
        newStudent.setFirstName(io.readString("Please enter First Name"));
        newStudent.setLastName(io.readString("Please enter Last Name"));
        newStudent.setCohort(io.readString("Please enter Cohort"));
        return newStudent;
    }

    private void displayBanner(String comment) {
        io.print(String.format("=== %s ===", comment));

    }

    public void displayStudentBanner() {
        displayBanner("Create Student");
    }

    public void displaySuccess() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student student : studentList) {
            io.print(String.format("#%s : %s %s",
                    student.getStudentId(),
                    student.getFirstName(),
                    student.getLastName()));
        }
        io.readString("Hit enter to continue.");
    }

    public void displayAllBanner() {
        displayBanner("Display All Students");
    }

    public void displaySingleBanner() {
        displayBanner("Display Student");
    }

    public String getStudentId() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(String.format("%s %s", student.getFirstName(), student.getLastName()));
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Hit enter to continue.");
    }

    public void displayRemoveBanner() {
        displayBanner("Remove Student");
    }

    public void displayRemoveResult(Student removeStudent) {
        if (removeStudent != null) {
            io.print("Student removed successfully");
        } else {
            io.print("No such student exists");
        }
        io.readString("Hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!");
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command!");
    }

    public void displayErrorMsg(String msg) {
        displayBanner("ERROR");
        io.print(msg);
    }

}
