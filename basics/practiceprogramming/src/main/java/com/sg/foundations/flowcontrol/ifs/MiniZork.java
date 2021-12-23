package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class MiniZork {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("There is also a rubbish bin here.");
        System.out.print("Go to the house, open the mailbox, or inspect the rubbish bin? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();
                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("Turns out there was a grue inside, your arm is chomped off.");
                System.out.println("At least you live to fight another day!");
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You go to the house.");
            System.out.println("The door is slightly ajar, do you want to go in?");
            System.out.print("Go in or explore around the house? ");
            action = userInput.nextLine();
            if (action.equals("Go in")) {
                System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                System.out.println("You've been eaten by a grue.");
            } else if (action.equals("Explore around the house")) {
                System.out.println("There a dog house and a small shed the the yard of the house.");
                System.out.println("Check out the dog house or go to the shed?");
                action = userInput.nextLine();
                if (action.equals("Check out the dog house")) {
                    System.out.println("A vicious dog appeared and mauled you.");
                } else if (action.equals("Go to the shed")) {
                    System.out.println("There's nothing here ...");
                }
            }
        } else if (action.equals("inspect the rubbish bin")) {
            System.out.println("You see an old banana peel, some white powder and a large bone.");
            System.out.println("Leave the bin alone, or pick up an item?");
            action = userInput.nextLine();
            if (action.equals("Leave the bin alone")) {
                System.out.println("You leave the bin alone.");
                System.out.println("You're alive. Possibly a wise choice.");
            } else if (action.equals("Pick up an item")) {
                System.out.println("which item do you want to take from the bin?");
                System.out.println("Old banana peel, white powder or the large bone?");
                action = userInput.nextLine();
                switch (action) {
                    case "old banana peel":
                        System.out.println("YUCK ITS FULL OF MAGGOTS!");
                        System.err.println("You drop the peel and run away in disgust.");
                        break;
                    case "White powder":
                        System.out.println("HANDS UP FBI!");
                        System.out.println("You get arrested by the cops for possession of drugs");
                        break;
                    case "large bone":
                        System.out.println("A huge dog appears out of nowhere to challenge you for the bone.");
                        System.out.println("You lose the fight, and both arms.");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
