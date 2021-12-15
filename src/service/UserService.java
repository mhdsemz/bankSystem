package service;

import dao.UserDao;
import models.User;

public class UserService {
    UserDao userDao = new UserDao();

    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public User findUserByFamilyName(String familyName) {
        return userDao.findUserByFamilyName(familyName);
    }

    public User findUserByNationalCode(String nationalCode) {
        return userDao.findByNationalCode(nationalCode);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }
    public void updateUser(User user){
        userDao.update(user);
    }
}
