package com.sg.foundations.classobject.collectionmap.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sg.foundations.classobject.collectionmap.userio.UserInterface;
// reference original implementation for some consistency

public class QuizClass {
    private Map<String, List<Integer>> studentDB = new HashMap<>();
    private UserInterface userInput;
    
    public QuizClass(UserInterface userInput) {
        this.userInput = userInput;
    }

    public void addStudent(String studentName) {
        if (studentDB.get(studentName) == null) {
            studentDB.put(studentName, new ArrayList<>());
            userInput.print(String.format("Student %s has been created sucessfully.", studentName));
        } else {
            userInput.print("Student already exists!");
        }
    }

    // convenice method to reset quiz scores
    public void addStudent(String studentName, List<Integer> quizScores) {
        if (studentDB.get(studentName) == null) {
            userInput.print(String.format("Student %s will be created.", studentName));
        }
        studentDB.put(studentName, quizScores);
        userInput.print(String.format("Student %s's quiz scores have been set.", studentName));
    }

    // convenice method to add on quiz scores
    public void addScores(String studentName, List<Integer> quizScores) {
        studentDB.get(studentName).addAll(quizScores);
        userInput.print(String.format("Student %s's new quiz scores have been added on.", studentName));
    }

    public boolean removeStudent(String studentName) {
        studentDB.remove(studentName);
        return true;
    }

    public void printStudent(String studentName) {
        ArrayList<String> strScore = new ArrayList<>();
        for (int score : studentDB.get(studentName)) {
            strScore.add(String.valueOf(score));
        }
        userInput.print(String.format("%s: %s", studentName, String.join(", ", strScore)));
    }

    public void printStudentList(){
        for (String studentName : studentDB.keySet()) {
            userInput.print(studentName);
        }
    }

    public void printStudentListWithScore(){
        for (String studentName : studentDB.keySet()) {
            this.printStudent(studentName);
        }
    }

    public double getStudentAverage(String studentName) {
        double sumScore = 0;
        for (double score : studentDB.get(studentName)) {
            sumScore += score;
        }
        return sumScore / studentDB.get(studentName).size();
    }

    public Map<String, Double> getClassStudentAverage() {
        Map<String, Double> classAverage = new HashMap<>();
        for (String studentName : studentDB.keySet()) {
            classAverage.put(studentName, this.getStudentAverage(studentName));
        }
        return classAverage;
    }

    public double getClassAverage() {
        double sumClass = 0;
        for (String studentName : studentDB.keySet()) {
            sumClass += this.getStudentAverage(studentName);
        }
        return sumClass / studentDB.keySet().size();
    }

}
