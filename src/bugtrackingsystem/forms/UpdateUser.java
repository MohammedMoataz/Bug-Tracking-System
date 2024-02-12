package bugtrackingsystem.forms;

import bugtrackingsystem.tables.Users;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UpdateUser extends UsersForm implements ActionListener {

    private final ImageIcon updateIcon,
            updatedIcon;
    private int update_id;

    public UpdateUser(int user_id, int admin_id) {
        this.update_id = user_id;
        this.user_id = admin_id;

        this.title.setText("Update User");

        String sql = "select * from users where id = " + this.update_id + "";
        try {
            ResultSet result = this.statement.executeQuery(sql);

            while (result.next()) {
                this.idField.setText(result.getString("id"));
                this.nameField.setText(result.getString("name"));
                this.passwordField.setText(result.getString("password"));
                this.confirmField.setText(result.getString("password"));
                this.roleField.setSelectedItem(result.getString("role"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }

        this.submit.setText("Update");
        this.panel.add(reset);

        this.updateIcon = new ImageIcon("update.png");
        this.updatedIcon = new ImageIcon("updated.png");

        this.submit.setIcon(updateIcon);
        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.submit.setVerticalTextPosition(JButton.CENTER);
        this.submit.setHorizontalTextPosition(JButton.RIGHT);
        this.submit.setIconTextGap(15);

        this.submit.addActionListener(this);
        this.reset.addActionListener(this);
        this.back.addActionListener(this);

        super.showing();
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == submit) {
            try {
                int code = Integer.parseInt(this.idField.getText().trim());
                String username = this.nameField.getText().trim();
                String pass = this.passwordField.getText().trim();
                String confirm = this.confirmField.getText().trim();
                String department = this.roleField.getSelectedItem().toString();

                if (confirm.equals(pass)) {
                    String sql = "update users set id = " + code + ", "
                            + "name = '" + username + "', "
                            + "password = '" + pass + "',"
                            + " role = '" + department + "' "
                            + "where id = " + this.update_id + "";

                    int rs = this.statement.executeUpdate(sql);

                    if (rs == 1) {
                        JOptionPane.showMessageDialog(null, "User has been Updated successfully", "Successful Updating", JOptionPane.INFORMATION_MESSAGE, updatedIcon);
                        Users users = new Users(this.user_id);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Check password again", "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
                }
            } catch (SQLException | java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "This ID is already exist", "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
            }
        }

        if (eve.getSource() == reset) {
            this.idField.setText("");
            this.nameField.setText("");
            this.passwordField.setText("");
            this.confirmField.setText("");
            this.roleField.setSelectedIndex(0);
        }

        if (eve.getSource() == back) {
            Users users = new Users(this.user_id);
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirm(e);
    }
}
