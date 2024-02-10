import services.BankingServices;

public class Main {

    public static void main(String[] args) {
        try {
            // Your application initialization code
            BankingServices bankingServices = new BankingServices();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}