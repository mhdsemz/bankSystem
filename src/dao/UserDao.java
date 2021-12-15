package dao;

import models.Account;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao extends BaseDao {

    public int save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int idOfUser = (int) session.save(user);
        transaction.commit();
        session.close();
        return idOfUser;
    }

    public void update(User user) {
        Session session = BaseDao.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public User findUserByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("from User e where e.name=:name", User.class);
        query.setParameter("name", name);
        return query.uniqueResult();
    }
    public User findUserByFamilyName(String familyName){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query=session.createQuery("from User e where e.familyName=:familyName",User.class);
        query.setParameter("familyName",familyName);
        return query.getSingleResult();
    }
    public User findByNationalCode(String nationalCode){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query=session.createQuery("from User e where e.nationalCode=:nationalCode",User.class);
        query.setParameter("nationalCode",nationalCode);
        return query.uniqueResult();
    }

}
