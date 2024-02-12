package bugtrackingsystem.forms;

import bugtrackingsystem.tables.Bugs;
import java.awt.Cursor;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateBug extends BugsForm implements ActionListener {

    private final ImageIcon updateIcon,
            updatedIcon;
    private final int bug_id,
            user_id;

    public UpdateBug(int bug_id, int user_id) {
        this.bug_id = bug_id;
        this.user_id = user_id;

        this.title.setText("Update Bugs");

        this.submit.setText("Update");

        this.updatedIcon = new ImageIcon("defined.png");
        this.updateIcon = new ImageIcon("update.png");

        this.submit.setIcon(updateIcon);
        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.submit.setVerticalTextPosition(JButton.CENTER);
        this.submit.setHorizontalTextPosition(JButton.RIGHT);
        this.submit.setIconTextGap(15);

        String sql = "select * from bugs where id = " + this.bug_id + "";
        try {
            ResultSet result = this.statement.executeQuery(sql);

            while (result.next()) {
                this.nameField.setText(result.getString("name"));
                this.typeField.setText(result.getString("type"));
                this.levelField.setText(result.getString("level"));
                this.priorityField.setText(result.getString("priority"));
                this.projectField.setText(result.getString("project"));
                this.dateField.setText(result.getString("date"));
                this.statusField.setText(result.getString("status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }

        this.nameField.setEditable(false);
        this.typeField.setEditable(false);
        this.levelField.setEditable(false);
        this.priorityField.setEditable(false);
        this.projectField.setEditable(false);
        this.dateField.setEditable(false);

        this.time = Math.round(1 + Math.random() * 6);

        this.submit.addActionListener(this);
        this.back.addActionListener(this);

        super.showing();
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == this.submit) {
            try {
                String bug_status = this.statusField.getText().trim();

                String sql = "update bugs set status = '" + bug_status + "' where id = " + this.bug_id + "; ";
                int rs = this.statement.executeUpdate(sql);

                if (rs == 1) {
                    sql = "update performance set dev_perf = " + this.range.format(this.time) + " where bug_id = " + this.bug_id;
                    rs = this.statement.executeUpdate(sql);

                    if (rs == 1) {
                        JOptionPane.showMessageDialog(null, "Bug has been Updated successfully", "Successful Updating", JOptionPane.INFORMATION_MESSAGE, updatedIcon);
                        Bugs bugs = new Bugs(this.user_id);
                        this.dispose();
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
            }
        }

        if (eve.getSource() == back) {
            Bugs bugs = new Bugs(this.user_id);
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirm(e);
    }
}
