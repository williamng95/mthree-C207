package com.sg.foundations.flowcontrol.arrays;

public class SimpleCombination {
    public static void main(String[] args) {
        int[] firstHalf = { 3, 7, 9, 10, 16, 19, 20, 34, 35, 45, 47, 49 }; // 12 numbers
        int[] secondHalf = { 51, 54, 68, 71, 75, 78, 82, 84, 85, 89, 91, 100 };

        int[] wholeNumbers = new int[24];

        int[][] combineArray = { firstHalf, secondHalf };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                wholeNumbers[j + i * 12] = combineArray[i][j];
            }
        }

        System.out.println("All together now!:");
        for (int i : wholeNumbers) {
            System.out.print(i + " ");

        }

    }
}
