package com.sg.foundations.flowcontrol.fors;

public class SpringForwardFallBack {
    public static void main(String[] args) {
        System.out.println("It's Spring...!");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
        // first loop: 0(start) to 9(last)
        // second loop: 10(start) to 1(last)
        // the condtions should be: (int i = 1; i < 11; i++)
    }
}
