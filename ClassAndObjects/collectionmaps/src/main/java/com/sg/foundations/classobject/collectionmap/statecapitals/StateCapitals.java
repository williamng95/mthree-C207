package com.sg.foundations.classobject.collectionmap.statecapitals;

import java.util.HashMap;

public class StateCapitals {
    public static void main(String[] args) {
        HashMap<String, String> stateCapitalMap = new HashMap<>();
        String firstTitle = "STATES: ";
        String secondTitle = "CAPITALS: ";
        String thirdTitle = "STATES/CAPITAL PAIRS: ";
        stateCapitalMap.put("Alabama", "Montgomery");
        stateCapitalMap.put("Alaska", "Juneau");
        stateCapitalMap.put("Arizona", "Phoenix");
        stateCapitalMap.put("Arkansas", "Little Rock");

        System.out.println(firstTitle);
        System.out.println("=".repeat(firstTitle.length()));
        for (String state : stateCapitalMap.keySet()) {
            System.out.println(state);
        }

        System.out.println("");
        System.out.println(secondTitle);
        System.out.println("=".repeat(secondTitle.length()));
        for (String state : stateCapitalMap.values()) {
            System.out.println(state);
        }

        System.out.println("");
        System.out.println(thirdTitle);
        System.out.println("=".repeat(thirdTitle.length()));
        for (String state : stateCapitalMap.keySet()) {
            System.out.printf("%s - %s%n", state, stateCapitalMap.get(state));
        }

    }
}
