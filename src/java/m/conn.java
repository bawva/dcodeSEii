
package m;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conn {

    private static conn conn;
    private static Connection c;

    public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        if (c == null) {
//            System.out.println("Database Connection creating first time");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocktrading", "root", "root");
        }
//        System.out.println("Using created Database Connection");
        return c;
    }

    public static conn getInstance() {
        if (conn == null) {
//            System.out.println("DB Connection (class) is null");
            conn = new conn();
        }
//        System.out.println("DB Connection (class) is not null");
        return conn;
    }

}
