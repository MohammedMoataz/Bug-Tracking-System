package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseClose {

    private final DatabaseConnection database;
    public DatabaseClose() {
        database = new DatabaseConnection();
    }
    
    public void close(Connection connection) {
        if (database.connection != null) {
            try {
                database.connection.close();
                database.connection = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void close(Statement statemetn) {
        if (database.statement != null) {
            try {
                database.statement.close();
                database.statement = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void close(ResultSet resultSet) {
        if (database.resultSet != null) {
            try {
                database.resultSet.close();
                database.resultSet = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR);
            }
        }
    }
    
}
