package com.sg.foundations.classobject.collectionmap.studentquizgrades;

import com.sg.foundations.classobject.collectionmap.userio.UserInterface;

public class ClassApp extends UserInterface {
    QuizClass studentClass = new QuizClass(this);
    String[] menuOptions = { "1. View a list of all students", "2. Add/Edit a student in the class",
            "3. Remove Student from the class", "4. List all quiz scores for a student",
            "5. View a student's average score", "6. View top scorers in the class", "8. View students with low scores",
            "9. Exit the App" };
    String[] classListOptions = { "1. View Nominal Roll", "2. View Student details", "3. View Student Summary" };

    public void appLoop() {
        // int a = printMenu();
        switch (this.printMenu()) {
            case 3:
                this.removeStudent();
                break;
            case 9:
                return;
            default:
                break;
        }
    }

    private int printMenu() {
        String prompt = String.join("\n", menuOptions);
        prompt += "\nPlease choose an option from the above. (Integers only):";
        return this.readInt(prompt, 1, menuOptions.length + 1);
    }
    private void removeStudent(){
        String studentName = this.readString("Who would you like to remove from the class roster?");
        if (studentClass.removeStudent(studentName)){
            this.print(String.format("Student %s has been removed.", studentName));
        }
    }

}
