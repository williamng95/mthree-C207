package com.sg.foundations.classobject.collectionmap.statecapitals2;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class StateCapitals2 {
    public static void main(String[] args) {
        Map<String, String> stateCapitals = readFile("StateCapitals.txt");
        Random rng = new Random();
        Scanner userInput = new Scanner(System.in);
        // change to sorted set to match
        SortedSet<String> states = new TreeSet<String>(stateCapitals.keySet());
        System.out.printf("%d STATES & CAPITALS ARE LOADED.%n", states.size());
        System.out.println("=======");
        System.out.println("HERE ARE THE STATES :");
        System.out.println(String.join(",", states));
        // use rng to select random state test; cast array as string[]
        String stateTest = states.toArray(new String[0])[rng.nextInt(states.size())];
        String capitalTest = stateCapitals.get(stateTest);
        System.out.printf("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF '%s'?%n", stateTest);
        if (userInput.nextLine().equals(capitalTest)) {
            System.out.printf("NICE WORK! %s IS CORRECT!%n", capitalTest);

        } else {
            System.out.printf("Wrong... %s is actually the capital. Better luck next time!", capitalTest);

        }

    }

    public static Map<String, String> readFile(String fileName) {
        Map<String, String> fileMap = new HashMap<>();
        try (Scanner fileScan = new Scanner(Paths.get(fileName))) {
            while (fileScan.hasNextLine()) {
                String[] mapPair = fileScan.nextLine().split("::");
                fileMap.put(mapPair[0], mapPair[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fileMap;
    }
}
