import java.util.Random;
import java.util.Scanner;

public class BankAccount {

    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance;

    public BankAccount(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = getRandomNumberInRange(100000,200000);
        this.balance = 0;
        validate();
        System.out.println("Your account number is: " + accountNumber);
        System.out.println("******************************************");
    }

    //GETTERS
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    //Method to generate random number for purposes of attaining random
    //account number within specified range
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    //Method to validate that neither first nor last name arguments are empty
    public void validate(){
        if(firstName.isEmpty() || lastName.isEmpty()){
            throw new IllegalArgumentException("Need First Name");
        }
    }

    //Method to deposit funds
    public double deposit(double amount){
        if(amount <= 0){
            System.out.println("Cannot deposit $0 or less than");
            return 0;
        }
        balance += amount;
        return balance;
    }

    //method to withdraw funds
    public double withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance");
            return 0;
        }
        else {
            balance -= amount;
            return balance;
        }
    }
}
