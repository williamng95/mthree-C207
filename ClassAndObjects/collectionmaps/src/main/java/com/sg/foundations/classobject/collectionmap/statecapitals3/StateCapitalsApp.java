package com.sg.foundations.classobject.collectionmap.statecapitals3;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitalsApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Map<String, Capital> capitalMap = loadFile("MoreStateCapitals.txt");
        System.out.printf("%d STATE/CAPITAL PAIRS LOADED.%n", capitalMap.size());
        System.out.println("==============================");
        for (Map.Entry<String, Capital> state : capitalMap.entrySet()) {
            printEntry(state);
        }
        System.out.printf("Please enter the lower limit for capital city population: ");
        int popLimit = Integer.parseInt(userInput.nextLine());
        System.out.println("");
        System.out.printf("LISTING CAPITALS WITH POPULATIONS GREATER THAN %d:%n", popLimit);

        for (Map.Entry<String, Capital> state : capitalMap.entrySet()) {
            if (state.getValue().getPopulation()>popLimit){
                printEntry(state);
            }
            
        }
        System.out.println("Please enter the upper limit for capital city sq mileage:");
        double areaLimit = Double.parseDouble(userInput.nextLine());
        System.out.printf("LISTING CAPITALS WITH AREAS LESS THAN %.2f sq mi:%n", areaLimit);
        for (Map.Entry<String, Capital> state : capitalMap.entrySet()) {
            if (state.getValue().getArea()<areaLimit){
                printEntry(state);
            }
            
        } 
    }

    public static void printEntry(Map.Entry<String, Capital> state){
        Capital stateCapital = state.getValue();
        System.out.printf("%s - %s | Pop: %d | Area: %.2f sq mi%n", state.getKey(), stateCapital.getName(),
                stateCapital.getPopulation(), stateCapital.getArea());
    }

    public static Map<String, Capital> loadFile(String fileName) {
        Map<String, Capital> capitalMap = new HashMap<>();
        try (Scanner fileScan = new Scanner(Paths.get(fileName))) {
            while (fileScan.hasNextLine()) {
                String[] fileLine = fileScan.nextLine().split("::");
                // data is stored as state::capital::population::area
                capitalMap.put(fileLine[0],
                        new Capital(fileLine[1], Integer.parseInt(fileLine[2]), Double.parseDouble(fileLine[3])));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return capitalMap;
    }
}
