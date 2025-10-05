package org.example;

public class Discount {
    private double percentage;
    private String couponCode;
    public Discount( double percentage, String couponCode) {
        this.percentage = percentage;
        this.couponCode = couponCode;
    }

    public Discount() {
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


    public double getPercentage() {
        return percentage;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}