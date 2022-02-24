package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIdException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;

public class ClassRosterController {
    private ClassRosterView ui;
    private ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterView ui, ClassRosterServiceLayer service) {
        this.ui = ui;
        this.service = service;
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

                

            }
        } catch (ClassRosterPersistenceException e) {
            ui.displayErrorMsg(e.getMessage());
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return ui.printMenuAndGetOption();
    }

    private void createStudent() throws ClassRosterPersistenceException {
        ui.displayStudentBanner();
        while (true) {
            try {
                Student newStudent = ui.getNewStudentInfo();
                service.createStudent(newStudent);
                ui.displaySuccess();
                return;
            } catch (ClassRosterDataValidationException|ClassRosterDuplicateIdException e) {
                ui.displayErrorMsg(e.getMessage());
            }
        } 
        
        
        
    }

    private void listStudents() throws ClassRosterPersistenceException {
        ui.displayAllBanner();
        ui.displayStudentList(service.getAllStudents());
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        ui.displaySingleBanner();
        ui.displayStudent(service.getStudent(ui.getStudentId()));
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        ui.displayRemoveBanner();
        ui.displayRemoveResult(service.removeStudent(ui.getStudentId()));
    }

    private void unknownCommand() {
        ui.displayUnknownCommand();
    }

    private void exitMessage() {
        ui.displayExitBanner();
    }

}
