package services.customerservices;

import database.DataBase;
import entity.Customer;
import services.AccountMangementServices;

import java.util.Scanner;

public class CustomerLogin {

    Scanner sc = new Scanner(System.in);
   public CustomerLogin(){
       System.out.print("\nEnter your name: ");
       String customerName = sc.nextLine();

       System.out.print("Enter your password: ");
       String password = sc.nextLine();

       loginCustomer(customerName,password);
   }

   //Login validation
    public void loginCustomer(String customerName, String password) {
        boolean accountFound = false;
        for (Customer existingCustomer : DataBase.customers) {
            if (existingCustomer.getCustomerName().equalsIgnoreCase(customerName) && existingCustomer.getPassword().equals(password)) {
                System.out.println("\nWelcome " + customerName);
                AccountMangementServices accountMangementServices = new AccountMangementServices(existingCustomer);
                accountFound = true;
                break;
            }
        }
        if(!accountFound) System.out.println("\nERROR! Username and password are not matched");
    }
}
