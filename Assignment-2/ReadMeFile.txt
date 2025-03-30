How to access this code in CMD prompt
1. Open terminal and start the code as follows : -
        1. mvn clean
        2. mvn compile
        3. mvn package

 2. This will create a .jar file inside the target folder
 Name of my jar file : -

 3. Followed by this run cd target

 4. Followed by this run
 java -jar .\ name of the jar file

This should hopefully start the execution of this code



ZOOtopia Application

Welcome to the ZOOtopia application, a simple zoo management system that allows administrators and visitors to manage attractions, animals, discounts, special deals, and more.

Features

### Admin Menu

- **Manage Attractions:** Add, modify, remove, or view attractions in the zoo.
- **Manage Animals:** Add, update, remove, or view animals in the zoo.
- **Schedule Event:** Schedule special events at the zoo.
- **Manage Discounts:** Add, modify, remove, or view discounts.
- **Manage Special Deals:** Add, remove, or view special deals.
- **View Visitor Stats:** View visitor statistics, including total visitors, total revenue, and the most visited attraction.
- **View Feedback:** View feedback from visitors.
- **Logout:** Logout from the admin account.

### Visitor Menu

- **Explore the Zoo:** View attractions and animals, or exit.
- **Buy Tickets:** Buy tickets to the zoo.
- **Buy Membership:** Purchase basic or premium memberships with discounts.
- **View Discounts:** View available discounts.
- **Visit Attractions:** Visit attractions and record statistics.
- **Visit Animals:** Visit animals and record statistics.
- **Give Feedback:** Provide feedback about the zoo.
- **Logout:** Logout from the visitor account.

### Special Deals

- View available special deals.

## Important Notes (Assumptions)

- The admin login credentials are "admin" for the username and "admin123" for the password.
- To view attractions or animals, enter the corresponding menu item and follow the prompts.
- The application calculates and displays revenue when memberships are purchased.
- Animals can de added through addAnimal method from the Admin Menu, however, in Visit Animal functionality of Visitor Menu, only the Hardcoded animals,their sounds, and their brief description will be displayed because in the Sample runs provided in the Assignment, no option of taking input for Animal Sound or description was given.
- The price of the premium membership is Rs 50 and basic membership is Rs 20
- The balance of a given user is declared during registration and there is no way to add any more money.
- As a precaution, try to enter the required input as far as possible.
- Coupon Codes Available for use : MINOR10(10% off for age<18) AND SENIOR20(20% off for age>60).
- Special Deal Available for use - If a person buys more than 2 attractions, they get a special discount of on the total amount
                                   If a person buys more than 3 attractions, they get a special discount of on the total amount
