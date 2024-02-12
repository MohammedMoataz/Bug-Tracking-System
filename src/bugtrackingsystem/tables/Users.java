package bugtrackingsystem.tables;

import bugtrackingsystem.forms.*;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Users extends Show implements ActionListener {

    private final ImageIcon addUserIcon,
            updateIcon,
            deleteIcon;
    private final JButton add,
            update,
            delete;

    public Users(int admin_id) {
        this.id = admin_id;

        this.addUserIcon = new ImageIcon("addUser.png");
        this.updateIcon = new ImageIcon("update.png");
        this.deleteIcon = new ImageIcon("delete.png");
        
        this.add = new JButton("Add user");
        this.update = new JButton("Update user");
        this.delete = new JButton("Delete user");

        this.model.addColumn("ID");
        this.model.addColumn("User name");
        this.model.addColumn("Role");

        String sql = "select * from users";
        this.addUsers(sql);

        super.showing();
    }

    @Override
    protected void setButtons() {
        this.add.setBounds(350, 100, 300, 80);
        this.update.setBounds(815, 100, 300, 80);
        this.delete.setBounds(1300, 100, 300, 80);

        this.buttonsPanel.add(this.add);
        this.buttonsPanel.add(this.update);
        this.buttonsPanel.add(this.delete);
    }

    @Override
    protected void setProperties() {
        this.add.setBackground(this.green);
        this.add.setForeground(this.darkBlue);
        this.add.setFont(this.font);
        this.add.setFocusable(false);
        this.add.addActionListener(this);
        this.add.setIcon(addUserIcon);            
        this.add.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add.setVerticalTextPosition(JButton.CENTER);
        this.add.setHorizontalTextPosition(JButton.RIGHT);
        this.add.setIconTextGap(15);
        
        this.update.setBackground(this.green);
        this.update.setForeground(this.darkBlue);
        this.update.setFont(this.font);
        this.update.setFocusable(false);
        this.update.addActionListener(this);
        this.update.setIcon(updateIcon);            
        this.update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.update.setVerticalTextPosition(JButton.CENTER);
        this.update.setHorizontalTextPosition(JButton.RIGHT);
        this.update.setIconTextGap(15);

        this.delete.setBackground(this.green);
        this.delete.setForeground(this.darkBlue);
        this.delete.setFont(this.font);
        this.delete.setFocusable(false);
        this.delete.addActionListener(this);
        this.delete.setIcon(deleteIcon);            
        this.delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.delete.setVerticalTextPosition(JButton.CENTER);
        this.delete.setHorizontalTextPosition(JButton.RIGHT);
        this.delete.setIconTextGap(15);

        this.back.setFocusable(false);
        this.back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.add) {
            AddUser addUser = new AddUser(this.id);
            this.dispose();
        }

        if (e.getSource() == this.update) {
            try {
                int row = table.getSelectedRow();

                int id = Integer.parseInt(table.getValueAt(row, 0).toString());

                UpdateUser updateUser = new UpdateUser(id, this.id);
                this.dispose();
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Select a row first", "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
            }
        }

        if (e.getSource() == this.delete) {
            try {
                int row = table.getSelectedRow();

                int id = Integer.parseInt(table.getValueAt(row, 0).toString());

                DeleteUser deletedUser = new DeleteUser(id, this.id);
                this.dispose();
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Select a row first", "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
            }
        }

        if (e.getSource() == back) {
            backTemplate(this.id);
            this.dispose();
        }
    }

}
