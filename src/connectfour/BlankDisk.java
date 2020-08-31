/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import javax.swing.ImageIcon; // Used to store data objects

/**
 * Program that creates a blank disk as extension of Disk.java to put in empty cells
 * @author Colin Chambachan
 * date: August 23rd, 2020
 */
public class BlankDisk extends Disk {
    
    /**
     * User the parent class to intialize the blank disk
     */
    public BlankDisk(){
        super("Grey",new ImageIcon("Grey.jpg"),"None");
        
    }
    
    @Override
    /**
     * Return the colour of this disk
     */
    public String getColour() {
        return "Grey";
    }
    
}
