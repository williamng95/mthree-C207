package com.sg.foundations.cumulative;

public class SummativeSums {
    public static void main(String[] args) {
        // consolidate all the arrays together for easier looping
        int[][] consolArr = {
                { 1, 90, -33, -55, 67, -16, 28, -55, 15 },
                { 999, -60, -77, 14, 160, 301 },
                { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                        140, 150, 160, 170, 180, 190, 200, -99 }
        };
        for (int i = 0; i < consolArr.length; i++) {
            System.out.printf("#%d Array Sum: %d%n", i + 1, arraySum(consolArr[i]));
        }
    }

    public static int arraySum(int[] arr) {
        // initialize sum
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
