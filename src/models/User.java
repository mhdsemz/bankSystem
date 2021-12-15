package models;

import models.enums.UserType;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String familyName;
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private Date createDate;
    @UpdateTimestamp
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accountList=new ArrayList<>();



}
