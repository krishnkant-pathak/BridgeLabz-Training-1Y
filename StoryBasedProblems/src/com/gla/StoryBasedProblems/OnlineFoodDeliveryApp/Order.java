package com.gla.StoryBasedProblems.OnlineFoodDeliveryApp;

public class Order {
    protected int orderId;
    protected double baseAmount;
    static double deliveryCharge = 40;  // static variable

    // Constructor
    public Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    // Method to calculate bill (will be overridden)
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}
