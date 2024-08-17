import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Successfully deposited $" + amount + ". New balance: $" + balance;
        } else {
            return "Deposit amount must be positive.";
        }
    }

    public String withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                return "Successfully withdrew $" + amount + ". Remaining balance: $" + balance;
            } else {
                return "Insufficient funds for this withdrawal.";
            }
        } else {
            return "Withdrawal amount must be positive.";
        }
    }

    public String checkBalance() {
        return "Your current balance is: $" + balance;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(account.deposit(depositAmount));
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    System.out.println(account.withdraw(withdrawalAmount));
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500); // Initialize with a balance of $500
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
