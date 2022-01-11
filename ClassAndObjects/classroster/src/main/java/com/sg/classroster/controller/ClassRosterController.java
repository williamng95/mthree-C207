package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;

public class ClassRosterController {
    private ClassRosterView ui;
    private ClassRosterDao dao;

    public ClassRosterController(ClassRosterView ui, ClassRosterDao dao) {
        this.ui = ui;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                switch (getMenuSelection()) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

                exitMessage();

            }
        } catch (ClassRosterDaoException e) {
            ui.displayErrorMsg(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return ui.printMenuAndGetOption();
    }

    private void createStudent() throws ClassRosterDaoException {
        ui.displayStudentBanner();
        Student newStudent = ui.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        ui.displaySuccess();
    }

    private void listStudents() throws ClassRosterDaoException {
        ui.displayAllBanner();
        ui.displayStudentList(dao.getAllStudents());
    }

    private void viewStudent() throws ClassRosterDaoException {
        ui.displaySingleBanner();
        ui.displayStudent(dao.getStudent(ui.getStudentId()));
    }

    private void removeStudent() throws ClassRosterDaoException {
        ui.displayRemoveBanner();
        ui.displayRemoveResult(dao.removeStudent(ui.getStudentId()));
    }

    private void unknownCommand() {
        ui.displayUnknownCommand();
    }

    private void exitMessage() {
        ui.displayExitBanner();
    }

}
