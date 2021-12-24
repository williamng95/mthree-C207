package com.sg.foundations.flowcontrol.arrays;

public class FruitSalad {
    public static void main(String[] args) {
        String[] fruits = { "Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry",
                "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",
                "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple",
                "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry" };
        String[] fruitSalad = new String[12];
        int numFruits = 0;
        int numApples = 0;
        int numOrange = 0;
        int numBerries = 0;
        // find all berries first
        for (String fruit : fruits) {
            if ((fruit.contains("berry")) && (numFruits < 12)) {
                fruitSalad[numFruits] = fruit;
                numFruits++;
                numBerries++;
            }

        }
        // other fruits
        for (String fruit : fruits) {
            if (numFruits == 12) {
                break;
            } else {
                if (!fruit.contains("Tomato") && !fruit.contains("berry")) {
                    if (fruit.contains("Apple")) {
                        if (numApples < 3) {
                            numApples++;
                        } else {
                            continue;
                        }
                    } else if (fruit.contains("Orange")) {
                        if (numOrange < 2) {
                            numOrange++;
                        } else {
                            continue;
                        }

                    }
                    fruitSalad[numFruits] = fruit;
                    numFruits++;
                }
            }
        }
        System.out.println("My salad contains: " + String.join(",", fruitSalad));
        System.out.println("NUmber of berries: " + numBerries);
        System.out.println("Number of Apples: " + numApples);
        System.out.println("Number of Oranges: " + numOrange);
    }
}
