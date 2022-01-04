package com.sg.foundations.classobject.collectionmap.userio;

import java.util.Scanner;

public class UserInterface implements UserIO {
    // no error handling on read.
    
    private Scanner userInput = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.printf("%n%s", message);
    }

    @Override
    public double readDouble(String prompt) {
        return Double.valueOf(this.readString(prompt));
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
        return Float.valueOf(this.readString(prompt));
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float number;
        while (true) {
            number = this.readFloat(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                this.print(String.format("The number provided is out of range %f - %f, please try again.", min, max));
            }
        }
        return number;
    }

    @Override
    public int readInt(String prompt) {
        return Integer.valueOf(this.readString(prompt));
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int number;
        while (true) {
            number = this.readInt(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                this.print(String.format("The number provided is out of range %d - %d, please try again.", min, max));
            }
        }
        return number;
    }

    @Override
    public long readLong(String prompt) {
        return Long.valueOf(this.readString(prompt));
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long number;
        while (true) {
            number = this.readLong(prompt);
            if (number >= min && number <= max) {
                break;
            } else {
                this.print(String.format("The number provided is out of range %d - %d, please try again.", min, max));
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
