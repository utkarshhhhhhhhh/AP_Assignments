Main Menu:

Upon running the application, you will be presented with a main menu offering the following options:

Enter as a librarian
Enter as a member
Exit
Librarian Menu:

Choose "Enter as a librarian" to access librarian-specific functionalities.
Librarian functionalities include registering members, removing members, adding books, removing books, viewing member information, and viewing all books.
To return to the main menu, select "Back."
Member Menu:

Choose "Enter as a member" to access member-specific functionalities.
Member functionalities include listing available books, listing borrowed books, issuing books, returning books, paying fines, and returning to the main menu.
Members need to enter their name and phone number to access their account.

Classes:
Books:

This class represents books in the library.
Attributes:
name1: Stores the name of the book.
author: Stores the name of the author.
data1: A static HashMap where book data is stored, with book IDs as keys and Books objects as values.
books2: Another static HashMap where available books are stored.
book_id: A static variable that keeps track of the unique book IDs.
Methods:
getBookId(): Returns the current book ID.
check(String bookName): Searches for a book by name and returns it.
removeBook(): Allows the librarian to remove a book by entering its ID.
Books(): Constructor to create new book entries.
viewAllBooks(): Displays information about all books in the library.
listAvailableBooks(): Displays information about available books.
returnBook(int book_id): Adds a returned book back to the available books.
Members:

This class represents library members.
Attributes:
name2: Stores the name of the member.
age: Stores the age of the member (not used in the code).
phone_number: Stores the phone number of the member.
data2: A static HashMap where member data is stored, with compound keys (name + phone number) as keys and Members objects as values.
issuedBooks: A static HashMap that stores the books issued to each member.
issuedBooks_mine: An ArrayList to track books issued to the current member.
member_id: A static variable that keeps track of the unique member IDs.
fine_calculator: A HashMap to track when books were issued for fine calculation.
fine: Stores the fine amount for the member.
Methods:
getMemberId(): Returns the current member ID.
Members(): Constructor to create new member entries.
check(String name, String phone_number): Searches for a member by name and phone number and returns it.
removeMember(): Allows the librarian to remove a member by entering their name and phone number.
issueBook(): Allows members to borrow books, including fine calculation if books are returned late.
returnBook(): Allows members to return books, updating fine amounts if applicable.
payFine(): Allows members to pay their fines.
Main:

This class contains the main function to start the application and other menu-related functions.
Methods:
displayMainMenu(): Displays the main menu options.
main(String[] args): The main function that handles user interaction.
Librarian_Menu(): Displays the librarian menu options and handles librarian actions.
Member_Menu(): Displays the member menu options and handles member actions.
Functions:
displayMainMenu():

Displays the main menu options, including entering as a librarian, entering as a member, or exiting the application.
main(String[] args):

The main entry point of the application.
Displays the main menu and handles user choices.
Calls the Librarian_Menu() or Member_Menu() functions based on the user's choice.
Librarian_Menu():

Displays the librarian menu options, including registering members, removing members, adding books, removing books, viewing member information, viewing all books, and going back to the main menu.
Handles librarian actions based on user choices.
Member_Menu():

Displays the member menu options, including listing available books, listing borrowed books, issuing books, returning books, paying fines, and going back to the main menu.
Handles member actions based on user choices.
