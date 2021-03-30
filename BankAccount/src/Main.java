import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get first name input
        System.out.println("Enter your First Name: ");
        String firstName = scanner.nextLine();

        //get last name input
        System.out.println("Enter your Last Name: ");
        String lastName = scanner.nextLine();

        //create account with provided input
        BankAccount account = new BankAccount(firstName,lastName);

        //
        int menu;
        System.out.println("Please select an option");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Get Account Balance");
        System.out.println("4. Use Free Mortgage Calculator");
        System.out.println("5. EXIT");
        boolean quit = false;
        do {
            System.out.print("Please enter your choice: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("How much would you like to deposit?");
                    double amountD = scanner.nextDouble();
                    account.deposit(amountD);
                    System.out.println("Your Deposit was accepted, thank you.");
                    break;

                case 2:
                    System.out.println("How much would you like to withdraw?");
                    double amountW = scanner.nextDouble();
                    double res = account.withdraw(amountW);
                    double current = account.getBalance();
                    System.out.println("You have $" + current + " left in your account");
                    break;

                case 3:
                    System.out.println("Your account balance is: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Please enter loan amount: ");
                    double pri = scanner.nextDouble();
                    System.out.println("Please enter interest rate: ");
                    double r = scanner.nextDouble();
                    System.out.println("Please enter number of years of loan: ");
                    double yrs = scanner.nextDouble();
                    MortgageCalculator calculator = new MortgageCalculator(pri,r,yrs);
                    String ans = calculator.calculate();
                    System.out.println("Estimated monthly payment: $"+ans);
                    break;

                case 5:
                    quit = true;
                    System.out.println("Good-Bye");
                    break;
            }
        } while (!quit);

    }
}
