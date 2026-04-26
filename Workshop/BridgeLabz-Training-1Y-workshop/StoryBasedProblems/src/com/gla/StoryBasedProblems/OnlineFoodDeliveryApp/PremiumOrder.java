package com.gla.StoryBasedProblems.OnlineFoodDeliveryApp;

class PremiumOrder extends Order {

    public PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        double discount = baseAmount * 0.20; // 20% discount
        return (baseAmount - discount) + deliveryCharge;
    }
}
