package com.sg.foundations.flowcontrol.whiles;

public class WaitAWhile {
    public static void main(String[] args) {
        // if timeNow is set to 11, since it is bigger than 10, the loop will not
        // excute.
        // the go to bed sentence will trigger only.
        int timeNow = 5;
        // if bedTime is changed to 11, there will be one more loop stating that its
        // only 10 oclock.

        int bedTime = 10;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer.... ");
            timeNow++; // time passes
            // if timeNow++ is commented out, we are stuck in an infinite loop at 5oclock.
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed...");
    }
}
