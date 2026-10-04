import java.util.*;

class ATM {
    double balance = 10000;
    int pin = 1234;
    double withdrawalLimit = 5000;

    // PIN Verification
    void verifyPIN(int enteredPin) throws Exception {
        if (enteredPin != pin) {
            throw new Exception("Invalid PIN.");
        }
    }

    // Balance Enquiry
    void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    // Withdrawal
    void withdraw(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception("Invalid transaction amount.");
        }

        if (amount > withdrawalLimit) {
            throw new Exception("Withdrawal limit exceeded. Maximum limit is Rs." 
                                + withdrawalLimit);
        }

        if (amount > balance) {
            throw new Exception("Insufficient balance.");
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful!");
        System.out.println("Withdrawn Amount: Rs." + amount);
        System.out.println("Remaining Balance: Rs." + balance);
    }

    // Deposit
    void deposit(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception("Invalid transaction amount.");
        }

        balance = balance + amount;

        System.out.println("Deposit successful!");
        System.out.println("Deposited Amount: Rs." + amount);
        System.out.println("Current Balance: Rs." + balance);
    }
}

public class ATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        try {

            System.out.println("===== ATM SYSTEM =====");

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            atm.verifyPIN(enteredPin);

            System.out.println("\nPIN Verified Successfully!");

            while (true) {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Balance Enquiry");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                try {

                    switch (choice) {

                        case 1:
                            atm.checkBalance();
                            break;

                        case 2:
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = sc.nextDouble();
                            atm.withdraw(withdrawAmount);
                            break;

                        case 3:
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = sc.nextDouble();
                            atm.deposit(depositAmount);
                            break;

                        case 4:
                            System.out.println("Thank you for using the ATM!");
                            return;

                        default:
                            System.out.println("Invalid choice.");

                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}