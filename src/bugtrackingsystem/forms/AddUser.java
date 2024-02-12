package bugtrackingsystem.forms;

import bugtrackingsystem.tables.Users;
import java.awt.Cursor;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddUser extends UsersForm implements ActionListener {

    private final ImageIcon addUserIcon,
            addedIcon;

    public AddUser(int admin_id) {
        this.user_id = admin_id;

        this.addedIcon = new ImageIcon("added.png");
        this.addUserIcon = new ImageIcon("addUser.png");

        this.title.setText("Add User");

        this.submit.setText("Add");

        this.submit.setIcon(addUserIcon);
        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.submit.setVerticalTextPosition(JButton.CENTER);
        this.submit.setHorizontalTextPosition(JButton.RIGHT);
        this.submit.setIconTextGap(15);
      
        this.panel.add(reset);

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
                    String sql = "insert into users values('" + code + "', '" + username + "', '" + pass + "', '" + department + "')";
                    int rs = this.statement.executeUpdate(sql);

                    if (rs == 1) {
                        JOptionPane.showMessageDialog(null, "User has been added successfully", "Successful addition", JOptionPane.INFORMATION_MESSAGE, addedIcon);
                        Users users = new Users(user_id);
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
        this.confirm(e);
    }
}
