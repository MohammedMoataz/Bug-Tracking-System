package bugtrackingsystem;

import bugtrackingsystem.forms.Form;
import database.*;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public abstract class Frame extends JFrame implements Form {

    protected final ImageIcon errorIcon,
            successIcon,
            Icon,
            backIcon;
    protected final Color blue,
            green,
            darkBlue;
    protected final Font font_18,
            font_20,
            font_24;
    protected final int MYWIDTH,
            MYHEIGHT;
    protected final Statement statement;

    public Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bug Tracking System");
        this.setResizable(false);
        this.setLocation(-7, -2);

        this.MYWIDTH = 1930;
        this.MYHEIGHT = 1080;

        this.errorIcon = new ImageIcon("error.png");
        this.successIcon = new ImageIcon("run.png");
        this.backIcon = new ImageIcon("back.png");
        this.Icon = new ImageIcon("icon.png");
        this.setIconImage(Icon.getImage());

        this.statement = new DatabaseConnection().setStatement();

        this.blue = new Color(0x2b42c2);
        this.darkBlue = new Color(0x123456);
        this.green = new Color(0x45e4c4);

        this.font_18 = new Font("Tahoma", Font.PLAIN, 18);
        this.font_20 = new Font("Tahoma", Font.PLAIN, 20);
        this.font_24 = new Font("Tahoma", Font.PLAIN, 24);
    }

    public void showing() {

        properties();
        setBounds();
        setFonts();
        setColors();
        setOtherProperties();

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void properties() {
    }

    @Override
    public void setBounds() {
    }

    @Override
    public void setFonts() {
    }

    @Override
    public void setColors() {
    }

    @Override
    public void setOtherProperties() {
    }

    @Override
    public void confirm(ActionEvent eve) {
    }
}
