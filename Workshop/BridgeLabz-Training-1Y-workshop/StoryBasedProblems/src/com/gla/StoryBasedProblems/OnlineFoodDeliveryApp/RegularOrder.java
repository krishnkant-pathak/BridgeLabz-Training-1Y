package com.gla.StoryBasedProblems.OnlineFoodDeliveryApp;

class RegularOrder extends Order {

    public RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        return baseAmount + deliveryCharge; // No discount
    }
}
