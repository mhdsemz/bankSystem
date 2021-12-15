package models;

import models.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

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
    private Date expirationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


}
