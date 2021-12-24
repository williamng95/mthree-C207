package com.sg.foundations.flowcontrol.methods;

import java.util.Random;

public class BarelyControlledChaos {
    static final Random rng = new Random();

    public static void main(String[] args) {
        String color = randomColor();
        String animal = randomAnimal();
        String colorAgain = randomColor();
        int weight = randomNumber(5, 200);
        int distance = randomNumber(10, 20);
        int number = randomNumber(10000, 20000);
        int time = randomNumber(2, 6);

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    public static String randomColor() {
        switch (rng.nextInt(7)) {
            case 0:
                return "Black";
            case 1:
                return "Red";
            case 2:
                return "Blue";
            case 3:
                return "Green";
            case 4:
                return "Yellow";
            case 5:
                return "Purple";
            case 6:
                return "White";
            default:
                return "Gold";
        }

    }

    public static String randomAnimal() {
        switch (rng.nextInt(7)) {
            case 0:
                return "Bear";
            case 1:
                return "Bird";
            case 2:
                return "Elephant";
            case 3:
                return "Dog";
            case 4:
                return "Cat";
            case 5:
                return "Fish";
            case 6:
                return "Llama";
            default:
                return "Meerkat";
        }
    }

    public static int randomNumber(int min, int max) {
        return rng.nextInt(max - min + 1) + min;
    }
}
