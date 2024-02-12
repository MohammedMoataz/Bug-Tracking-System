package bugtrackingsystem.templates;

import bugtrackingsystem.forms.Login;
import bugtrackingsystem.tables.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends Template implements ActionListener {

    public Manager(int manager_id) {
        this.user_id = manager_id;

        this.button.setText("View performances");

        this.bugs.addActionListener(this);
        this.button.addActionListener(this);
        this.logout.addActionListener(this);

        super.showing();
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == button) {
            Performance show = new Performance(this.user_id);
            this.dispose();
        }

        if (eve.getSource() == bugs) {
            Bugs show = new Bugs(this.user_id);
            this.dispose();
        }

        if (eve.getSource() == logout) {
            Login login = new Login();
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.confirm(e);
    }
}
