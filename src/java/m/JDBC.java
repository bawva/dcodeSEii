
package m;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class JDBC {

    public void putData(String sql) throws Exception {
        try {
            Connection c = conn.getInstance().getMyConnection();
            PreparedStatement state = c.prepareStatement(sql);
            state.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error no 02", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet getData(String sql) throws Exception {
        Connection c = conn.getInstance().getMyConnection();
        Statement state = c.createStatement();
        ResultSet rset = state.executeQuery(sql);
        return rset;
    }
}
