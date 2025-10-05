package org.example;
import java.util.*;
public class Visitor {
    int ticketCount=0;
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private ArrayList<Feedback> feedbackList = new ArrayList<>();
    private boolean hasBasicMembership;
    private boolean hasPremiumMembership;
    private double membershipPrice;
    private boolean isBasicUser;

    public Visitor(boolean isBasicUser) {
        this.isBasicUser = isBasicUser;
    }

    public boolean isBasicUser() {
        return isBasicUser;
    }

    public void setFeedbackList(ArrayList<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }


    public void setHasMembership(boolean hasMembership) {
        this.hasBasicMembership = hasMembership;
    }

    public void setMembershipPrice(double membershipPrice) {
        this.membershipPrice = membershipPrice;
    }

    public Visitor(String name, int age, String phoneNumber, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.hasBasicMembership = false;
        this.membershipPrice = 0.0;
        this.hasPremiumMembership=false;
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void addFeedback(String feedback) {
        Feedback newFeedback = new Feedback(this, feedback);
        feedbackList.add(newFeedback);
    }

    public Visitor() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public boolean hasMembership() {
        return hasBasicMembership;
    }

    public double getMembershipPrice() {
        return membershipPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isHasBasicMembership() {
        return hasBasicMembership;
    }

    public void setHasBasicMembership(boolean hasBasicMembership) {
        this.hasBasicMembership = hasBasicMembership;
    }

    public boolean isHasPremiumMembership() {
        return hasPremiumMembership;
    }

    public void setHasPremiumMembership(boolean hasPremiumMembership) {
        this.hasPremiumMembership = hasPremiumMembership;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void buyBasicMembership(double price) {
        if (!hasBasicMembership) {
            hasBasicMembership = true;
            membershipPrice = price;
            balance -= price;
        }
    }
    public void buyPremiumMembership(double price) {
        if (!hasPremiumMembership) {
            hasPremiumMembership = true;
            membershipPrice = price;
            balance -= price;
        }
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
