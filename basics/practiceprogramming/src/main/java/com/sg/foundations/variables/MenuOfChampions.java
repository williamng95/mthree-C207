package com.sg.foundations.variables;

public class MenuOfChampions {
    public static void main(String[] args) {
        String horzBorder =")(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)";
        String titleString= "Welcome to RESTAURANT XYZ! \nToday's Menu Is...";
        String itemOne =  "Alien Pizza";
        double priceOne = 200.00;
        String itemTwo = "Sphynx Pie";
        double priceTwo = 1000.00;
        String itemThree = "Moon Omelet";
        double priceThree = 600.00;


       System.out.println(horzBorder);
       System.out.println();
       System.out.println(titleString);
       System.out.println();
       System.out.println(horzBorder);
       System.out.println(itemOne+" *** "+"$ "+priceOne);
       System.out.println(itemTwo+"  *** "+"$ "+priceTwo);
       System.out.println(itemThree+" *** "+"$ "+priceThree);
       System.out.println(horzBorder);
    }
}
