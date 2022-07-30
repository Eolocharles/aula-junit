package tests.factory;

import entities.Account;

public class AccountFactory {
    public static Account createEmptyAccount() {
        return new Account(1l, 0.0);
    }

    public static Account createAccountWithBalance(double balance) {
        return new Account(1l, balance);
    }
}
