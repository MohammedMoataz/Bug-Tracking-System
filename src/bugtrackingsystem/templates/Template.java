package bugtrackingsystem.templates;

import bugtrackingsystem.Frame;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public abstract class Template extends Frame {

    protected JPanel panel;
    protected JLabel title;
    protected JButton bugs,
            button,
            logout;
    protected int user_id;
    private final JLabel background;
    private final ImageIcon image,
            logoutIcon;

    public Template() {
        this.background = new JLabel();
        this.image = new ImageIcon("template.jpg");
        this.background.setIcon(image);
        this.background.setBounds(0, 0, this.MYWIDTH, this.MYHEIGHT);

        this.panel = new JPanel();
        this.title = new JLabel();
        this.bugs = new JButton("View bugs");
        this.button = new JButton();
        
        this.logout = new JButton("Logout");
        this.logoutIcon = new ImageIcon("turn off.png");
        this.logout.setIcon(logoutIcon);
    }

    @Override
    public void properties() {
        this.panel.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));
        this.panel.setLayout(null);

        String sql = "select * from users where id = '" + this.user_id + "' ";

        try {
            ResultSet rs = this.statement.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                title.setText("Welcome, " + name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE, errorIcon);
        }

        this.panel.add(this.title);
        this.panel.add(this.bugs);
        this.panel.add(this.button);
        this.panel.add(this.logout);
        this.panel.add(this.background);

        this.add(panel);
    }

    @Override
    public void setBounds() {
        this.title.setBounds(465, 80, 1000, 100);

        this.bugs.setBounds(450, 850, 300, 100);
        this.button.setBounds(1150, 850, 300, 100);
        this.logout.setBounds(70, 950, 150, 50);
    }

    @Override
    public void setFonts() {
        this.title.setFont(new Font("Tahoma", Font.BOLD, 45));

        this.bugs.setFont(font_24);
        this.button.setFont(font_24);
        this.logout.setFont(new Font("Tahoma", Font.PLAIN, 17));
    }

    @Override
    public void setColors() {
        this.title.setForeground(new Color(250, 250, 255));

        this.bugs.setForeground(this.darkBlue);
        this.button.setForeground(this.darkBlue);

        this.bugs.setBackground(green);
        this.button.setBackground(green);
    }

    @Override
    public void setOtherProperties() {
        this.title.setVerticalAlignment(JLabel.CENTER);
        this.title.setHorizontalAlignment(JLabel.CENTER);

        this.bugs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.logout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.bugs.setFocusable(false);
        this.button.setFocusable(false);
        this.logout.setFocusable(false);
        
        this.logout.setVerticalTextPosition(JButton.CENTER);
        this.logout.setHorizontalTextPosition(JButton.RIGHT);
        this.logout.setIconTextGap(15);
    }

}
