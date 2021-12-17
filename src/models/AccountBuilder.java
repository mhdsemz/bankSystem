package models;

import java.util.Date;

public class AccountBuilder {
    private final Account account = new Account();
    public static AccountBuilder getBuilder() {
        return new AccountBuilder();
    }

    public Account build() {
        return account;
    }

    public AccountBuilder withAccountNumber(String accNo) {
        account.setAccountNumber(accNo);
        return this;
    }

    public AccountBuilder withCartNumber(String cartNo) {
        account.setCartNumber(cartNo);
        return this;
    }

    public AccountBuilder withCvv2(String ccv2) {
        account.setCcv2(ccv2);
        return this;
    }

    public AccountBuilder withOpeningDate(Date date) {
        account.setOpeningDate(date);
        return this;
    }

    public AccountBuilder withUser(double balance) {
        account.setBalanceAccount(balance);
        return this;
    }

    public AccountBuilder withExpirationDate(Date date) {
        account.setExpirationDate(date);
        return this;
    }

    public AccountBuilder withUser(User user) {
        account.setUser(user);
        return this;
    }
}
