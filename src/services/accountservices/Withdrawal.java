package services.accountservices;

import entity.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static database.DataBase.customers;

public class Withdrawal {
    Scanner sc = new Scanner(System.in);
    Customer customer;
    double withdrawAmount;
    boolean validAmount = true;

    public Withdrawal(Customer customer) {
        this.customer = customer;

        while (validAmount) {  // reciving  withdrawal amount from customer untill  get  a valid amount
            try {
                System.out.println("\nEnter the amount to be withdraw..");
                withdrawAmount = sc.nextDouble();
                //conditions for checking the amount is valid or not
                if (withdrawAmount < 0) System.out.println("\nError! Invalid withdrawal amount.\n");
                else if (customer.getBalance() < withdrawAmount){
                    if (customer.getBalance() == 0) {
                         System.out.println("\nError ! Cannot withdraw from an account with a zero balance.");
                         return;
                     }else {
                        System.out.println("\nError! Insufficient funds. Please enter a valid  withdrawal amount.");
                        return;}
                } else validAmount = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nError: Please enter a valid numeric amount.\n");
            }
        }
        //performing withdrawal operation
        performWithdraw(withdrawAmount);
    }


    private void performWithdraw(double withdrawAmount) {

        for (Customer existingCustomer : customers) {
            if (existingCustomer.getCustomerName().equals(customer.getCustomerName())) {
                existingCustomer.setBalance(existingCustomer.getBalance() - withdrawAmount);//amount withdrawal  operation
                System.out.println("\nWithdraw successful. Current balance: " + existingCustomer.getBalance() + "\n");
                break; // Exit loop once the customer is found and balance is  updated
            }
        }
    }
}
