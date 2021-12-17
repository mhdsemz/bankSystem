package service;

import dao.AccountDao;
import models.Account;

public class AccountService {
    AccountDao accountDao = new AccountDao();

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

}
