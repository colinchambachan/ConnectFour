/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import javax.swing.ImageIcon; // Used to store data objects

/**
 * Create an abstract class which will be implemented in the YellowDisk and RedDisk class
 * @author Colin Chambachan
 * date August 23rd, 2020
 */
public abstract class Disk {
    // Declare the variables used in each subclass
    private String strDiskColour;
    ImageIcon imgDiskIcon;
    String strPlayerNumber;
    
    /**
     * Constructor function for the Disk class, and their instances
     * @param strColour is the colour of the disk
     * @param imgIcon is the image icon associated with the instance of the disk
     * @param strPlayer is the player the disk is associated with
     */
    public Disk(String strColour, ImageIcon imgIcon, String strPlayer){
        strDiskColour = strColour;
        imgDiskIcon = imgIcon;
        strPlayerNumber = strPlayer;
    }
    
    /**
     * Abstract function that gets the colour of the disk
     * @return the colour of the disks
     */
    abstract public String getColour();
}
