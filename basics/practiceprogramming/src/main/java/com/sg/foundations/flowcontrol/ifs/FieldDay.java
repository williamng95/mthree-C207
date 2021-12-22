package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        String lastName;

        System.out.print("What's your last name? ");
        lastName = inputReader.nextLine();

        System.out.print("Aha! You're on the team ");
        if (lastName.compareToIgnoreCase("Baggins")<=0){
            System.out.println("Red Dragons!");
        }
        else if (lastName.compareToIgnoreCase("Dresden")<=0){
            System.out.println("Dark Wizards!");
        }
        else if (lastName.compareToIgnoreCase("Howl")<=0){
            System.out.println("Moving Castles!");
        }
        else if (lastName.compareToIgnoreCase("Potter")<=0){
            System.out.println("Golden Snitches!");
        }
        else if (lastName.compareToIgnoreCase("Vimes")<=0){
            System.out.println("Night Guards!");
        }
        else{
            System.out.println("Black Holes!");
        }
        System.out.println("Good luck in the games!");
    }
}
