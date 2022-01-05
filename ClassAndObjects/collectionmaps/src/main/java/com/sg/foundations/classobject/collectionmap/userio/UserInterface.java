package com.sg.foundations.classobject.collectionmap.userio;

import java.util.Scanner;

public class UserInterface implements UserIO {
    // no error handling on read.

    private Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.printf("%s%n", message);
    }

    @Override
    public double readDouble(String prompt) {
        // refactor with recursion
        this.print(prompt);
        boolean hasValue = this.userInput.hasNextDouble();
        String value = this.userInput.nextLine();
        if (hasValue) {
            return Double.valueOf(value);
        }
        return this.readLong("Please enter a double!");
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double number;
        while (true) {
            number = this.readDouble(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                this.print(String.format("The number provided is out of range %f - %f, please try again.", min, max));
            }
        }
        return number;
    }

    @Override
    public float readFloat(String prompt) {
        // refactor in loop
        this.print(prompt);
        boolean hasValue;
        String value;
        while (true) {
            hasValue = this.userInput.hasNextFloat();
            value = this.userInput.nextLine();
            if (hasValue){
                return Float.valueOf(value);
            }
            this.print("Please enter a float");
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float number;
        while (true) {
            number = this.readFloat(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                prompt = (String.format("The number provided is out of range %f - %f, please try again.", min, max));
            }
        }
        return number;
    }

    @Override
    public int readInt(String prompt) {
        // refactor in loop
        this.print(prompt);
        boolean hasValue;
        String value;
        while (true) {
            hasValue = this.userInput.hasNextInt();
            value = this.userInput.nextLine();
            if (hasValue){
                return Integer.valueOf(value);
            }
            this.print("Please enter an integer!");
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int number;
        while (true) {
            number = this.readInt(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                prompt = (String.format("The number provided is out of range %d - %d, please try again.", min, max));
            }
        }
        return number;
    }

    @Override
    public long readLong(String prompt) {
        // refactor with recursion
        this.print(prompt);
        boolean hasValue = this.userInput.hasNextLong();
        String value = this.userInput.nextLine();
        if (hasValue) {
            return Long.valueOf(value);
        }
        return this.readLong("Please enter a long integer.");

    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long number;
        while (true) {
            number = this.readLong(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                prompt = String.format("The number provided is out of range %d - %d, please try again.", min, max);
            }
        }
        return number;
    }

    @Override
    public String readString(String prompt) {
        this.print(prompt);
        return this.userInput.nextLine();
    }

}
