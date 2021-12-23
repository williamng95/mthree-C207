package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("How many units of fizzing and buzzing do you need in your life? ");
        int fizBuz = Integer.valueOf(userInput.nextLine());
        int count = 0;
        // end condition set as 5X of number of FIZZBUZZ, since that is worst case
        // scenario.
        for (int i = 0; i <= fizBuz * 5; i++) {
            if (i > 0 && ((i % 3 == 0) || (i % 5 == 0))) {
                if (i % 3 == 0) {
                    System.out.print("fizz ");
                }
                if (i % 5 == 0) {
                    System.out.print("buzz");
                }
                count++;
                if (count == fizBuz) {
                    System.out.println("");
                    break;
                }
            } else {
                System.out.print(i);
            }

            System.out.println("");
        }
        System.out.println("TRADITION!!!!!");
    }
}
