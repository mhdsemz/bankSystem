package models;

import models.enums.AccountType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cartNumber;
    private String accountNumber;
    private Date openingDate;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private double balanceAccount;
    @Column(length = 4)
    private String ccv2;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Transaction> transactions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(double balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public String getCcv2() {
        return ccv2;
    }

    public void setCcv2(String ccv2) {
        this.ccv2 = ccv2;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cartNumber='" + cartNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", openingDate=" + openingDate +
                ", accountType=" + accountType +
                ", balanceAccount=" + balanceAccount +
                ", ccv2='" + ccv2 + '\'' +
                ", user=" + user +
                ", transactions=" + transactions +
                '}';
    }

    public double withdrawnTransaction(String cartNumber, double amount) {
        if (getBalanceAccount() >= amount) {
            System.out.println(getUser().getFamilyName() + " withdrawn "
                    + amount);
            balanceAccount = balanceAccount - amount;
            System.out.println("Balance after withdrawal: "
                    + balanceAccount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(
                    "sorry!! you can not withdrawn ");
        }
        return balanceAccount;
    }

    public Double depositTransaction(String cartNumber, double amount) {
        System.out.println(getUser().getFamilyName() + " deposit "
                + amount);
        balanceAccount = balanceAccount + amount;
        System.out.println("Balance after deposit: "
                + balanceAccount);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balanceAccount;
    }

}
