package services.accountservices;

import entity.Customer;

public class CheckBalance {
    Customer customer;
    public CheckBalance(Customer customer) {
        this.customer=customer ;
        balance();
    }
    public void balance(){
        double currentBalance = customer.getBalance();
        System.out.println("\nCurrent Balance : " + currentBalance +"\n");
    }
}
