package org.example;
import java.util.*;
public abstract class SpecialDealsManager {
    abstract public SpecialDeal  addDeal(String name, double percentage);
    private static ArrayList<SpecialDeal> specialDeals = new ArrayList<>();

    public static void addSpecialDeal(String name, double discountPercentage) {
        SpecialDeal deal = new SpecialDeal(name, discountPercentage);
        specialDeals.add(deal);
        System.out.println("Special deal added: " + name);
    }

    public static void removeSpecialDeal(String name) {
        for (SpecialDeal deal : specialDeals) {
            if (deal.getName().equals(name)) {
                specialDeals.remove(deal);
                System.out.println("Special deal removed: " + name);
                return;
            }
        }
        System.out.println("Special deal not found: " + name);
    }

    public static void viewSpecialDeals() {
        System.out.println("Special Deals:");
        int index = 1;
        for (SpecialDeal deal : specialDeals) {
            System.out.println(index + ". " + deal.getName() + " - " + deal.getDiscountPercentage() + "% off");
            index++;
        }
    }
}