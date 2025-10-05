package org.example;
import java.util.*;
public class Attractions {
    static ArrayList<Attraction> Attraction_List = new ArrayList<>();
        private int attractionIdCounter = 1;  // Initialize ID counter

    public static ArrayList<Attraction> getAttraction_List() {
        return Attraction_List;
    }

    public static void setAttraction_List(ArrayList<Attraction> attraction_List) {
        Attraction_List = attraction_List;
    }

    public int getAttractionIdCounter() {
        return attractionIdCounter;
    }

    public void setAttractionIdCounter(int attractionIdCounter) {
        this.attractionIdCounter = attractionIdCounter;
    }

    public void addAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Attraction Name: ");
        String attractionName = scanner.nextLine();
        System.out.println("Enter Attraction Description: ");
        String attractionType = scanner.nextLine();

        // Create a new Attraction with a unique ID
        Attraction attraction = new Attraction(attractionIdCounter, attractionName, attractionType);

        Attraction_List.add(attraction);  // Use the correct variable name
        System.out.println("Attraction added successfully with ID: " + attractionIdCounter);
        attractionIdCounter++;  // Increment the ID counter for the next attraction
    }

    public static double sellTicket(Visitor v,String code,int id){
        double price = Attraction_List.get(id).getTicketPrice();
        if(code.equals("MINOR10")) price=price*0.9;
        if(code.equals("SENIOR20")) price=price*0.8;
        if(v.getTicketCount()>3) price =price*0.7;
        if(v.getTicketCount()>3) price =price*0.85;
        Attraction_List.get(id).setNumberOfVisitors(Attraction_List.get(id).getNumberOfVisitors() + 1);
        return price;
    }
    public void modifyAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Attraction Name to Modify: ");
        String attraction_name_2 = scanner.nextLine();

        for (Attraction attraction : Attraction_List) {
            if (attraction.getName().equals(attraction_name_2)) {
                System.out.println("Enter New Attraction Name: ");
                String new_name = scanner.nextLine();
                System.out.println("Enter New Attraction Description: ");
                String new_type = scanner.nextLine();

                attraction.setName(new_name);
                attraction.setType(new_type);

                System.out.println("Attraction information modified successfully.");
                return;
            }
        }

        System.out.println("Attraction not found in the list.");
    }

    public void removeAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Attraction Name: ");
        String attraction_name_2 = scanner.nextLine();

        Iterator<Attraction> iterator = Attraction_List.iterator();
        while (iterator.hasNext()) {
            Attraction attraction = iterator.next();
            if (attraction.getName().equals(attraction_name_2)) {
                iterator.remove();
                System.out.println("Attraction removed successfully.");
                return;
            }
        }

        System.out.println("Attraction not found in the list.");
    }

    public static void viewAttractions() {
        System.out.println("List of Attractions:");
        for (Attraction attraction : Attraction_List) {
            System.out.println("ID: " + attraction.getId() + ", Name: " + attraction.getName() + ", Description: " + attraction.getType());
        }
    }

    public void scheduleEvent() {
        Scanner scanner = new Scanner(System.in);

        // Display the available attractions with their IDs
        System.out.println("Available Attractions:");
        for (Attraction attraction : Attraction_List) {
            System.out.println("ID: " + attraction.getId() + ", Name: " + attraction.getName());
        }

        System.out.print("Enter Attraction ID to Schedule an Event: ");
        int attractionId = scanner.nextInt();
        scanner.nextLine();

        boolean attractionExists = false;
        Attraction selectedAttraction = null;

        // Check if the entered attraction ID exists
        for (Attraction attraction : Attraction_List) {
            if (attraction.getId() == attractionId) {
                attractionExists = true;
                selectedAttraction = attraction;
                break;
            }
        }

        if (attractionExists) {
            System.out.print("Enter Event Status (Open/Close): ");
            String eventStatus = scanner.nextLine();
            selectedAttraction.setEventStatus(eventStatus);

            System.out.print("Enter Event Ticket Price: ");
            double eventTicketPrice = scanner.nextDouble();
            scanner.nextLine();
            selectedAttraction.setEventTicketPrice(eventTicketPrice);

            System.out.println("Event scheduled successfully for " + selectedAttraction.getName());
        }
        else {
            System.out.println("Attraction with ID " + attractionId + " does not exist in the list.");
        }
    }
}