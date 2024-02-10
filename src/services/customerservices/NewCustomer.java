package services.customerservices;

import entity.Customer;
import database.DataBase;

import java.util.Scanner;

public class NewCustomer {
    private static final Scanner sc = new Scanner(System.in);


    public NewCustomer() {
        System.out.print("\nEnter your name: ");
        String customerName = sc.nextLine();

        System.out.print("create  password: ");
        String password = sc.nextLine();

        Customer customer = new Customer(customerName, password);
        addNewCustomer(customer);
    }

    public void addNewCustomer(Customer customer){
        // Perform validation on customer details
        if (isCustomerValid(customer)) {
            DataBase.customers.add(customer);
            System.out.println("\nNew customer added successfully!\nLogin with your Username and Password ");

        } else {
            System.out.println("Not a valid customer…");
        }
    }


    // validation methods of  newly Registered customer
    public boolean isCustomerValid (Customer customer){
        // Check for duplicate customer names
        if (isDuplicateName(customer.getCustomerName())) {
            System.out.println("\nCustomer with the same name already exists");
            return false;
        }
        // Check for strong password
        if (!isStrongPassword(customer.getPassword())) {
            System.out.println("\nError! Weak password. Password must be at least 8 characters long and contain a mix of uppercase, lowercase, and digits.");
            return false;
        }
        return true;  // If no validation errors, return true
    }

    // methods for validating the strong password and duplicate customer name in the database .
    private boolean isDuplicateName (String customerName){
        for (Customer existingCustomer : DataBase.customers) {
            if (existingCustomer.getCustomerName().equalsIgnoreCase(customerName)) { //equalIgnoreCase :  ignore the case difference
                return true; // Duplicate name found
            }
        }
        return false; // No duplicate name found
    }
    private boolean isStrongPassword (String password)
    { // requiring a minimum length and a mix of uppercase, lowercase, and digits

        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*");
    }
}
