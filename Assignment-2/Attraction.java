package org.example;
public class Attraction {

    private int attractionId;  // Unique ID for each attraction
    private int id; // Add an ID field
    private String name;
    private String type;
    private boolean isOpen;
    private double ticketPrice;
    private String eventStatus;  // Open/Close status of the event
    private double eventTicketPrice;
    private int numberOfVisitors;

    public Attraction() {
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


    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public void setNumberOfVisitors(int numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }


    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public double getEventTicketPrice() {
        return eventTicketPrice;
    }

    public void setEventTicketPrice(double eventTicketPrice) {
        this.eventTicketPrice = eventTicketPrice;
    }

    public Attraction(int attractionIdCounter, String name, String type) {
        this.id = id;
        this.attractionId = attractionId;
        this.name = name;
        this.type = type;
        this.isOpen = false;  // Default status is closed
        this.ticketPrice = 0.0;  // Default ticket price
        this.eventStatus = "Closed";  // Default event status is closed
        this.eventTicketPrice = 0.0;  // Default event ticket price
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
