package bugtrackingsystem.forms;

import bugtrackingsystem.tables.Users;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class DeleteUser extends UsersForm implements ActionListener {

    private final ImageIcon deleteIcon,
            deletedIcon;
    private int deleted_id;

    public DeleteUser(int user_id, int admin_id) {
        this.deleted_id = user_id;
        this.user_id = admin_id;

        this.title.setText("Delete User");

        String sql = "select * from users where id = " + this.deleted_id + "";
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

        this.deletedIcon = new ImageIcon("deleted.png");
        this.deleteIcon = new ImageIcon("delete.png");
        
        this.submit.setText("Delete");
        this.submit.setIcon(deleteIcon);
        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.submit.setVerticalTextPosition(JButton.CENTER);
        this.submit.setHorizontalTextPosition(JButton.RIGHT);
        this.submit.setIconTextGap(15);

        this.idField.setEditable(false);
        this.nameField.setEditable(false);
        this.passwordField.setEditable(false);
        this.confirmField.setEditable(false);
        this.roleField.setEditable(false);

        this.submit.addActionListener(this);
        this.back.addActionListener(this);

        super.showing();
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == submit) {
            try {
                int answer = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete this user?", "Confirm message", JOptionPane.YES_NO_CANCEL_OPTION);

                if (answer == 0) {
                    String sql = "delete from users where id = " + this.deleted_id + " ";

                    int rs = this.statement.executeUpdate(sql);

                    if (rs == 1) {
                        JOptionPane.showMessageDialog(null, "User has been Deleted successfully", "Successful Deleting", JOptionPane.INFORMATION_MESSAGE, deletedIcon);
                        Users users = new Users(this.user_id);
                        this.dispose();
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
            }
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
