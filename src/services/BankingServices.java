package services;
import services.customerservices.CustomerLogin;
import services.customerservices.NewCustomer;

import java.util.*;
public class BankingServices {

    private static final Scanner sc = new Scanner(System.in) ;

    public  BankingServices() {
        int option;

        do {
            displayMenu();
            option = getOption();

            switch (option) {
                case 1:
                    CustomerLogin customerLogin = new CustomerLogin();
                    break;

                case 2:
                    NewCustomer newCustomer = new NewCustomer();
                    break;

                case 3:
                    System.out.println("\nExited Application successfully...");
                    break;

                default:
                    System.out.println("\nWrong option chosen. Please try again.");
                    break;
            }
        } while (option != 3); // Continue the loop until the user chooses to exit
    }

    private  void displayMenu() {
        System.out.println("""

                1. Customer Login
                2. New Customer Sign in
                3. Exit
                """);
        System.out.print("Enter your choice: ");
    }

    private int getOption() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            return 0;
        }
    }
}
