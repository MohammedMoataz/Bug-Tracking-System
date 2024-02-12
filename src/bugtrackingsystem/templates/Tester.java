package bugtrackingsystem.templates;

import bugtrackingsystem.tables.Bugs;
import bugtrackingsystem.forms.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tester extends Template implements ActionListener {

    public Tester(int tester_id) {
        this.user_id = tester_id;

        this.button.setText("Define bug");

        this.bugs.addActionListener(this);
        this.button.addActionListener(this);
        this.logout.addActionListener(this);

        super.showing();
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == button) {
            DefineBug defineBug = new DefineBug(this.user_id);
            this.dispose();
        }

        if (eve.getSource() == bugs) {
            Bugs bugs = new Bugs(this.user_id);
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
