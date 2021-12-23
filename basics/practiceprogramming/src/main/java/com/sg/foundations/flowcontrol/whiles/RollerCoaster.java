package com.sg.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class RollerCoaster {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;

        // while (keepRiding.equals("y")){
        while (!keepRiding.equals("n")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n): ");
            // if user enters a value that is not y or n, the ride will stop.
            // if the loop condition changes to check for n instead, we will require a !
            // operator.
            // also, the loop will continue if the value is not y/n.
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }
        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
}
