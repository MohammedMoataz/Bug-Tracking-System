package bugtrackingsystem.tables;

import bugtrackingsystem.forms.*;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bugs extends Show implements ActionListener {

    private final ImageIcon bugIcon,
            updateIcon;
    protected JButton button;
    protected String text;

    public Bugs(int user_id) {
        this.bugIcon = new ImageIcon("bugIcon.png");
        this.updateIcon = new ImageIcon("update.png");
        this.button = new JButton();
        this.id = user_id;

        this.model.addColumn("ID");
        this.model.addColumn("Name");
        this.model.addColumn("Type");
        this.model.addColumn("Level");
        this.model.addColumn("Priority");
        this.model.addColumn("Project");
        this.model.addColumn("Date");
        this.model.addColumn("Status");

        this.text = this.addBugs(this.id);

        super.showing();
    }

    @Override
    protected void setButtons() {
        this.button.setText(this.text);
        this.button.setBounds(800, 80, 300, 100);

        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.button.setVerticalTextPosition(JButton.CENTER);
        this.button.setHorizontalTextPosition(JButton.RIGHT);
        this.button.setIconTextGap(15);

        if (this.text != null) {
            this.buttonsPanel.add(button);

            if (this.text.equals("Define Bug")) {
                this.button.setIcon(bugIcon);
            } else {
                this.button.setIcon(updateIcon);
            }
        }
    }

    @Override
    protected void setProperties() {
        this.button.setBackground(this.green);
        this.button.setForeground(this.darkBlue);
        this.button.setFont(this.font);
        this.button.setFocusable(false);
        this.back.setFocusable(false);

        this.button.addActionListener(this);
        this.back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (button.getText().equals("Define Bug")) {
                DefineBug define = new DefineBug(this.id);
                this.dispose();
            } else {
                try {
                    int row = table.getSelectedRow();

                    int bug_id = Integer.parseInt(table.getValueAt(row, 0).toString());

                    UpdateBug update = new UpdateBug(bug_id, this.id);
                    this.dispose();
                } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Select one row first", "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
                }
            }
        }

        if (e.getSource() == back) {
            backTemplate(this.id);
            this.dispose();
        }
    }
}
