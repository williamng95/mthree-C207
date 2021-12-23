package com.sg.foundations.flowcontrol.random;

import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {
        Random coinFlip = new Random();

        System.out.println("Ready, Set, Flip....!!");
        boolean isHead = coinFlip.nextBoolean();
        System.out.print("You got ");
        if (isHead) {
            System.out.println("HEADSSS!!");
        } else {
            System.out.println("TAILS!");
        }
    }
}
