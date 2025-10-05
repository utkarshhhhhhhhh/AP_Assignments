package org.example;
import java.util.*;
public class DiscountManager {

    public DiscountManager() {
        Discount a = new Discount(10,"MINOR10");
        Discount b = new Discount(20,"SENIOR20");
        discountList.add(a);
        discountList.add(b);
    }
    private static ArrayList<Discount> discountList = new ArrayList<>();

    public static ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public static void setDiscountList(ArrayList<Discount> discountList) {
        DiscountManager.discountList = discountList;
    }


    public static void addDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Discount Percentage: ");
        double percentage = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Coupon Code: ");
        String couponCode = scanner.nextLine();

        Discount newDiscount = new Discount(percentage, couponCode);
        discountList.add(newDiscount);
        System.out.println("Discount added successfully.");
    }

    public static void removeDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Discount coupon to Remove: ");
        String couponcode = scanner.nextLine();

        Iterator<Discount> iterator = discountList.iterator();
        while (iterator.hasNext()) {
            Discount discount = iterator.next();
            if (discount.getCouponCode().equals(couponcode)) {
                iterator.remove();
                System.out.println("Discount removed successfully.\n");
                return;
            }
        }
        System.out.println("Discount not found.\n");
    }


    public static void modifyDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Discount Coupon to Modify: ");
        String discountcode = scanner.nextLine();

        for (Discount discount : discountList) {
            if (discount.getCouponCode().equals(discountcode)) {
                System.out.println("Current Discount Percentage: " + discount.getPercentage() + "%");
                System.out.print("Enter New Discount Percentage: ");
                double newPercentage = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Current Coupon Code: " + discount.getCouponCode());
                System.out.print("Enter New Coupon Code: ");
                String newCouponCode = scanner.nextLine();

                discount.setPercentage(newPercentage);
                discount.setCouponCode(newCouponCode);

                System.out.println("Discount information modified successfully.");
                return;
            }
        }
        System.out.println("Discount not found in the list.");
    }

    public static void viewDiscounts() {
        System.out.println("View Discounts:");
        for (int i = 0; i < discountList.size(); i++) {
            Discount discount = discountList.get(i);
            System.out.println((i + 1) + ". " +" (" + discount.getPercentage() + "% discount) - " + discount.getCouponCode());
        }
    }
}