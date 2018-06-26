 
package controller;

import java.sql.ResultSet;
import m.JDBC;


public class Bank {

    public boolean createAccount(String name) {
        boolean bool = true;
        try {
            ResultSet rset = new JDBC().getData("select * from bank where name = '" + name + "'");
            if (rset.next()) {
                bool = false;
            }
        } catch (Exception e) {
        }
        return bool;
    }

    public void withdraw(String name, double amount) {
        String type = "Withdraw";
        try {
            ResultSet rset = new JDBC().getData("select * from bank where name = '" + name + "'");
            if (rset.next()) {
                new JDBC().putData("update bank set amount='" + (rset.getDouble(2)-amount) + "' where name = '" + name + "'");
                new JDBC().putData("insert into bank_transaction(name,type,amount) values('" + name + "','" + type + "','" + amount + "')");
            }
        } catch (Exception e) {
        }
    }
    public void diposit(String name, double amount) {
        String type = "Diposit";
        try {
            ResultSet rset = new JDBC().getData("select * from bank where name = '" + name + "'");
            if (rset.next()) {
                new JDBC().putData("update bank set amount='" + (rset.getDouble(2)+amount) + "' where name = '" + name + "'");
                new JDBC().putData("insert into bank_transaction(name,type,amount) values('" + name + "','" + type + "','" + amount + "')");
            }
        } catch (Exception e) {
        }
    }
}
