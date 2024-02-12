package database;

import java.sql.*;
import javax.swing.JOptionPane;

public final class DatabaseConnection {

    private final String DRIVER_CLASS,
            URL;
    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;
    protected int rs;

    public DatabaseConnection() {
        this.DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
        this.URL = "jdbc:mysql://127.0.0.1:3306/bug_tracking_system";
        this.connection = null;
        this.statement = null;
        this.resultSet = null;
        this.rs = 0;
    }

    private Connection getConnection() {
        try {
            this.connection = DriverManager.getConnection(this.URL, "root", "root123");
            Class.forName(this.DRIVER_CLASS);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR_MESSAGE);
        }
        return this.connection;
    }

    public Statement setStatement() {
        try {
            this.statement = getConnection().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "Connection failed", JOptionPane.ERROR_MESSAGE);
        }

        return this.statement;
    }
}
