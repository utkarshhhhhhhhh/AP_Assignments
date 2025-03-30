package org.example;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDateTime;

class Books {
    String name1;
    String author;
    public static HashMap<Integer, Books> data1 = new HashMap<>();
    public static HashMap<Integer, Books> books2 = new HashMap<>();
    private static int book_id = 0;


    public static int getBookId() {
        return book_id;
    }

    public static Books check(String bookName) {
        return data1.get(bookName);
    }
    public static void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book ID:");
        int book_id_input = scanner.nextInt();
        scanner.nextLine();
        if (data1.containsKey(book_id_input)) {
            data1.remove(book_id_input);
            books2.remove(book_id_input); // Remove the book from books2 as well
            System.out.println("Book Successfully removed with Book ID: " + book_id_input + "!");
        } else {
            System.out.println("No Book with Book ID: " + book_id_input + " found!");
        }
    }



    public Books() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book details:");
        System.out.print("Book Name: ");
        String bookName = scanner.nextLine();
        System.out.print("Author Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Number Of Copies: ");
        int no_of_copies = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < no_of_copies; i++) {
            this.name1 = bookName;
            this.author = authorName;
            book_id++; // Increment book_id for each copy

            data1.put(book_id, this); // Use a compound key including author and book_id
            books2.put(book_id, this); // Set the book ID as the key in books2
        }

        System.out.println(
                "Books Successfully added with Book IDs: " + (book_id - no_of_copies + 1) + " to " + book_id + "!");
    }


    public static void viewAllBooks() {
        data1.forEach((key, value) -> {
            System.out.println("Name- " + value.name1);
            System.out.println("Author- " + value.author);
            System.out.println("Book ID: " + key);
        });
    }

    public static void listAvailableBooks() {
        System.out.println("Available Books:");
        books2.forEach((key, value) -> {
            System.out.println("Name: " + value.name1);
            System.out.println("Author: " + value.author);
            System.out.println("Book ID: " + key);
            System.out.println("--------------------------");
        });
    }

    public static void returnBook(int book_id) {
        for (Map.Entry<Integer,Books> i : data1.entrySet()) {
            if (i.getKey() == book_id) {
                books2.put(book_id,i.getValue());
                break;
            }
        }
    }

}

class Members {
    String name2;
    String age;
    String phone_number;
    private static HashMap<String, Members> data2 = new HashMap<>();
    private static HashMap<Integer, Integer> issuedBooks = new HashMap<>();
    private ArrayList<Integer> issuedBooks_mine = new ArrayList<>();
    private static int member_id = 1000;
    private HashMap<Integer,LocalDateTime> fine_calculator = new HashMap<>();
    private long fine;

    public static int getMemberId() {
        return member_id;
    }

    public Members() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter member details:");
        System.out.print("Name: ");
        String memberName = scanner.nextLine();
        System.out.print("Age: ");
        String memberAge = scanner.nextLine();
        System.out.print("Phone no: ");
        String memberPhoneNo = scanner.nextLine();
        String compoundKey2 = memberName + "_" + memberPhoneNo; // Create a compound key
        this.name2 = memberName;
        this.age = memberAge;
        this.phone_number = memberPhoneNo;
        data2.put(compoundKey2, this);// Use the compound key to store the member
        System.out.println("Member Successfully Registered with Member ID: !!!");
        member_id++;
    }

    public static Members check(String name, String phone_number) {
        String compoundKey = name + "_" + phone_number;
        return data2.get(compoundKey);
    }

    public static void removeMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter member details:");
        System.out.print("Member Name: ");
        String memberName = scanner.nextLine();
        System.out.print("Phone Number: ");
        String memberPhoneNo = scanner.nextLine();
        String compoundKey = memberName + "_" + memberPhoneNo;

        Members removedMember = data2.remove(compoundKey);

        if (removedMember != null) {
            System.out.println("Member Successfully removed with Member ID: " + (member_id - 1) + "!");
        } else {
            System.out.println("No member with the provided details found.");
        }
    }

    public static void viewMembersInfo() {
    }

    public static void listMyBooks() {
    }

    public void issueBook() {
        if (this.issuedBooks_mine.size() == 2) {
            System.out.println("Can't issue more. Max limit reached");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book ID: ");
        int issue_book_id = scanner.nextInt();
        scanner.nextLine();

        if (Books.books2.containsKey(issue_book_id)) {
            // Check if the book is already issued
            if (issuedBooks.containsKey(issue_book_id)) {
                System.out.println("Book with ID " + issue_book_id + " is already issued to Member ID " + issuedBooks.get(issue_book_id));
            } else {
                Books registeredBook = Books.books2.get(issue_book_id);
                System.out.println("Book: " + registeredBook.name1 + " Book ID: " + issue_book_id + " issued to Member ID: " + Members.getMemberId());
                // Update issuedBooks and remove the book
                issuedBooks.put(issue_book_id, Members.getMemberId());
                this.issuedBooks_mine.add(issue_book_id);
                Books.books2.remove(issue_book_id); // Remove the book from books2
                fine_calculator.put(issue_book_id,LocalDateTime.now());
            }
        } else {
            System.out.println("Book with Book ID: " + issue_book_id + " not found or criteria do not match.");
        }
    }



    public void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book ID : ");
        int book_id = scanner.nextInt();
        scanner.nextLine();
        if (issuedBooks.containsKey(book_id)) {
            LocalDateTime first = fine_calculator.get(book_id);
            LocalDateTime second = LocalDateTime.now();
            Books.returnBook(book_id);
            fine_calculator.remove(book_id);
            issuedBooks.remove(book_id);
            this.issuedBooks_mine.remove(Integer.valueOf(book_id));
            long temp_fine = first.until(second, ChronoUnit.SECONDS);
            if (temp_fine<=10) {
                return;
            }
            this.fine = 3*(temp_fine-10);
        }
        else {
            System.out.println("Book id not found in issued section");
        }
    }


    public void payFine() {
        System.out.println("Your fine of "+this.fine+" Rs. paid");
        this.fine = 0;
    }
}

public class Main {
    public static void displayMainMenu() {
        System.out.println("Library Portal Initialized…");
        System.out.println("---------------------------------");
        System.out.println("1.) Enter as a librarian");
        System.out.println("2.) Enter as a member");
        System.out.println("3.) Exit");
        System.out.println("---------------------------");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                Librarian_Menu();
            } else if (choice == 2) {
                Member_Menu();
            } else if (choice == 3) {
                System.out.println("Exit");
                break;
            }
        }
    }

    public static void Librarian_Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean backToMainMenu = false; // Flag to control navigation

        while (!backToMainMenu) {
            System.out.println("Librarian Menu");
            System.out.println("---------------------------------");
            System.out.println("1.) Register a member");
            System.out.println("2.) Remove a member");
            System.out.println("3.) Add a book");
            System.out.println("4.) Remove a book");
            System.out.println("5.) View all members along with their books and fines to be paid");
            System.out.println("6.) View all books");
            System.out.println("7.) Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");

            int choice1 = scanner.nextInt();
            scanner.nextLine();

            switch (choice1) {
                case 1:
                    // Register a member
                    Members temp1 = new Members();
                    break;
                case 2:
                    Members.removeMember(); // Remove a member
                    break;
                case 3:
                    Books temp2 = new Books(); // Add a book
                    break;
                case 4:
                    Books.removeBook(); // Remove a book
                    break;
                case 5:
                    Members.viewMembersInfo();
                    break;
                case 6:
                    Books.viewAllBooks();
                    break;
                case 7:
                    System.out.println("Exit");
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void Member_Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Member details: ");
        System.out.println("Member Name: ");
        String name = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phone = scanner.nextLine(); // Change the data type to String

        Members registeredMember = Members.check(name, phone);

        if (registeredMember != null) {
            int memberId = Members.getMemberId();
            System.out.println("Welcome " + name + " Member ID: " + memberId);

            do {
                System.out.println("Member Menu");
                System.out.println("---------------------------------");
                System.out.println("1.) List Available Books");
                System.out.println("2.) List My Books");
                System.out.println("3.) Issue book");
                System.out.println("4.) Return book");
                System.out.println("5.) Pay Fine");
                System.out.println("6.) Back");
                System.out.println("---------------------------------");
                System.out.print("Enter your choice: ");
                int choice2 = scanner.nextInt();
                scanner.nextLine();

                switch (choice2) {
                    case 1:
                        Books.listAvailableBooks();
                        break;
                    case 2:
                        registeredMember.listMyBooks();
                        break;
                    case 3:
                        registeredMember.issueBook();
                        break;
                    case 4:
                        registeredMember.returnBook();
                        break;
                    case 5:
                        registeredMember.payFine();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (true);
        } else {
            System.out.println("Member with Name: " + name + " and Phone No: " + phone + " doesn't exist.");
        }
    }
}
