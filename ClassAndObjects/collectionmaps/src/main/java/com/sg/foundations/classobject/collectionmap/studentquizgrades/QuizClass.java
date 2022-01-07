package com.sg.foundations.classobject.collectionmap.studentquizgrades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Set<String> getStudentList() {
        return studentDB.keySet();
    }

    public Map<String, List<Integer>> getStudentDB() {
        return studentDB;
    }

    public List<Integer> getStudentScores(String studentName) {
        return studentDB.get(studentName);
    }

    public double getStudentAverage(String studentName) {
        double sumScore = 0;
        for (double score : studentDB.get(studentName)) {
            sumScore += score;
        }
        return sumScore / studentDB.get(studentName).size();
    }

    public double getClassAverage() {
        double sumClass = 0;
        for (String studentName : studentDB.keySet()) {
            sumClass += this.getStudentAverage(studentName);
        }
        return sumClass / studentDB.keySet().size();
    }

    public int getStudentEdgeScore(String studentName, boolean isTop) {
        return isTop ? Collections.max(studentDB.get(studentName)) : Collections.min(studentDB.get(studentName));
    }

    public Map<Integer, String[]> getEdgeScorers(boolean isTop) {
        // only one parameter, if true return top scores. else, return bottom scores.
        // initialize as a real score
        int classTopScore = studentDB.values().iterator().next().get(0);

        int compareModify = isTop ? 1 : -1;
        // to use > for both highest and lowest, we can mulitply the expression by -1 to
        // flip the sign.
        // hence, to find lowest score, it becomes if (-studentscore > -maxScore)
        List<String> topScorers = new ArrayList<String>();
        int studentEsgeScore;
        for (String studentName : studentDB.keySet()) {
            studentEsgeScore = this.getStudentEdgeScore(studentName, isTop);
            if (compareModify * studentEsgeScore > compareModify * classTopScore) {
                classTopScore = studentEsgeScore;
                topScorers.clear();
                topScorers.add(studentName);

            } else if (studentEsgeScore == classTopScore) {
                topScorers.add(studentName);
            }
        }
        // cant intialize and call .put() in same line, as .put() returns the previous
        // value associated with key, as per javadoc.
        // eg return new HashMap<>().put(topscore,topScoreArray) will return an
        // unknown/String[] instead of the map.
        System.out.println(topScorers.size());
        Map<Integer, String[]> returnMap = new HashMap<>();
        returnMap.put(classTopScore, topScorers.toArray(new String[topScorers.size()]));
        return returnMap;
    }

}
