package org.example;
public class SpecialDeal extends SpecialDealsManager{
    private String name;
    private double discountPercentage;

    public SpecialDeal(String name, double discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage;
    }
    @Override
    public SpecialDeal addDeal(String name, double discountPercentage) {
        SpecialDeal t = new SpecialDeal(name,discountPercentage);
        return t;
    }

    public String getName() {
        return name;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
