package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;


public class AccountTests {
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount () {

        double amount = 200.00;
        double expectedBalance = 196.00;
        Account account = AccountFactory.createEmptyAccount();
        account.deposit(amount);
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void depositShouldNotIncreaseBalanceWhenNegativeAmount () {

        double amount = -200.00;
        double expectedBalance = 0.00;
        Account account = AccountFactory.createAccountWithBalance(expectedBalance);
        account.deposit(amount);
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void fullWithdrawShouldChangeBalanceToZeroAndReturnFullBalance () {

        double amount = 200.00;
        double expectedBalance = 0.00;
        Account account = AccountFactory.createAccountWithBalance(amount);

        double actualBalance = account.fullWithdraw();

        Assertions.assertEquals(expectedBalance, account.getBalance());
        Assertions.assertEquals(amount, actualBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientAmount () {

        Account account = AccountFactory.createAccountWithBalance(800.00);
        account.withdraw(500.00);
        Assertions.assertEquals(300.00, account.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = AccountFactory.createAccountWithBalance(800.00);
            account.withdraw(900.00);
        });
    }
}
