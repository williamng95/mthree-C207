package com.sg.classroster.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserIOConsoleImpl implements UserIO {

    private Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.printf("%s%n", message);
    }

    @Override
    public double readDouble(String prompt) {
        return (double) this.readNumber(prompt, "double");
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
        return (float) this.readNumber(prompt, "float");
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
        return (int) this.readNumber(prompt, "integer");
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
        return (long) this.readNumber(prompt, "long");

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

    public List<Integer> readIntArray(int size) {
        // String typeName = array.getClass().getComponentType().getSimpleName();
        this.print(String.format("Please enter %d numbers:", size));
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add((Integer) this.readNumber("\b", "integer"));
        }

        return array;

    }

    private Number readNumber(String prompt, String typeString) {
        Set<String> allowedType = new HashSet<>(Arrays.asList("integer", "long", "double", "float"));
        this.print(prompt);
        if (allowedType.contains(typeString.toLowerCase())) {
            while (true) {
                try {
                    switch (typeString.toLowerCase()) {
                        case "integer":
                            return Integer.parseInt(this.userInput.nextLine());
                        case "long":
                            return Long.parseLong(this.userInput.nextLine());
                        case "double":
                            return Double.parseDouble(this.userInput.nextLine());
                        case "float":
                            return Float.parseFloat(this.userInput.nextLine());
                    }
                } catch (Exception e) {
                    this.print("please enter a " + typeString.toLowerCase());
                }
            }
        } else {
            throw new RuntimeException("Bad.");
        }

    }

}
