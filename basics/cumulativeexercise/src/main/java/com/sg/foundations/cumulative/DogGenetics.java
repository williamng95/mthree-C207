package com.sg.foundations.cumulative;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner userInput = new Scanner(System.in);

        int currentComposition;
        int totalComposition = 100;
        String[] dogBreeds = { "St. Bernard", "Chihuahua", "Golden Retriever", "Common Cur", "King Doberman" };

        System.out.printf("What is your dog's name? ");
        String dogName = userInput.nextLine();
        System.out.printf("Well then, I have this highly reliable report on %s's prestigious background right here.%n",
                dogName);

        System.out.printf("%n%n%s is: %n%n", dogName);

        for (int i = 0; i < dogBreeds.length - 1; i++) {
            // add 1 to rng output to fix lower bound to 1.
            // reduce nextInt() upper bound to reserve at least 1 for last item.
            currentComposition = rng.nextInt(totalComposition - 1) + 1;
            System.out.printf("%d%%: %s%n", currentComposition, dogBreeds[i]);
            totalComposition -= currentComposition;
        }
        // fill out remaining % for last breed.
        System.out.printf("%d%%: %s%n%n", totalComposition, dogBreeds[dogBreeds.length - 1]);

        System.out.println("Wow, that's QUITE the dog!");

    }
}
