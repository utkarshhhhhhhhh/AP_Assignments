package org.example;
import java.util.*;
public class VisitorManager {

    private static ArrayList<Visitor> registeredVisitors = new ArrayList<>();
    private static ArrayList<Integer> ticket_list=new ArrayList<>();

    public static ArrayList<Visitor> getRegisteredVisitors() {
        return registeredVisitors;
    }

    public static void setRegisteredVisitors(ArrayList<Visitor> registeredVisitors) {
        VisitorManager.registeredVisitors = registeredVisitors;
    }

    public static ArrayList<Integer> getTicket_list() {
        return ticket_list;
    }

    public static void setTicket_list(ArrayList<Integer> ticket_list) {
        VisitorManager.ticket_list = ticket_list;
    }

    public void Buyticket(Visitor v){
        for(Attraction attraction: Attractions.Attraction_List){
            System.out.println("Name Of Attraction: "+attraction.getName()+" ID: "+attraction.getAttractionId());
        }
        String code = "invalid code";
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        for(Attraction attraction: Attractions.Attraction_List){
            if(attraction.getId()==choice){
                DiscountManager.viewDiscounts();
                System.out.println("Enter Code or press enter to continue");
                code = new Scanner(System.in).nextLine();
                if(code.isEmpty()) code = "Invalid Code";
                for(Discount discount: DiscountManager.getDiscountList()){
                    if(discount.getCouponCode().equals(code)){
                        if(code.equals("MINOR10") || code.equals("SENIOR20")){
                            if(v.getAge()>=18 && v.getAge()<60){
                                code="invalid code";
                            }
                        }
                    }
                }
                double price = Attractions.sellTicket(v,code,choice);
                if(price>v.getBalance() || price==-1){ System.out.println("Cannot buy ticket");return;}
                System.out.println("Your Ticket has been bought successfully !");
                System.out.println("Balance Left: "+v.getBalance());
                Main.setRevenue((int) (Main.getRevenue() + price));
                ticket_list.add(choice);v.setBalance(v.getBalance()-price);v.setTicketCount(v.getTicketCount()+1);
                return;
            }
            System.out.println("attraction not found");
        }
    }
    public void visitAttraction(){
        for(Attraction attraction: Attractions.Attraction_List){
            System.out.println("Name is "+attraction.getName()+" id is "+attraction.getAttractionId());
        }

        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        for(Attraction attraction: Attractions.Attraction_List){
            if(attraction.getId()==choice && ticket_list.contains(choice)){
                if(attraction.isOpen()){
                    System.out.println("Attraction visited");
                    ticket_list.remove(choice);
                }
                else{
                    System.out.println("Currently close");
                }
            }
            return;
        }
        System.out.println("Attraction was removed");

    }
    public static void registerVisitor(String name, int age, String phoneNumber, double balance, String email, String password) {
        Visitor newVisitor = new Visitor(name, age, phoneNumber, balance, email, password);
        registeredVisitors.add(newVisitor);
        System.out.println("Registration successful.");
    }

    public static boolean loginVisitor(String email, String password) {
        for (Visitor visitor : registeredVisitors) {
            if (visitor.getEmail().equals(email) && visitor.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + visitor.getName() + "!");
                return true;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;
    }

    public static Visitor getVisitorByEmail(String email) {
        for (Visitor visitor : registeredVisitors) {
            if (visitor.getEmail().equals(email)) {
                return visitor;
            }
        }
        return null;
    }

    public static void viewFeedback() {
        for (Visitor visitor : registeredVisitors) {
            ArrayList<Feedback> feedbackList = visitor.getFeedbackList();

            if (!feedbackList.isEmpty()) {
                System.out.print("Feedback from Visitor: " + visitor.getName());
                for (Feedback feedback : feedbackList) {
                    System.out.println("Feedback: " + feedback.getFeedback());
                }
                System.out.println("------------");
            }
        }
    }
    public static void updateVisitor(Visitor visitor) {
        // Update visitor information in the registeredVisitors list
        for (Visitor v : registeredVisitors) {
            if (v.getEmail().equals(visitor.getEmail())) {
                // Update the visitor's information
                v.setName(visitor.getName());
                v.setAge(visitor.getAge());
                v.setPhoneNumber(visitor.getPhoneNumber());
                v.setBalance(visitor.getBalance());
                v.setPassword(visitor.getPassword());
                v.setMembershipPrice(visitor.getMembershipPrice());
                break;  // Optionally, you can break after the update if you want to update only one visitor.
            }
        }
        System.out.print("Your balance is now: ₹ "+visitor.getBalance());
    }
}