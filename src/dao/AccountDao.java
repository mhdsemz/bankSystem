package dao;

import models.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDao extends BaseDao {

    public int saveAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int idOfAccount = (int) session.save(account);
        transaction.commit();
        session.close();
        return idOfAccount;
    }

}
