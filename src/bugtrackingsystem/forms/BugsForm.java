package bugtrackingsystem.forms;

import bugtrackingsystem.Frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.*;

public abstract class BugsForm extends Frame {

    protected JPanel panel;
    protected JLabel title,
            name,
            type,
            level,
            priority,
            project,
            date,
            status,
            background;
    protected JTextField nameField,
            typeField,
            levelField,
            priorityField,
            projectField,
            dateField,
            statusField;
    protected ImageIcon img;
    protected JButton submit,
            back;
    protected int test_id;
    protected double time;
    protected DecimalFormat range;
    protected Color myBlue;

    public BugsForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();

        this.img = new ImageIcon("bugs.jpg");
        this.background = new JLabel();
        this.myBlue = new Color(0x1f4d7f);

        this.title = new JLabel();

        this.name = new JLabel("Bug Name: ");
        this.type = new JLabel("Bug Type: ");
        this.level = new JLabel("Bug Level: ");
        this.priority = new JLabel("Bug Priority: ");
        this.project = new JLabel("Project Name: ");
        this.date = new JLabel("Date: ");
        this.status = new JLabel("Bug Status: ");

        this.nameField = new JTextField();
        this.typeField = new JTextField();
        this.levelField = new JTextField();
        this.priorityField = new JTextField();
        this.projectField = new JTextField();
        this.dateField = new JTextField();
        this.statusField = new JTextField();

        this.submit = new JButton();
        this.back = new JButton("Back");
        back.setIcon(backIcon);

        range = new DecimalFormat("#.00");

        this.add(panel);
    }

    @Override
    public void properties() {
        this.panel.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));
        this.panel.setLayout(null);

        this.background.setIcon(img);
        this.panel.add(title);
        this.panel.add(name);
        this.panel.add(type);
        this.panel.add(level);
        this.panel.add(priority);
        this.panel.add(project);
        this.panel.add(date);
        this.panel.add(status);
        this.panel.add(nameField);
        this.panel.add(typeField);
        this.panel.add(levelField);
        this.panel.add(priorityField);
        this.panel.add(projectField);
        this.panel.add(dateField);
        this.panel.add(statusField);
        this.panel.add(submit);
        this.panel.add(back);
        this.panel.add(background);
    }

    @Override
    public void setBounds() {
        int xLabels = 150,
                xFields = 300,
                yLabels = 250,
                yFields = 250;
        final int WIDTHLABELS = 150,
                WIDTHFIELDS = 800,
                MyHEIGHT = 40;

        background.setBounds(0, 0, this.MYWIDTH, this.MYHEIGHT);

        title.setBounds(465, 100, 1000, 70);

        this.name.setBounds(xLabels, yLabels, WIDTHLABELS, MyHEIGHT);
        this.type.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.level.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.priority.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.project.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.date.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.status.setBounds(xLabels, yLabels + 60, WIDTHLABELS, MyHEIGHT);

        this.nameField.setBounds(xFields, yFields, WIDTHFIELDS, MyHEIGHT);
        this.typeField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.levelField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.priorityField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.projectField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.dateField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.statusField.setBounds(xFields, yFields + 60, WIDTHFIELDS, MyHEIGHT);

        this.submit.setBounds(870, 800, 230, 70);

        this.back.setBounds(70, 950, 150, 50);
    }

    @Override
    public void setFonts() {
        this.title.setFont(new Font("Tahoma", Font.BOLD, 50));

        this.name.setFont(this.font_20);
        this.type.setFont(this.font_20);
        this.level.setFont(this.font_20);
        this.priority.setFont(this.font_20);
        this.project.setFont(this.font_20);
        this.date.setFont(this.font_20);
        this.status.setFont(this.font_20);

        this.nameField.setFont(this.font_20);
        this.typeField.setFont(this.font_20);
        this.levelField.setFont(this.font_20);
        this.priorityField.setFont(this.font_20);
        this.projectField.setFont(this.font_20);
        this.dateField.setFont(this.font_20);
        this.statusField.setFont(this.font_20);

        this.submit.setFont(this.font_24);

        this.back.setFont(new Font("Tahoma", Font.PLAIN, 17));
    }

    @Override
    public void setColors() {
        this.title.setForeground(green);

        this.name.setForeground(Color.white);
        this.type.setForeground(Color.white);
        this.level.setForeground(Color.white);
        this.priority.setForeground(Color.white);
        this.project.setForeground(Color.white);
        this.date.setForeground(Color.white);
        this.status.setForeground(Color.white);

        this.nameField.setBackground(myBlue);
        this.typeField.setBackground(myBlue);
        this.levelField.setBackground(myBlue);
        this.priorityField.setBackground(myBlue);
        this.projectField.setBackground(myBlue);
        this.dateField.setBackground(myBlue);
        this.statusField.setBackground(myBlue);

        this.nameField.setForeground(Color.white);
        this.typeField.setForeground(Color.white);
        this.levelField.setForeground(Color.white);
        this.priorityField.setForeground(Color.white);
        this.projectField.setForeground(Color.white);
        this.dateField.setForeground(Color.white);
        this.statusField.setForeground(Color.white);

        this.nameField.setCaretColor(Color.white);
        this.typeField.setCaretColor(Color.white);
        this.levelField.setCaretColor(Color.white);
        this.priorityField.setCaretColor(Color.white);
        this.projectField.setCaretColor(Color.white);
        this.dateField.setCaretColor(Color.white);
        this.statusField.setCaretColor(Color.white);

        this.submit.setForeground(new Color(0x123456));
        this.submit.setBackground(new Color(0x45e4c4));
    }

    @Override
    public void setOtherProperties() {
        this.title.setVerticalAlignment(JLabel.CENTER);
        this.title.setHorizontalAlignment(JLabel.CENTER);

        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.back.setVerticalTextPosition(JButton.CENTER);
        this.back.setHorizontalTextPosition(JButton.RIGHT);
        this.back.setIconTextGap(10);

        this.submit.setFocusable(false);
        this.back.setFocusable(false);
        
        this.back.setIcon(this.backIcon);
        this.back.setVerticalTextPosition(JButton.CENTER);
        this.back.setHorizontalTextPosition(JButton.RIGHT);
        this.back.setIconTextGap(15);
    }

    @Override
    public void confirm(ActionEvent eve) {
        //  Depends on subclasses
    }

}
