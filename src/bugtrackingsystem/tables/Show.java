package bugtrackingsystem.tables;

import bugtrackingsystem.templates.*;
import database.DatabaseConnection;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public abstract class Show extends JFrame {

    protected JPanel buttonsPanel;
    protected JScrollPane container;
    protected DefaultTableModel model;
    protected JTable table;
    protected ImageIcon icon,
            errorIcon,
            backIcon;
    protected JButton back;
    protected Statement statement;
    protected final Color green,
            blue,
            darkBlue;
    protected final Font font;
    protected int id;

    public Show() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(-7, -1);
        this.setTitle("Bug Tracking System");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1935, 1100);

        this.backIcon = new ImageIcon("back.png");
        this.errorIcon = new ImageIcon("error.png");
        this.icon = new ImageIcon("icon.png");
        this.setIconImage(this.icon.getImage());

        this.green = new Color(0x46e5c5);
        this.blue = new Color(0x2b42c2);
        this.darkBlue = new Color(0x123456);

        this.font = new Font("Arial", Font.PLAIN, 23);

        this.model = new DefaultTableModel();
        this.table = new JTable(this.model);

        this.container = new JScrollPane();
        this.buttonsPanel = new JPanel();

        this.statement = new DatabaseConnection().setStatement();

        this.back = new JButton("Back");
    }

    public void showing() {
        properties();
        setButtons();
        setProperties();

        this.container.setViewportView(this.table);
        this.buttonsPanel.add(this.back);

        this.add(this.container);
        this.add(this.buttonsPanel);

        this.setVisible(true);
    }

    public void properties() {
        this.container.setBounds(0, 0, 1920, 800);
        this.buttonsPanel.setBounds(0, 800, 1935, 300);
        this.buttonsPanel.setBackground(new Color(0x5595d5));

        this.buttonsPanel.setLayout(null);

        this.model.setRowCount(50);

        this.table.getTableHeader().setReorderingAllowed(false);

        this.table.setRowHeight(30);
        this.table.setAutoscrolls(true);
        this.table.setFocusable(false);
        this.table.setFillsViewportHeight(false);
        this.table.setFont(new Font("Arial", Font.PLAIN, 16));
        this.table.setFocusable(false);
        this.table.getTableHeader().setDefaultRenderer(new simpleHeaderRenderer());

        this.table.setGridColor(this.darkBlue);
        this.table.setBackground(Color.white);
        this.table.setForeground(Color.black);
        this.table.setSelectionBackground(green);
        this.table.setSelectionForeground(Color.black);
        this.table.setDragEnabled(false);
        
        this.back.setIcon(this.backIcon);
        this.back.setBounds(70, 150, 150, 50);
        this.back.setFont(new Font("Arial", Font.PLAIN, 17));
        this.back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.back.setFocusable(false);
        this.back.setVerticalTextPosition(JButton.CENTER);
        this.back.setHorizontalTextPosition(JButton.RIGHT);
        this.back.setIconTextGap(15);
    }

    //  Add rows in table from database...
    protected void addUsers(String sql) {
        try {
            ResultSet rs = this.statement.executeQuery(sql);

            while (rs.next()) {
                this.model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("role")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }
    }

    protected String addBugs(int user_id) {
        String sql = "select * from users where id = " + user_id + "";
        String buttonText = null;

        try {
            ResultSet rs = this.statement.executeQuery(sql);

            while (rs.next()) {
                switch (rs.getString("role")) {
                    case "Admin", "Project manager" -> {
                        sql = "select * from bugs";
                        buttonText = null;
                    }
                    case "Tester" -> {
                        sql = "select * from bugs";
                        buttonText = "Define Bug";
                    }
                    case "Developer" -> {
                        sql = "select * from bugs join performance on id = bug_id where dev_id = " + rs.getString("id") + "";
                        buttonText = "Update Bug";
                    }
                }

                rs = this.statement.executeQuery(sql);
                while (rs.next()) {
                    this.model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("type"), rs.getString("level"),
                        rs.getString("priority"), rs.getString("project"), rs.getString("date"), rs.getString("status")});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }

        return buttonText;
    }

    protected void addPerformances(String sql) {
        try {
            ResultSet rs = this.statement.executeQuery(sql);

            while (rs.next()) {
                this.model.addRow(new Object[]{rs.getString("bug_id"), rs.getString("test_id"),
                    rs.getString("test_perf"), rs.getString("dev_id"), rs.getString("dev_perf")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }
    }

    protected void backTemplate(int user_id) {
        String sql = "select * from users where id = " + user_id + "";

        try {
            ResultSet rs = this.statement.executeQuery(sql);

            while (rs.next()) {
                switch (rs.getString("role")) {
                                case "Admin" -> {
                                    Admin admin = new Admin(user_id);
                                    this.dispose();
                                }

                                case "Project manager" -> {
                                    Manager manager = new Manager(user_id);
                                    this.dispose();
                                }

                                case "Developer" -> {
                                    Developer developer = new Developer(user_id);
                                    this.dispose();
                                }

                                case "Tester" -> {
                                    Tester tester = new Tester(user_id);
                                    this.dispose();
                                }
                            }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }
    }

    //  Set properties of button and set more button if it needed...
    protected abstract void setButtons();

    protected abstract void setProperties();

    public class simpleHeaderRenderer extends JLabel implements TableCellRenderer {

        public simpleHeaderRenderer() {
            this.setFont(new Font("Consola", Font.PLAIN, 18));
            this.setBackground(new Color(0x5ebcff));
            this.setOpaque(true);
            this.setBorder(BorderFactory.createLineBorder(Color.black));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            this.setText(value.toString());
            return this;
        }

    }

}
