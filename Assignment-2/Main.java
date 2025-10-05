package org.example;
import java.util.*;

public class Main {
    private static Visitor loggedInVisitor = null;
    private static int revenue = 0;

    public static int getRevenue() {
        return revenue;
    }

    public static void setRevenue(int revenue) {
        Main.revenue = revenue;
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ZOOtopia !\n");
        Attractions attractionsManager = new Attractions();
        Animals animalManager = new Animals();

        while (true) {
            DiscountManager t = new DiscountManager();
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals\n");

            System.out.print("Enter your choice: \n");
            int choice_1 = scanner.nextInt();
            scanner.nextLine();

            switch (choice_1) {
                case 1:
                    System.out.print("Enter Admin Username: ");
                    String admin_username = scanner.nextLine();
                    System.out.print("Enter Admin Password: \n");
                    String admin_password = scanner.nextLine();

                    if (admin_username.equals("admin") && admin_password.equals("admin123")) {
                        while (true) {
                            System.out.println("\nAdmin Menu:");
                            System.out.println("1. Manage Attractions");
                            System.out.println("2. Manage Animals");
                            System.out.println("3. Schedule Event");
                            System.out.println("4. Manage Discounts");
                            System.out.println("5. Manage Special Deals");
                            System.out.println("6. View Visitor Stats");
                            System.out.println("7. View Feedback");
                            System.out.println("8. Logout\n");

                            System.out.print("Enter your choice: ");
                            int choice_2 = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice_2) {
                                case 1:
                                    while (true) {
                                        System.out.println("\nAttractions Menu:");
                                        System.out.println("1. Add Attraction");
                                        System.out.println("2. Modify Attraction");
                                        System.out.println("3. Remove Attraction");
                                        System.out.println("4. View Attractions");
                                        System.out.println("5. Back to Admin Menu\n");

                                        System.out.print("Enter your choice: ");
                                        int choice_3 = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (choice_3) {
                                            case 1:
                                                attractionsManager.addAttraction();
                                                break;
                                            case 2:
                                                attractionsManager.modifyAttraction();
                                                break;
                                            case 3:
                                                attractionsManager.removeAttraction();
                                                break;
                                            case 4:
                                                attractionsManager.viewAttractions();
                                                break;
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please try again.");
                                        }

                                        if (choice_3 == 5) {
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    while (true) {
                                        System.out.println("\nAnimals Menu:");
                                        System.out.println("1. Add Animal");
                                        System.out.println("2. Update Animal");
                                        System.out.println("3. Remove Animal");
                                        System.out.println("4. View Animals");
                                        System.out.println("5. Back to Admin Menu\n");

                                        System.out.print("Enter your choice: ");
                                        int choice_3 = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (choice_3) {
                                            case 1:
                                                animalManager.addAnimal();
                                                break;
                                            case 2:
                                                animalManager.updateAnimal();
                                                break;
                                            case 3:
                                                animalManager.removeAnimal();
                                                break;
                                            case 4:
                                                animalManager.viewAnimals();
                                                break;
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please try again.");
                                        }

                                        if (choice_3 == 5) {
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    attractionsManager.scheduleEvent(); // Add this case
                                    break;
                                case 4:
                                    while (true) {
                                        System.out.println("\nDiscounts Menu:");
                                        System.out.println("1. Add Discount");
                                        System.out.println("2. Modify Discount");
                                        System.out.println("3. Remove Discount");
                                        System.out.println("4. View Discounts");
                                        System.out.println("5. Back to Admin Menu\n");

                                        System.out.print("Enter your choice: ");
                                        int choice_3 = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (choice_3) {
                                            case 1:
                                                DiscountManager.addDiscount();
                                                break;
                                            case 2:
                                                DiscountManager.modifyDiscount();
                                                break;
                                            case 3:
                                                DiscountManager.removeDiscount();
                                                break;
                                            case 4:
                                                DiscountManager.viewDiscounts();
                                                break;
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please try again.");
                                        }

                                        if (choice_3 == 5) {
                                            break;
                                        }
                                    }
                                    break;
                                case 5:
                                    while (true) {
                                        System.out.println("\nSpecial Deals Menu:");
                                        System.out.println("1. Add Special Deal");
                                        System.out.println("2. Remove Special Deal");
                                        System.out.println("3. View Special Deals");
                                        System.out.println("4. Back to Admin Menu\n");

                                        System.out.print("Enter your choice: ");
                                        int choice_3 = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (choice_3) {
                                            case 1:
                                                System.out.print("Enter Deal Name: ");
                                                String dealName = scanner.nextLine();
                                                System.out.print("Enter Discount Percentage: ");
                                                double percentage = scanner.nextDouble();
                                                scanner.nextLine();
                                                SpecialDealsManager.addSpecialDeal(dealName, percentage);
                                                break;
                                            case 2:
                                                System.out.print("Enter Deal Name to Remove: ");
                                                String dealToRemove = scanner.nextLine();
                                                SpecialDealsManager.removeSpecialDeal(dealToRemove);
                                                break;
                                            case 3:
                                                SpecialDealsManager.viewSpecialDeals();
                                                break;
                                            case 4:
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please try again.");
                                        }

                                        if (choice_3 == 4) {
                                            break;
                                        }
                                    }
                                    break;
                                case 6:
                                    // Total Visitors
                                    int visitors = 0;
                                    for (Visitor visitor : VisitorManager.getRegisteredVisitors()) {
                                        if (visitor.isHasBasicMembership() || visitor.isHasPremiumMembership()) {
                                            visitors++;
                                        }
                                    }
                                    System.out.println("Total visitors: "+visitors);
                                    // Total Revenue
                                    System.out.println("Total Revenue : "+Main.getRevenue());
                                    // Most visited attraction
                                    String maxAttraction = "";
                                    int maxVisits = 0;
                                    for (Attraction attractions : Attractions.getAttraction_List()) {
                                        if (attractions.getNumberOfVisitors() > maxVisits) {
                                            maxAttraction = attractions.getName();
                                            maxVisits = attractions.getNumberOfVisitors();
                                        }
                                    }
                                    if (maxAttraction.isEmpty()) {
                                        System.out.println("Most visited : No attraction has been visited yet");
                                    }
                                    else {
                                        System.out.println("Most Visited : "+maxAttraction);
                                    }
                                case 7:
                                    VisitorManager.viewFeedback();
                                    break;
                                case 8:
                                    System.out.println("Logged out.");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                            if (choice_2 == 8) {
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid username or password. Please try again.\n");
                    }
                    break;

                case 2:
                    System.out.println("1. Register");
                    System.out.println("2. Login\n");

                    System.out.print("Enter your choice: ");
                    int choice_2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice_2) {
                        case 1:
                            System.out.print("Enter Your Name: ");
                            String visitorName = scanner.nextLine();
                            System.out.print("Enter Your Age: ");
                            int visitorAge = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Your Phone Number: ");
                            String visitorPhoneNumber = scanner.nextLine();
                            System.out.print("Enter Initial Balance: ");
                            double initialBalance = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter Your Email: ");
                            String visitorEmail = scanner.nextLine();
                            System.out.print("Enter Your Password: ");
                            String visitorPassword = scanner.nextLine();

                            VisitorManager.registerVisitor(visitorName, visitorAge, visitorPhoneNumber, initialBalance, visitorEmail, visitorPassword);
                            break;

                        case 2:
                            System.out.print("Enter Your Email: ");
                            String email = scanner.nextLine();
                            Visitor loggedInVisitor = VisitorManager.getVisitorByEmail(email);

                            if (loggedInVisitor != null) {
                                System.out.print("Enter Your Password: ");
                                String password = scanner.nextLine();

                                if (loggedInVisitor.getPassword().equals(password)) {
                                    while (true) {
                                        System.out.println("\nVisitor Menu:");
                                        System.out.println("1. Explore the Zoo");
                                        System.out.println("2. Buy Tickets");
                                        System.out.println("3. Buy Membership");
                                        System.out.println("4. View Discounts");
                                        System.out.println("5. Visit Attractions");
                                        System.out.println("6. Visit Animals");
                                        System.out.println("7. Give Feedback");
                                        System.out.println("8. Logout\n");

                                        System.out.print("Enter your choice: ");
                                        int choice_3 = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (choice_3) {
                                            case 1:
                                                System.out.println("Explore the Zoo:");
                                                System.out.println("1. View Attractions");
                                                System.out.println("2. View Animals");
                                                System.out.println("3. Exit");
                                                System.out.print("Enter your choice: ");
                                                int exploreChoice = scanner.nextInt();
                                                scanner.nextLine();
                                                if(exploreChoice==1){
                                                    Attractions.viewAttractions();
                                                    break;
                                                }
                                                else if(exploreChoice==2){
                                                    animalManager.viewAnimals();
                                                    break;
                                                }

                                                else if(exploreChoice==3){
                                                    break;
                                                }
                                                else{
                                                    System.out.println("Invalid Choice.");
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Enter Number of tickets: ");
                                                int num_of_tickets=Integer.parseInt(new Scanner(System.in).nextLine());
                                                for(int i=0;i<num_of_tickets;i++){
                                                    new VisitorManager().Buyticket(loggedInVisitor);
                                                }
                                            case 3:
                                                System.out.println("Buy Membership:");
                                                System.out.println("1. Basic Membership (₹20)");
                                                System.out.println("2. Premium Membership (₹50)");
                                                System.out.println("3. Back to Attractions Menu");
                                                System.out.print("Enter your choice: ");
                                                int membershipChoice = scanner.nextInt();
                                                scanner.nextLine();
                                                switch (membershipChoice) {
                                                    case 1:
                                                        System.out.println("Enter Discount Code (MINOR10/SENIOR20):");
                                                        String discountCode = scanner.nextLine();
                                                        double price = 20.0;
                                                        for (int i=0;i<DiscountManager.getDiscountList().size();i++) {
                                                            if (DiscountManager.getDiscountList().get(i).getCouponCode().equals(discountCode)) {
                                                                if (DiscountManager.getDiscountList().get(i).getCouponCode().equals("MINOR10")) {
                                                                    if (loggedInVisitor.getAge() >= 18) {
                                                                        System.out.println("Not Applicable.");
                                                                        break;
                                                                    }
                                                                }
                                                                else if (DiscountManager.getDiscountList().get(i).getCouponCode().equals("SENIOR20")) {
                                                                    if (loggedInVisitor.getAge() < 60) {
                                                                        System.out.println("Not Applicable");
                                                                        break;
                                                                    }
                                                                }
                                                                price -= ((DiscountManager.getDiscountList().get(i).getPercentage()/100.0)*price);
                                                                break;
                                                            }
                                                        }
                                                        revenue+= (int) price;
                                                        System.out.print("Basic Membership purchased successfully.");
                                                        loggedInVisitor.buyBasicMembership(price);
                                                        VisitorManager.updateVisitor(loggedInVisitor);
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter Discount Code (MINOR10/SENIOR20):");
                                                        String discountCode1 = scanner.nextLine();
                                                        double price1 = 50.0;
                                                        for (int i=0;i<DiscountManager.getDiscountList().size();i++) {
                                                            if (DiscountManager.getDiscountList().get(i).getCouponCode().equals(discountCode1)) {
                                                                if (DiscountManager.getDiscountList().get(i).getCouponCode().equals("MINOR10")) {
                                                                    if (loggedInVisitor.getAge() >= 18) {
                                                                        System.out.println("Not Applicable");
                                                                        break;
                                                                    }
                                                                } else if (DiscountManager.getDiscountList().get(i).getCouponCode().equals("SENIOR20")) {
                                                                    if (loggedInVisitor.getAge() < 60) {
                                                                        System.out.println("Not Applicable");
                                                                        break;
                                                                    }
                                                                }
                                                                price1 -= ((DiscountManager.getDiscountList().get(i).getPercentage() / 100.0) * price1);
                                                                break;
                                                            }
                                                        }
                                                        revenue+= (int) price1;
                                                        System.out.print("Premium Membership purchased successfully.");
                                                        loggedInVisitor.buyPremiumMembership(price1);
                                                        VisitorManager.updateVisitor(loggedInVisitor);
                                                        break;

                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Invalid choice. Please try again.");
                                                }
                                                break;

                                            case 4:
                                                DiscountManager.viewDiscounts();
                                                break;
                                            case 5:
                                                new VisitorManager().visitAttraction();break;
                                            case 6:
                                                animalManager.visitAnimal();
                                                break;
                                            case 7:
                                                scanner.nextLine(); // Clear the newline character left by nextInt
                                                System.out.print("Enter Your Feedback: ");
                                                String feedback = scanner.nextLine();
                                                loggedInVisitor.addFeedback(feedback);
                                                System.out.println("Feedback submitted successfully.\n");
                                                break;
                                            case 8:
                                                System.out.println("Logged out.");
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please try again.");
                                        }
                                        if (choice_3 == 8) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else {
                                    System.out.println("Invalid password. Please try again.\n");
                                }
                            }
                            else {
                                System.out.println("Visitor not found. Please register first.\n");
                            }

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 3:
                    SpecialDealsManager.viewSpecialDeals();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}