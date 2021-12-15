package models;

import models.enums.TransactionType;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Transaction-type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private double amount;
    @ManyToOne
    private Account account;


}
