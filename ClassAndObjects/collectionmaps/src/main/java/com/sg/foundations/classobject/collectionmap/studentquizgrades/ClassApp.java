package com.sg.foundations.classobject.collectionmap.studentquizgrades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sg.foundations.classobject.collectionmap.userio.UserInterface;

public class ClassApp extends UserInterface {
    QuizClass studentClass = new QuizClass(this);
    private final String[] menuOptions = { "View a list of all students", "Add/Edit a student in the class",
            "Remove Student from the class", "List all quiz scores for a student",
            "View a student's average score", "View top scorers in the class", "View students with low scores",
            "Exit the App" };
    private final String[] classListOptions = { "View Nominal Roll", "View Student details",
            "View Student Summary" };
    private final String[] addOptions = { "Add a new student", "Add new student with quiz scores",
            "Set scores for a student", "Add new quiz scores for a student" };

    public void appLoop() {
        // int a = printMenu();
        while (true) {
            this.print("What would you like to do?");
            switch (this.printMenu(Arrays.asList(this.menuOptions))) {
                case 1:
                    this.classListMenu();
                    break;
                case 2:
                    this.editStudentMenu();
                    break;
                case 3:
                    this.removeStudent();
                    break;
                case 4:
                    this.printStudentScore();
                    break;
                case 5:
                    this.printStudentAverageScore();
                    break;
                case 6:
                    this.printEdgeScorers(true);
                    break;
                case 7:
                    this.printEdgeScorers(false);
                    break;
                default:
                    return;
            }
            this.print("");
        }
    }

    // UI submenus
    private void classListMenu() {
        switch (this.printMenu(Arrays.asList(classListOptions))) {
            case 1:
                // print nominal roll
                this.printStudentList();
                break;
            case 2:
                // print all students with detailed scores
                this.printClassDetails();

                break;
            case 3:
            // print average score of all students
                this.printClassAverage();
                break;
            default:
                break;
        }

    }

    private void editStudentMenu() {
        switch (this.printMenu(Arrays.asList(addOptions))) {
            case 1:
                this.addStudentPrompt();
                break;

            default:
                break;
        }
    }

    // utilities
    private int printMenu(List<String> menu) {
        this.printList(menu);
        return this.readInt("Please choose an option from the above. (Integers only):", 1, menu.size());
    }

    private void printList(Collection<String> menu) {
        Object[] menuArr = menu.toArray();
        for (int i = 0; i < menuArr.length; i++) {
            this.print(String.format("%d. %s", (i + 1), menuArr[i]));
        }
    }

    private void printStudentScore() {
        this.printStudentScore(this.readString("Who's scores would you like to view?"));

    }

    public void printStudentScore(String studentName) {
        ArrayList<String> strScore = new ArrayList<>();
        for (int score : this.studentClass.getStudentScores(studentName)) {
            strScore.add(String.valueOf(score));
        }
        this.print(String.format("%s's scores: %s", studentName, String.join(", ", strScore)));
    }

    public void printStudentList() {
        Collection<String> studentList = this.studentClass.getStudentList();
        this.print("\nClass Nominal Roll:");
        this.printList(studentList);
    }

    public void printClassDetails() {
        Collection<String> studentList = this.studentClass.getStudentList();
        for (String studentName : studentList) {
            this.printStudentScore(studentName);
        }
    }

    public void printClassAverage() {
        Collection<String> studentList = this.studentClass.getStudentList();
        for (String studentName : studentList) {
            this.printStudentAverageScore(studentName);
        }
    }

    private void printStudentAverageScore() {
        this.printStudentAverageScore(this.readString("Who's average score would you like to view?"));
    }

    public void printStudentAverageScore(String studentName) {
        this.print(
                String.format("%s's average score: %f", studentName, this.studentClass.getStudentAverage(studentName)));
    }

    public void printEdgeScorers(boolean isTop) {
        Map<Integer, String[]> scoreMap = this.studentClass.getEdgeScorers(isTop);
        for (int score : scoreMap.keySet()) {
            this.print(String.format("%s scored the %s in class, with a score of %d.",
                    String.join(", ", scoreMap.get(score)), isTop ? "highest" : "lowest", score));
        }
    }

    public void addStudentPrompt() {
        this.studentClass.addStudent(this.readString("New Student's name:"));
    }

    public void removeStudent() {
        String studentName = this.readString("Who would you like to remove from the class roster?");
        if (studentClass.removeStudent(studentName)) {
            this.print(String.format("Student %s has been removed.", studentName));
        }
    }

}
