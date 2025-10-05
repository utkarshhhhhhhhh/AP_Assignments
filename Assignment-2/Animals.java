package org.example;
import java.util.*;

public class Animals{
    private ArrayList<Animal> Animal_List = new ArrayList<>();

    // Hardcode minimum required animals

    public Animals() {
        Animal elephant = new Animal("Elephant", "Mammal");
        elephant.setSound("Trumpet");
        elephant.setBriefHistory("Elephants are large mammals known for their long trunks.");
        Animal_List.add(elephant);

        Animal monkey = new Animal("Monkey", "Mammal");
        monkey.setSound("Chatter");
        monkey.setBriefHistory("Monkeys are primates known for their agility and intelligence.");
        Animal_List.add(monkey);

        Animal frog = new Animal("Frog", "Amphibian");
        frog.setSound("Ribbit");
        frog.setBriefHistory("Frogs are amphibians known for their jumping abilities.");
        Animal_List.add(frog);

        Animal salamander = new Animal("Salamander", "Amphibian");
        salamander.setSound("Hiss");
        salamander.setBriefHistory("Salamanders are amphibians with a unique body structure.");
        Animal_List.add(salamander);

        Animal lizard = new Animal("Lizard", "Reptile");
        lizard.setSound("Hiss");
        lizard.setBriefHistory("Lizards are reptiles known for their scaly skin.");
        Animal_List.add(lizard);

        Animal snake = new Animal("Snake", "Reptile");
        snake.setSound("Hiss");
        snake.setBriefHistory("Snakes are legless reptiles known for their venomous species.");
        Animal_List.add(snake);
    }
    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal Name: ");
        String animal_name = scanner.nextLine();
        System.out.println("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
        String animal_type = scanner.nextLine();

        // Check if the animal type is valid
        if (!animal_type.equals("Mammal") && !animal_type.equals("Amphibian") && !animal_type.equals("Reptile")) {
            System.out.println("Invalid animal type. Please choose from Mammal, Amphibian, or Reptile.");
            return;
        }

        Animal animal = new Animal(animal_name, animal_type);
        Animal_List.add(animal);
        System.out.println("Animal added successfully.");
    }

    public void updateAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal Name to Update: ");
        String animal_name_2 = scanner.nextLine();

        for (Animal animal : Animal_List) {
            if (animal.getName().equals(animal_name_2)) {
                System.out.println("Enter New Animal Name: ");
                String new_name = scanner.nextLine();
                System.out.println("Enter New Animal Type: ");
                String new_type = scanner.nextLine();

                animal.setName(new_name);
                animal.setType(new_type);

                System.out.println("Animal information updated successfully.");
                return;
            }
        }

        System.out.println("Animal not found in the list.");
    }

    public void removeAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal Name: ");
        String animal_name_2 = scanner.nextLine();

        Iterator<Animal> iterator = Animal_List.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getName().equals(animal_name_2)) {
                iterator.remove();
                System.out.println("Animal removed successfully.");
                return;
            }
        }

        System.out.println("Animal not found in the list.");
    }

    public void viewAnimals() {
        System.out.println("List of Animals:");
        for (Animal animal : Animal_List) {
            System.out.println("Name: " + animal.getName() + ", Type: " + animal.getType());
        }
    }

    public void visitAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Animals:");
        for (Animal animal : Animal_List) {
            System.out.println("- " + animal.getName());
        }

        System.out.print("Enter the name of the animal you want to visit: ");
        String animalName = scanner.nextLine();

        for (Animal animal : Animal_List) {
            if (animal.getName().equalsIgnoreCase(animalName)) {  // Use equalsIgnoreCase for case-insensitive comparison
                System.out.println("You are visiting the " + animal.getName() + ".");
                System.out.println("What would you like to do?");
                System.out.println("1. Feed the " + animal.getName());
                System.out.println("2. Read about the " + animal.getName());
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("You chose to feed the " + animal.getName() + ".");
                        System.out.println("The " + animal.getName() + " makes the following sound: " + animal.getSound());
                        break;
                    case 2:
                        System.out.println("You chose to read about the " + animal.getName() + ".");
                        System.out.println("Brief History: " + animal.getBriefHistory());
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                return;
            }
        }
        System.out.println("Animal not found in the list.");
    }

}