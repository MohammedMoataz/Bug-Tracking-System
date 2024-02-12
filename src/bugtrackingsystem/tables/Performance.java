package bugtrackingsystem.tables;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Performance extends Show implements ActionListener{

    public Performance(int manager_id) {
        this.id = manager_id;
        
        this.model.addColumn("Bug ID");
        this.model.addColumn("Tester ID");
        this.model.addColumn("Tester performance (hours / bug)");
        this.model.addColumn("Developer ID");
        this.model.addColumn("Developer performance (hours / bug)");
        
        String sql = "select * from performance";
        this.addPerformances(sql);

        this.back.addActionListener(this);
        super.showing();
    }

    @Override
    protected void setButtons() {
    }

    @Override
    protected void setProperties() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            backTemplate(this.id);  
            this.dispose();
        }
    }
}
