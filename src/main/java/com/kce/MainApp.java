package com.kce;

import com.kce.dao.BankDAO;

public class MainApp {

    public static void main(String[] args) {

        BankDAO dao = new BankDAO();

        long acc1 = 1234567892L;
        long acc2 = 1234567893L;

        System.out.println("Checking Account 1...");
        double balance1 = dao.findBalance(acc1);
        System.out.println("Balance: " + balance1);

        System.out.println("Checking Account 2...");
        double balance2 = dao.findBalance(acc2);
        System.out.println("Balance: " + balance2);
    }
}