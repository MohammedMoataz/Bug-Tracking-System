package bugtrackingsystem.templates;

import bugtrackingsystem.forms.Login;
import bugtrackingsystem.tables.Bugs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Developer extends Template implements ActionListener{

    public Developer(int developer_id) {
        this.user_id = developer_id;
        
        this.bugs.addActionListener(this);
        this.logout.addActionListener(this);

        this.panel.remove(button);
        
        super.showing();
    }
    
    @Override
    public void setBounds() {
        this.title.setBounds(465, 80, 1000, 100);

        this.bugs.setBounds(800, 800, 300, 100);
        this.logout.setBounds(70, 950, 150, 50);        
    }
    
    @Override
    public void confirm(ActionEvent eve) {
        if(eve.getSource() == bugs) {
            Bugs show = new Bugs(this.user_id);
            this.dispose();
        }
        
        if(eve.getSource() == logout) {
            Login login = new Login(); 
            this.dispose();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.confirm(e);
    }
}
