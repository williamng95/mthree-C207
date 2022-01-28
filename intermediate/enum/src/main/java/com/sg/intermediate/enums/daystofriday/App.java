package com.sg.intermediate.enums.daystofriday;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int daysToFriday = 0;
        System.out.println("Which day is it?");
        // trim and convert to uppercase to match enum names

        switch (DaysOfTheWeek.valueOf(userInput.nextLine().trim().toUpperCase())) {
            case SATURDAY:
                daysToFriday += 1;
            case SUNDAY:
                daysToFriday += 1;
            case MONDAY:
                daysToFriday += 1;
            case TUESDAY:
                daysToFriday += 1;
            case WEDNESDAY:
                daysToFriday += 1;
            case THURSDAY:
                daysToFriday += 1;
                System.out.printf("There %s %d day%s to Friday!", daysToFriday > 1 ? "are" : "is", daysToFriday,
                        daysToFriday > 1 ? "s" : "");
                break;
            case FRIDAY:
                // friday, print a differtnt message and terminate
                System.out.println("ITS FRIDAY TODAY WOHOO");
                break;
            default:
                // error on unknown day, exit program
                System.out.println("No such day in a week!");
                break;
        }

    }

}
