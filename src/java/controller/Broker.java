
package controller;

import java.sql.ResultSet;
import m.JDBC;


public class Broker {

    public boolean createAccount(String name) {
        boolean bool = true;
        try {
            ResultSet rset = new JDBC().getData("select * from user_account where username = '" + name + "'");
            if (rset.next()) {
                bool = false;
            }
        } catch (Exception e) {
        }
        return bool;
    }

    public boolean buy(String name, int stock, int qty, double price) {
        double total = qty * price;
        boolean bool = true;
        try {
            ResultSet rset = new JDBC().getData("select * from bank where name = '" + name + "' and amount >= '" + total + "'");
            if (rset.next()) {
                new JDBC().putData("insert into transaction(name,type,price,qty,stock) value('" + name + "','" + 1 + "','" + price + "','" + qty + "','" + stock + "')");
                Bank bank = new Bank();
                bank.withdraw(name, total);
            } else {
                bool = false;
            }
        } catch (Exception e) {
        }
        return bool;
    }

    public void sell(String name, int stock, int qty, double price) {
        double total = qty * price;
        try {
            new JDBC().putData("insert into transaction(name,type,price,qty,stock) value('" + name + "','" + 2 + "','" + price + "','" + qty + "','" + stock + "')");
            ResultSet rset = new JDBC().getData("select * from transaction where id = '" + stock + "'");
            if (rset.next()) {
                new JDBC().putData("update transaction set qty='" + (rset.getInt(5) - qty) + "' where id = '"+stock+"'");
            }
            Bank bank = new Bank();
            bank.diposit(name, total);
        } catch (Exception e) {
        }
    }
}
