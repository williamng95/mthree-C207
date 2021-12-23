package com.sg.foundations.random;

import java.util.Random;

public class ALittleChaos {
    public static void main(String[] args) {
        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(100);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");
        // if 50 is added to nextInt(), the numbers printed out will be between 50-150.
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));

        System.out.println(randomizer.nextFloat());
        System.out.println(randomizer.nextLong());

        // unlikely that we will need to include random numbers in a math statement, but
        // it is possible.
        // nextFloat(): 0.28614336
        // nextLong(): -5508221518378967305
    }
}
