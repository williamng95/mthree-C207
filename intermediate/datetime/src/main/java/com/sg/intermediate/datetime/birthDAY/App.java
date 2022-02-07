package com.sg.intermediate.datetime.birthDAY;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * 
 * A basic console app without MVC
 */
public class App {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Welcome to the Magical BirthDAY Calculator!");
        System.out.println("");

        System.out.println("What's your birthday? (dd-mm-yyyy)");

        LocalDate userBirthday = LocalDate.parse(userInput.nextLine(), dateFormat);
        LocalDate thisYearBirthday = LocalDate.of(LocalDate.now().getYear(), userBirthday.getMonth(),
                userBirthday.getDayOfMonth());

        System.out.printf("That's means you were born on a %s!%n",
                userBirthday.getDayOfWeek().toString().toUpperCase());
        System.out.printf("This year it falls on a %s...%n", thisYearBirthday.getDayOfWeek().toString().toUpperCase());
        System.out.printf("And since today is %s, there's only %d more days until the next one!%n",
                LocalDate.now().format(dateFormat), LocalDate.now().until(thisYearBirthday, ChronoUnit.DAYS));
        System.out.printf("Bet yer excited to be turning %d!%n", (LocalDate.now().getYear() - userBirthday.getYear()));

    }
}
