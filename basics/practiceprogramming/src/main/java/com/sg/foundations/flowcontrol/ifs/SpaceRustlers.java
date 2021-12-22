package com.sg.foundations.flowcontrol.ifs;

public class SpaceRustlers {
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        // this if block checks if the number of aliens is more than the number of
        // spaceships.
        if (aliens > spaceships) {
            System.out.println("Vrroom, vroom! Let's get going!");
        } else {
            System.out.println("There aren't enough green guys to drive these ships!");
        }
        // this if block compares the number of cows to space ships.
        // it accounts for 3 different situations: equal, more than and less than.
        // else if is only executed if the euqality block returns false.
        // if the final else statement is removed, statements will only be printed for
        // equals to and more than.
        if (cows == spaceships) {
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } else if (cows > spaceships) {
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
        if (aliens > cows) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } else {
            System.out.println("Oh no! The herds got restless and took over! Looks like we're hamburger now!!");
        }
    }
}
