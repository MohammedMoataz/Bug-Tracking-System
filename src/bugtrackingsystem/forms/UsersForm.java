package bugtrackingsystem.forms;

import bugtrackingsystem.Frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public abstract class UsersForm extends Frame implements Form {

    protected JPanel panel;
    protected JLabel title,
            id,
            name,
            password,
            confirmPassword,
            role,
            background;
    protected JTextField idField,
            nameField;
    protected JPasswordField passwordField,
            confirmField;
    protected JComboBox roleField;
    protected JButton submit,
            reset,
            back;
    protected ImageIcon img,
            resetIcon;
    protected Color myBlue;
    protected int user_id;

    public UsersForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();

        this.panel.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));
        this.panel.setLayout(null);

        this.resetIcon = new ImageIcon("reset.png");
        this.img = new ImageIcon("users.jpg");
        this.background = new JLabel();
        this.myBlue = new Color(0x1f4d7f);

        this.title = new JLabel();
        this.id = new JLabel("ID: ");
        this.name = new JLabel("Name: ");
        this.password = new JLabel("Password: ");
        this.confirmPassword = new JLabel("Confirm password: ");
        this.role = new JLabel("Role: ");

        this.idField = new JTextField();
        this.nameField = new JTextField();
        this.passwordField = new JPasswordField();
        this.confirmField = new JPasswordField();

        String[] roles = {"Role", "Admin", "Project manager", "Developer", "Tester"};
        this.roleField = new JComboBox(roles);

        this.reset = new JButton("Reset");
        this.submit = new JButton();
        this.back = new JButton("Back");
        this.back.setIcon(backIcon);

        this.add(panel);
    }

    @Override
    public void properties() {
        this.panel.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));
        this.panel.setLayout(null);

        this.background.setIcon(img);
        this.panel.add(title);
        this.panel.add(id);
        this.panel.add(name);
        this.panel.add(password);
        this.panel.add(confirmPassword);
        this.panel.add(role);
        this.panel.add(idField);
        this.panel.add(nameField);
        this.panel.add(passwordField);
        this.panel.add(confirmField);
        this.panel.add(roleField);
        this.panel.add(submit);
        this.panel.add(back);
        this.panel.add(background);
    }

    @Override
    public void setBounds() {
        int xLabels = 110,
                xFields = 300,
                yLabels = 250,
                yFields = 250;
        final int WIDTHLABELS = 200,
                WIDTHFIELDS = 800,
                MyHEIGHT = 40;

        this.background.setBounds(0, 0, this.MYWIDTH, this.MYHEIGHT);

        this.title.setBounds(465, 100, 1000, 70);

        this.id.setBounds(xLabels, yLabels, WIDTHLABELS, MyHEIGHT);
        this.name.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.password.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.confirmPassword.setBounds(xLabels, yLabels += 60, WIDTHLABELS, MyHEIGHT);
        this.role.setBounds(xLabels, yLabels + 60, WIDTHLABELS, MyHEIGHT);

        this.idField.setBounds(xFields, yFields, WIDTHFIELDS, MyHEIGHT);
        this.nameField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.passwordField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.confirmField.setBounds(xFields, yFields += 60, WIDTHFIELDS, MyHEIGHT);
        this.roleField.setBounds(xFields, yFields + 60, WIDTHFIELDS, MyHEIGHT);

        this.submit.setBounds(870, 800, 230, 70);
        this.reset.setBounds(500, 800, 230, 70);

        this.back.setBounds(70, 950, 150, 50);
    }

    @Override
    public void setFonts() {
        this.title.setFont(new Font("Tahoma", Font.BOLD, 50));

        this.id.setFont(font_20);
        this.name.setFont(font_20);
        this.password.setFont(font_20);
        this.confirmPassword.setFont(font_20);
        this.role.setFont(font_20);

        this.idField.setFont(font_20);
        this.nameField.setFont(font_20);
        this.passwordField.setFont(font_20);
        this.confirmField.setFont(font_20);
        this.roleField.setFont(font_20);

        this.submit.setFont(font_24);
        this.reset.setFont(font_24);
        
        this.back.setFont(new Font("Tahoma", Font.PLAIN, 17));
    }

    @Override
    public void setColors() {
        this.title.setForeground(green);

        this.idField.setBackground(myBlue);
        this.nameField.setBackground(myBlue);
        this.passwordField.setBackground(myBlue);
        this.confirmField.setBackground(myBlue);
        this.roleField.setBackground(myBlue);

        this.id.setForeground(Color.white);
        this.name.setForeground(Color.white);
        this.password.setForeground(Color.white);
        this.confirmPassword.setForeground(Color.white);
        this.role.setForeground(Color.white);

        this.idField.setForeground(Color.white);
        this.nameField.setForeground(Color.white);
        this.passwordField.setForeground(Color.white);
        this.confirmField.setForeground(Color.white);
        this.roleField.setForeground(Color.white);

        this.idField.setCaretColor(Color.white);
        this.nameField.setCaretColor(Color.white);
        this.passwordField.setCaretColor(Color.white);
        this.confirmField.setCaretColor(Color.white);

        this.submit.setForeground(this.darkBlue);
        this.submit.setBackground(new Color(0x45e4c4));
        this.reset.setForeground(this.darkBlue);
        this.reset.setBackground(new Color(0x45e4c4));
    }

    @Override
    public void setOtherProperties() {
        this.title.setVerticalAlignment(JLabel.CENTER);
        this.title.setHorizontalAlignment(JLabel.CENTER);

        this.submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.back.setVerticalTextPosition(JButton.CENTER);
        this.back.setHorizontalTextPosition(JButton.RIGHT);
        this.back.setIconTextGap(10);

        this.submit.setFocusable(false);
        this.reset.setFocusable(false);
        this.back.setFocusable(false);
        
        this.reset.setIcon(this.resetIcon);
        this.reset.setVerticalTextPosition(JButton.CENTER);
        this.reset.setHorizontalTextPosition(JButton.RIGHT);
        this.reset.setIconTextGap(15);
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
