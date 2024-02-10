package entity;

public class Customer {

    private String customerName;
    private String password;
    private double Balance;

    // getters and setters

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
    //constructor
    public Customer(String customerName, String password) {
        this.customerName = customerName;
        this.password = password;
        this.Balance=0;
    }

}