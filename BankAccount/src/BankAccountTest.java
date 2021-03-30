import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    //Test to make sure exception thrown when first name is empty
    @Test(expected = IllegalArgumentException.class)
    public void testFirstNotEmpty() {
        BankAccount goran = new BankAccount("", "Somic");
    }

    //Test to make sure exception thrown when last name is empty
    @Test(expected = IllegalArgumentException.class)
    public void testLastNotEmpty() {
        BankAccount goran = new BankAccount("Goran", "");
    }


    //Test to see if deposit() returns 0 when deposit amount
    //is less than or equal to $0
    @Test
    public void testDepositZero() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        double result = goran.deposit(0);
        assertEquals(0, result, .1);
    }

    //Test to see if deposit() returns 0 when deposit amount
    //is less than or equal to $-1
    @Test
    public void testDepositNeg() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        double result = goran.deposit(-1);
        assertEquals(0, result, .1);
    }

    //Test to see if deposit() returns 1 when deposit amount
    //is $1---BOUNDARY TEST
    @Test
    public void testDepositOne() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        double result = goran.deposit(1);
        assertEquals(1, result, .0001);
    }

    //Test to see that withdrawal within available funds works, double call to
    //withdraw method in test below
    @Test
    public void testWithdrawNormal() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        goran.deposit(1000);
        goran.withdraw(400);
        double result = goran.getBalance();
        assertEquals(600, result, 0.0001);
        goran.withdraw(200);
        result = goran.getBalance();
        assertEquals(400, result, 0.0001);
    }

    //Test to check that conditional to see if insufficient funds to withdraw
    //amount requested works
    @Test
    public void testWithdrawOver() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        goran.deposit(500);
        double result = goran.withdraw(600);
        assertEquals(0, result, 0.0001);

    }

    //Test to check that conditional to see if insufficient funds to withdraw
    //amount requested works when under by $1
    @Test
    public void testWithdrawOver2() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        goran.deposit(500);
        double result = goran.withdraw(501);
        assertEquals(0, result, 0.0001);
    }

    //Test to check that can withdraw full amount in account, leaving $0 in account--
    //Boundary test
    @Test
    public void testWithdraw2() {
        BankAccount goran = new BankAccount("Goran", "Somic");
        goran.deposit(500);
        goran.withdraw(500);
        double result = goran.getBalance();
        assertEquals(0, result, 0.0001);
    }
}