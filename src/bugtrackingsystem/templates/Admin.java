package bugtrackingsystem.templates;

import bugtrackingsystem.tables.Users;
import bugtrackingsystem.forms.AddUser;
import bugtrackingsystem.forms.Login;
import bugtrackingsystem.tables.Bugs;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Admin extends Template implements ActionListener {

    private final JButton add;

    public Admin(int admin_id) {
        this.user_id = admin_id;

        this.add = new JButton("Add user");
        this.button.setText("View users");

        this.add.setFont(this.font_24);
        this.add.setForeground(darkBlue);
        this.add.setFocusable(false);
        this.add.setBackground(green);
        this.add.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.panel.add(add);

        this.bugs.addActionListener(this);
        this.button.addActionListener(this);
        this.add.addActionListener(this);

        this.logout.addActionListener(this);

        super.showing();
    }

    @Override
    public void setBounds() {
        this.title.setBounds(465, 80, 1000, 100);

        this.bugs.setBounds(300, 800, 300, 100);
        this.add.setBounds(810, 800, 300, 100);
        this.button.setBounds(1320, 800, 300, 100);

        this.logout.setBounds(70, 950, 150, 50);

    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == this.bugs) {
            Bugs show = new Bugs(this.user_id);
            this.dispose();
        }
        if (eve.getSource() == this.button) {
            Users show = new Users(this.user_id);
            this.dispose();
        }

        if (eve.getSource() == this.add) {
            AddUser addUser = new AddUser(this.user_id);
            this.dispose();
        }

        if (eve.getSource() == this.logout) {
            Login login = new Login();
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.confirm(e);
    }
}
