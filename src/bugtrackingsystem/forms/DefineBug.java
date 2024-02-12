package bugtrackingsystem.forms;

import bugtrackingsystem.tables.Bugs;
import database.DatabaseConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DefineBug extends BugsForm implements ActionListener {

    private final ImageIcon bugIcon,
            definedIcon;
    private final JFileChooser fileChooser;
    private final JButton chooseFile;
    private final JLabel screenshot,
            path;
    private static int bug_id;

    public DefineBug(int test_id) {
        this.test_id = test_id;
        this.title.setText("Define Bugs");

        this.fileChooser = new JFileChooser();

        this.screenshot = new JLabel("Screenshot: ");
        this.chooseFile = new JButton("Choose file");
        this.path = new JLabel();

        this.definedIcon = new ImageIcon("defined.png");
        this.bugIcon = new ImageIcon("bugIcon.png");
        this.submit.setText("Define");

        myProperties();

        this.dateField.setText(LocalDate.now() + "");
        this.time = Math.round(1 + Math.random() * 6);

        setID();

        this.panel.add(this.screenshot);
        this.panel.add(this.chooseFile);
        this.panel.add(this.path);

        this.chooseFile.addActionListener(this);
        this.submit.addActionListener(this);
        this.back.addActionListener(this);

        super.showing();
    }

    private static void setID() {
        try {
            String sql = "select * from bugs order by id DESC";
            Statement state = new DatabaseConnection().setStatement();
            ResultSet result = state.executeQuery(sql);

            while (result.next()) {
                DefineBug.bug_id = Integer.parseInt(result.getString("id"));
                break;
            }
            bug_id++;
        } catch (SQLException ex) {
            Logger.getLogger(DefineBug.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void myProperties() {
        this.screenshot.setBounds(150, 670, 150, 40);
        this.chooseFile.setBounds(300, 680, 150, 23);
        this.path.setBounds(465, 688, 600, 15);

        this.screenshot.setFont(this.font_20);
        this.chooseFile.setFont(new Font("Arial", Font.PLAIN, 14));
        this.path.setFont(new Font("Arial", Font.PLAIN, 11));

        this.screenshot.setForeground(Color.white);
        this.path.setForeground(Color.white);

        this.submit.setIcon(bugIcon);
        this.chooseFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.submit.setVerticalTextPosition(JButton.CENTER);
        this.submit.setHorizontalTextPosition(JButton.RIGHT);
        this.submit.setIconTextGap(15);
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == this.chooseFile) {
            this.fileChooser.setCurrentDirectory(new File("."));
            int response = this.fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(this.fileChooser.getSelectedFile().getAbsolutePath());
                this.path.setText(file + "");
            }
        }

        if (eve.getSource() == this.submit) {
            if (this.nameField.getText().equals("") || this.typeField.getText().equals("")
                    || this.levelField.getText().equals("") || this.priorityField.getText().equals("")
                    || this.projectField.getText().equals("") || this.dateField.getText().equals("")
                    || this.statusField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Make sure that the form is full!", "Invalid inputs", JOptionPane.ERROR_MESSAGE, errorIcon);
            } else {
                String dev_id = JOptionPane.showInputDialog("Enter the developer ID you would to assign this bug to!");
                try {
                    String bug_name = this.nameField.getText().trim();
                    String bug_type = this.typeField.getText().trim();
                    int bug_level = Integer.parseInt(this.levelField.getText().trim());
                    int bug_priority = Integer.parseInt(this.priorityField.getText().trim());
                    String bug_project = this.projectField.getText().trim();
                    LocalDate bug_date = LocalDate.parse(this.dateField.getText().trim());
                    String bug_status = this.statusField.getText().trim();

                    String sql = "insert into bugs"
                            + " values('" + bug_id + "', '" + bug_name + "', '" + bug_type + "', '" + bug_level + "', '" + bug_priority + "', "
                            + " '" + bug_project + "', '" + bug_date + "', '" + this.path.getText() + "', '" + bug_status + "') ";

                    int rs = this.statement.executeUpdate(sql);

                    if (rs == 1) {
                        sql = " insert into performance"
                                + " values('" + bug_id + "', '" + this.test_id + "', '" + this.range.format(this.time) + "', '" + dev_id + "', '0')";

                        rs = this.statement.executeUpdate(sql);

                        if (rs == 1) {
                            JOptionPane.showMessageDialog(null, "Bug has been inserted successfully", "Successful inserted", JOptionPane.INFORMATION_MESSAGE, definedIcon);
                            Bugs bugs = new Bugs(this.test_id);
                            this.dispose();
                        }
                    }
                } catch (java.lang.NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Check your level and priority", "Invalid input", JOptionPane.ERROR_MESSAGE, errorIcon);
                } catch (java.time.format.DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Date have been inserted as (yyyy-mm-dd)", "Invalid input", JOptionPane.ERROR_MESSAGE, errorIcon);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No developer has ID you inserted!", "Invalid input", JOptionPane.ERROR_MESSAGE, errorIcon);
                    String sql = "delete from bugs where id = '" + bug_id + "' ";
                    try {
                        this.statement.executeUpdate(sql);
                    } catch (SQLException ex1) {
                        Logger.getLogger(DefineBug.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }

        if (eve.getSource() == back) {
            Bugs bugs = new Bugs(this.test_id);
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirm(e);
    }
}
