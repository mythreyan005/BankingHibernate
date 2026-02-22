package com.kce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.kce.entity.Account;
import com.kce.util.HibernateUtil;

public class BankDAO {

    public boolean validateAccount(long accountNumber) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = session.get(Account.class, accountNumber);
        session.close();

        return account != null;
    }

    public double findBalance(long accountNumber) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = session.get(Account.class, accountNumber);
        session.close();

        if (account != null) {
            return account.getBalance();
        }
        return -1;
    }

    public boolean updateBalance(long accountNumber, double newBalance) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Account account = session.get(Account.class, accountNumber);

        if (account != null) {
            account.setBalance(newBalance);
            session.update(account);
            tx.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }
}