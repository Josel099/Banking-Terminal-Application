package services.accountservices;

import entity.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static database.DataBase.customers;

public class Deposit {

    Scanner sc = new Scanner(System.in);
    double depositAmount;
    boolean validAmount = true;
    Customer customer ;


    public Deposit(Customer customer) {
        this.customer = customer;
        while (validAmount) {
            try {
                System.out.println("\nEnter the deposit amount:");
                depositAmount = sc.nextDouble();

                if (depositAmount > 0) {
                    validAmount = false;
                } else {
                    System.out.println("\nError: Please enter a valid amount greater than 0.\n");
                }
            } catch (InputMismatchException e) {
                // Handle the exception when a non-double value is entered
                sc.nextLine();
                System.out.println("\nError: Please enter a valid numeric amount.\n");
            }
        }
        bankBalanceUpdate();
    }

    private  void bankBalanceUpdate() {
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getCustomerName().equals(customer.getCustomerName())) {
                double currentBalance = existingCustomer.getBalance() + depositAmount;
                existingCustomer.setBalance(currentBalance);
                System.out.println("\nDeposit successful. Current balance: " + currentBalance+"\n");
                break; // Exit loop once the customer is found and updated
            }

        }
    }
}