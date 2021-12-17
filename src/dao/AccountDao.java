package dao;

import models.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AccountDao extends BaseDao {
    Account account = new Account();

    public int saveAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int idOfAccount = (int) session.save(account);
        transaction.commit();
        session.close();
        return idOfAccount;
    }

    public static void withdrawn(String cartNumber, int amount) {
        models.Transaction transaction1 = new models.Transaction();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.load(Account.class, cartNumber);
        transaction1.setAccount(account);
        transaction1.setDate(new Date());
        double v = account.withdrawnTransaction(cartNumber, amount);
        transaction1.setAmount(v);
        session.persist(transaction1);
        transaction.commit();
        session.close();
    }
    public static void deposit(String cartNumber, int amount) {
        models.Transaction transaction2= new models.Transaction();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.load(Account.class, cartNumber);
        transaction2.setAccount(account);
        transaction2.setDate(new Date());
        double v = account.depositTransaction(cartNumber, amount);
        transaction2.setAmount(v);
        session.persist(transaction2);
        transaction.commit();
        session.close();
    }
}
