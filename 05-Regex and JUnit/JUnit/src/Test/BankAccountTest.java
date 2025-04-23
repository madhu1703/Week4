import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawExactBalance() {
        account.deposit(100.0);
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account.deposit(50.0);
        account.withdraw(100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-20.0);
    }
}

