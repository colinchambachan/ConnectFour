/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import javax.swing.ImageIcon;

/**
 * Created class for the Red Disk, 
 * @author Colin Chambachan
 * date: August 23rd, 2020
 */
public class RedDisk extends Disk {

    /**
     * Use parent class to intialize constructor class
     */
    public RedDisk(){
        super ("Red", new ImageIcon("Red.jpg"), "Player One");
    }
    
    @Override
    /**
     * Return the colour of the disk
     */
    public String getColour() {
        return "Red";
        
    }
    
}
