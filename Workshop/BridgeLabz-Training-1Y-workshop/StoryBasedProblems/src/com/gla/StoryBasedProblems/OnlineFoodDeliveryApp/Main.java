package com.gla.StoryBasedProblems.OnlineFoodDeliveryApp;

public class Main {
    public static void main(String[] args) {

        // Polymorphism
        Order order1 = new RegularOrder(101, 500);
        Order order2 = new PremiumOrder(102, 500);

        System.out.println("Regular Order Bill: " + order1.calculateBill());
        System.out.println("Premium Order Bill: " + order2.calculateBill());
    }
}