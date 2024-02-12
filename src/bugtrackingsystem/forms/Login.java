package bugtrackingsystem.forms;

import bugtrackingsystem.templates.*;
import bugtrackingsystem.Frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Login extends Frame implements ActionListener {

    private final JPanel page;
    private final ImageIcon image,
            loginIcon;
    private final JPanel panel;
    private final JLabel background,
            idLabel,
            passLabel;
    private final JTextField idField;
    private final JPasswordField passField;
    private final JButton login;

    public Login() {
        this.page = new JPanel();
        this.image = new ImageIcon("background.jpg");
        this.loginIcon = new ImageIcon("login.png");
        this.background = new JLabel();
        this.panel = new JPanel();
        this.idLabel = new JLabel("ID: ");
        this.passLabel = new JLabel("Password: ");
        this.idField = new JTextField();
        this.passField = new JPasswordField();
        this.login = new JButton("Login");

        this.add(page);

        super.showing();
    }

    @Override
    public void properties() {
        page.setLayout(null);
        this.page.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));

        this.login.setIcon(loginIcon);
        this.background.setIcon(image);
        this.background.setBounds(0, 0, this.MYWIDTH, this.MYHEIGHT);

        this.panel.setLayout(null);

        login.addActionListener(this);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(login);

        page.add(background, 0);
        page.add(panel, 0);
    }

    @Override
    public void setBounds() {
        panel.setBounds(250, 590, 700, 370);

        idLabel.setBounds(50, 30, 150, 35);
        passLabel.setBounds(50, 90, 150, 35);
        idField.setBounds(230, 20, 400, 35);
        passField.setBounds(230, 80, 400, 35);
        
        login.setBounds(240, 230, 250, 80);
    }

    @Override
    public void setFonts() {
        idLabel.setFont(this.font_20);
        passLabel.setFont(this.font_20);
        idField.setFont(this.font_20);
        passField.setFont(this.font_20);
        login.setFont(this.font_24);
    }

    @Override
    public void setColors() {
        panel.setBackground(blue);

        idLabel.setForeground(Color.white);
        passLabel.setForeground(Color.white);
        idField.setForeground(Color.white);
        passField.setForeground(Color.white);
        login.setForeground(this.darkBlue);

        idField.setBackground(blue);
        passField.setBackground(blue);
        login.setBackground(green);

        idField.setSelectedTextColor(Color.black);
        passField.setSelectedTextColor(Color.black);
        idField.setSelectionColor(green);
        passField.setSelectionColor(green);

        idField.setCaretColor(Color.white);
        passField.setCaretColor(Color.white);
    }

    @Override
    public void setOtherProperties() {
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);

        idField.setBorder(border);
        passField.setBorder(border);

        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setVerticalTextPosition(JButton.CENTER);
        login.setHorizontalTextPosition(JButton.LEFT);
        login.setIconTextGap(15);
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == login) {

            String idStr = this.idField.getText().trim();
            String pass = this.passField.getText().trim();

            try {
                if (!idStr.equals("") && !pass.equals("")) {
                    int id = Integer.parseInt(this.idField.getText().trim());
                    String sql = "select * from users where id = " + id + " ";

                    ResultSet rs = this.statement.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getString("password").equals(pass)) {
                            switch (rs.getString("role")) {
                                case "Admin" -> {
                                    Admin admin = new Admin(id);
                                    this.dispose();
                                }

                                case "Project manager" -> {
                                    Manager manager = new Manager(id);
                                    this.dispose();
                                }

                                case "Developer" -> {
                                    Developer developer = new Developer(id);
                                    this.dispose();
                                }

                                case "Tester" -> {
                                    Tester tester = new Tester(id);
                                    this.dispose();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Password is not correct", "Login failed", JOptionPane.ERROR_MESSAGE, errorIcon);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fill the login form", "Login failed", JOptionPane.ERROR_MESSAGE, errorIcon);
                }
            } catch (SQLException | java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "User not found", "Login failed", JOptionPane.ERROR_MESSAGE, errorIcon);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirm(e);
    }
}
