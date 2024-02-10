package services;

import entity.Customer;
import services.accountservices.CheckBalance;
import services.accountservices.Deposit;
import services.accountservices.Withdrawal;

import java.util.Scanner;

public class AccountMangementServices {
    private static final Scanner sc = new Scanner(System.in) ;
    Customer customer;
    public AccountMangementServices(Customer customer) {

        this.customer = customer;
        menu();
    }




public  void menu() {
    String option;

    do {
        displayMenu();
        option = getOption();

        switch (option) {
            case "a":
                    Deposit deposit = new Deposit(customer);
                break;

            case "b":
                    Withdrawal withdrawal = new Withdrawal(customer);
                break;

            case "c":
                CheckBalance checkBalance = new CheckBalance(customer);
                break;

            case "d":
                System.out.println("\nExited Application successfully...\n");
                break;

            default:
                System.out.println("\nWrong option chosen. Please try again.");
                break;
        }
    } while (!option.equalsIgnoreCase("d")); // Continue the loop until the user chooses to exit
}

    private static void displayMenu() {
        System.out.println("\na) Amount Deposit\nb) Amount Withdrawal\nc) Check Balance\nd) Exit\nEnter your choice: ");
    }
    private static String getOption() {
        return sc.nextLine();
    }
}

