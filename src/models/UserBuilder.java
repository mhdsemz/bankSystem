package models;

import models.enums.UserType;

import java.util.Date;

public class UserBuilder {

private final User user=new User();

    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }

    public User build() {
        return user;
    }

    public UserBuilder withFirstName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder withLastName(String name) {
        user.setFamilyName(name);
        return this;
    }

    public UserBuilder withNationalCode(String NationalCode) {
        user.setNationalCode(NationalCode);
        return this;
    }

    public UserBuilder withCreationDate(Date date) {
        user.setCreateDate(date);
        return this;
    }

    public UserBuilder withType(UserType type) {
        user.setUserType(type);
        return this;
    }


}
