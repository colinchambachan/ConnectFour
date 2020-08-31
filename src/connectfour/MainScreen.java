/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

// Import the needed libraries to run the code
import java.awt.*;
import javax.swing.*;

/**
 * This is the class for main screen gui, it intializes all its components
 * @author Colin Chambachan
 * date: August 23rd, 2020
 */
public class MainScreen extends JFrame {    
    
    // Initialize the gui elements needed
    MainScreenEvent mainScreenEvent = new MainScreenEvent(this);
    String strTodaysDate;
    JPanel pnlJPanel = new JPanel();
    JButton[][] boxesList = new JButton[7][7];
    ImageIcon imgGrey = new ImageIcon("Grey.jpg");
    JButton btnReset = new JButton("Reset");
    JButton btnLeaderBoard = new JButton("Leaderboard");
    JButton btnExit = new JButton("Save and Exit");
    JTextField txtPlayerOneBlank = new JTextField();
    JTextField txtPlayerTwoBlank = new JTextField();
    JTextField txtTieBlank = new JTextField();;
    JTextField txtGreatestWins = new JTextField();;

           
    /**
     * Constructor function for the main Screen Gui
     * @param date is the date the user enters
     */   
    public MainScreen (String date){
        // Initializing the gui window
        // Set the Window title and Window Size
        super ("Connect Four!");
        setSize (910,700);
        // Initialize how the window can close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Get todays date
        strTodaysDate = date;
        
        // Create the layout of the grid, and create new boxes
        GridLayout gridLayout  = new GridLayout(8, 7, 10, 10);
        pnlJPanel.setLayout(gridLayout );
        // Use a for loop to initialize the grid layout
        for (int x=0; x < 7; x++){
            for (int y = 0; y < 7; y++){
                // If row 0, is being initialized set, the name of the box to be "Click Column + y"
                if (x == 0){
                    boxesList[x][y] = new JButton("Click Column " + (y + 1));
                    pnlJPanel.add(boxesList[x][y]);
                    // Add a listener to each of the column buttons
                    boxesList[x][y].addActionListener(mainScreenEvent);
                    
                } else{
                    boxesList[x][y] = new JButton("");
                    boxesList[x][y].setIcon(new BlankDisk().imgDiskIcon);
                    pnlJPanel.add(boxesList[x][y]);
                }
                
                
            }
        }
        // Add each element to the JPanel, as well as  their actionlisteners
        pnlJPanel.add(txtPlayerOneBlank);
        pnlJPanel.add(txtGreatestWins);
        txtGreatestWins.addActionListener(mainScreenEvent);
        pnlJPanel.add(btnLeaderBoard);
        btnLeaderBoard.addActionListener(mainScreenEvent);
        btnReset.addActionListener(mainScreenEvent);
        pnlJPanel.add(btnExit);
        btnExit.addActionListener(mainScreenEvent);
        txtTieBlank.addActionListener(mainScreenEvent);
        pnlJPanel.add(btnReset);
        pnlJPanel.add(txtTieBlank);
        pnlJPanel.add(txtPlayerTwoBlank);
        add (pnlJPanel);
        
        // Output the number of wins and ties per player (default 0)
        txtPlayerOneBlank.setText("  Player One Wins: 0");
        txtPlayerTwoBlank.setText("  Player Two Wins: 0");
        txtTieBlank.setText("  Number Of Ties: 0");
        // Output the number highest number of wins this game has by creating an instance of the gui
        LeaderboardGui highestValueGui = new LeaderboardGui(this);
        txtGreatestWins.setText("  Highest Wins: " + highestValueGui.highestValue());
        
        
        
        
        // Make the gui visible
        setVisible(true);
        
        
    }
    
}
    
