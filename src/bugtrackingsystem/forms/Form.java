package bugtrackingsystem.forms;

import java.awt.event.ActionEvent;

public interface Form {

    /**
     * Set properties of container and call all other methods
     */
    public void properties();

    /**
     * Set size and location of components and container
     */
    public void setBounds();

    /**
     * Set fonts of component
     */
    public void setFonts();

    /**
     * Set background and foreground colors and selections too
     */
    public void setColors();

    /**
     * Set other properties such as: border, focus, etc...
     */
    public void setOtherProperties();

    /**
     * That's confirm what the button should do when clicked it
     * @param eve
     */
    public void confirm(ActionEvent eve);

}
