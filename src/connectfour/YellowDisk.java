/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import javax.swing.ImageIcon; // Used to store data objects

/**
 * Program creates an extension of Disk.java which creates a data object used in Connect 4
 * @author Colin Chambachan
 * date August 23rd, 2020
 */
public class YellowDisk extends Disk {
    /**
     * Initialize the yellow disk
     */
    public YellowDisk(){
        super("Yellow", new ImageIcon("Yellow.jpg"), "Player Two");
    }

    @Override
    /**
     * Return the colour of the class
     */
    public String getColour() {
        return "Yellow";
    }
}
