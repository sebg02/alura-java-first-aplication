/**
 * @author SEB
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "CR7";
        String accountType = "Checking account";
        double balance = 2000;

        System.out.println("-------------------------------");
        System.out.println("Welcome to SEB's bank!");
        System.out.println("Client's name: " + name);
        System.out.println("Account type: " + accountType);
        System.out.println("Available balance: $" + balance);
        System.out.println("------------------------------- \n");

        while (true) {
            System.out.println("Select an option, enter the respective number.");
            System.out.println("1 - Watch balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Deposit");
            System.out.println("9 - Exit");

            System.out.println("");
            System.out.print("> ");
            String option = scanner.nextLine();

            if (option.equals("9")) {
                System.out.println("Good Bye! We hope to see you again " + name + ".\n");
                break;
            }

            switch (option) {
                case "1":
                    showBalance(balance);
                    break;
                case "2":
                    System.out.println("What amount would you like to withdraw?");
                    System.out.print("> $");
                    double amount = Double.parseDouble(scanner.nextLine());
                    balance = withdraw(amount, balance);
                    showBalance(balance);
                    break;
                case "3":
                    System.out.println("What amount are you going to deposit?");
                    System.out.print("> $");
                    double amountDeposit = Double.parseDouble(scanner.nextLine());
                    balance = deposit(amountDeposit, balance);
                    showBalance(balance);
                    break;
                default:
                    System.out.println("Invalid option, please try again. \n");
            }
        }

        scanner.close(); 
    }

    public static double deposit(double amount, double balance) {
        if (amount > 0) {
            return balance + amount;
        }
        System.out.println("Incorrect amount!");
        return balance;
    }

    public static void showBalance(double balance) {
        System.out.println("The updated balance is $" + balance + "\n");
    }

    public static double withdraw(double amount, double balance) {
        if (amount > 0 && verifyBalanceToWithdraw(balance, amount)) {
            return balance - amount;
        } else {
            System.out.println("Insufficient balance!");
            return balance;
        }
    }

    public static boolean verifyBalanceToWithdraw(double balance, double amount) {
        return balance >= amount;
    }

}