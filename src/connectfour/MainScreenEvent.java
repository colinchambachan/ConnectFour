/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;
// Import the needed libraries to run the code
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*; // Used to read and write text files

/**
 * This program controls the event handling for the Main Screen
 * @author Colin Chambachan
 * date: August 23rd, 2020
 */
public class MainScreenEvent implements ActionListener, WinnerInterface{
    MainScreen mainScreenGui;
    int intNumOfClicks = 0;
    int intNumOfWins = 0;
    Disk [][] trackDisks = new Disk [7][7];
    ImageIcon imgGrey = new ImageIcon("Grey.jpg");
    // Create global variables used to track the number of wins and ties for each player
    int intPlayerOneWins = 0;
    int intPlayerTwoWins = 0;
    int intNumberOfTies = 0;
    // Declare the variables which track the vacant column on the board
    int intColumnOneVacant = 6;
    int intColumnTwoVacant = 6;
    int intColumnThreeVacant = 6;
    int intColumnFourVacant = 6;
    int intColumnFiveVacant = 6;
    int intColumnSixVacant = 6;
    int intColumnSevenVacant = 6;
    // Declare global variable which tracks the number of disks in a row
    int intDisksInARow = 0;
    int intDisksInAColumn = 0;
    
    /**
     * Initialize the trackDisks array to create to be new blank disks
     * @param in is an instance of mainscreen
     */
    public MainScreenEvent(MainScreen in){
        mainScreenGui = in;
        // Initialize a 2d array which can will be used to check if the user has won
        for (int row = 1; row < 7; row++){
           for (int col = 0; col < 7; col++){
               // Create an instance of a new blank disk 
               trackDisks[row][col] = new BlankDisk();
           }
       }
    }
    
    // Implement the abstract method from ActionListener
    @Override
    /**
     * Function gets the action preformed by the user, and calls the correspoinding function
     */
    public void actionPerformed(ActionEvent event) {
        // Get the command that the user called
        String strUserCommand = event.getActionCommand();
        
        // Call the function that corresponds with the event, and then check for if there is a winner
        if (strUserCommand.equals("Leaderboard")){
            LeaderboardGui leaderboardGUI = new LeaderboardGui(mainScreenGui);
            leaderboardGUI.setVisible(true);
            mainScreenGui.setVisible(false);
        } else if (strUserCommand.equals("Save and Exit")){
            saveAndExit();
        } else if (strUserCommand.equals("Reset")){
            restartGame();
        } else if (strUserCommand.equals("Click Column 1")){
            columnOne();
            findWinner();
        } else if (strUserCommand.equals("Click Column 2")) {
            columnTwo();
            findWinner();
        } else if (strUserCommand.equals("Click Column 3")) {
            columnThree();
            findWinner();
        } else if (strUserCommand.equals("Click Column 4")) {
            columnFour();
            findWinner();
        } else if (strUserCommand.equals("Click Column 5")) {
            columnFive();
            findWinner();
        } else if (strUserCommand.equals("Click Column 6")) {
            columnSix();
            findWinner();
        } else if (strUserCommand.equals("Click Column 7")) {
            columnSeven();
            findWinner();
        }
    }
    /**
     * Exit the application and write the highest win score in to the WinTotals file
     */
    public void saveAndExit(){
        // Write into the file todays date and the high score
        try{
            FileWriter fr = new FileWriter("WinTotals.txt",true);
            PrintWriter pr = new PrintWriter(fr);
            pr.write(mainScreenGui.strTodaysDate + "\n");
            if (intPlayerOneWins > intPlayerTwoWins){
                pr.write(intPlayerOneWins + "\n");
            }
            else{
                pr.write(intPlayerTwoWins + "\n");
            }
            // Close the print writer
            pr.close();
            
        }
        catch (IOException e){}
        
        // Exit the application
        System.exit(0);
    }
    
    /**
     * Update the disk to fall into column One
     */
    public void columnOne(){
        // Make sure that the user is playing a varlid move in the game
        if (intColumnOneVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnOneVacant][0] = new RedDisk();
                mainScreenGui.boxesList[intColumnOneVacant][0].setIcon(trackDisks[intColumnOneVacant][0].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnOneVacant][0] = new YellowDisk();
                mainScreenGui.boxesList[intColumnOneVacant][0].setIcon(trackDisks[intColumnOneVacant][0].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
                
            }   
            // Decrease the vacant column value in column One
            intColumnOneVacant--;
        }    
        

    }
    /**
     * Update the disk to fall into column Two
     */
    public void columnTwo(){
        // Make sure that the user is playing a varlid move in the game
        if (intColumnTwoVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnTwoVacant][1] = new RedDisk();
                mainScreenGui.boxesList[intColumnTwoVacant][1].setIcon(trackDisks[intColumnTwoVacant][1].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnTwoVacant][1] = new YellowDisk();
                mainScreenGui.boxesList[intColumnTwoVacant][1].setIcon(trackDisks[intColumnTwoVacant][1].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
            }      
            // Decrease the vacant column value in column Two
            intColumnTwoVacant--;
        }    
        

    }
    /**
     * Update the disk to fall into column Three
     */
    public void columnThree(){
        // Make sure that the user is playing a varlid move in the game
        if (intColumnThreeVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnThreeVacant][2] = new RedDisk();
                mainScreenGui.boxesList[intColumnThreeVacant][2].setIcon(trackDisks[intColumnThreeVacant][2].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnThreeVacant][2] = new YellowDisk();
                mainScreenGui.boxesList[intColumnThreeVacant][2].setIcon(trackDisks[intColumnThreeVacant][2].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
            }
            // Decrease the vacant column value in column three
            intColumnThreeVacant--;            
        }    
        

    }
    /**
     * Update the disk to fall into column Four
     */
    public void columnFour(){
        // Make sure that the user is playing a varlid move in the game
        if (intColumnFourVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnFourVacant][3] = new RedDisk();
                mainScreenGui.boxesList[intColumnFourVacant][3].setIcon(trackDisks[intColumnFourVacant][3].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnFourVacant][3] = new YellowDisk();
                mainScreenGui.boxesList[intColumnFourVacant][3].setIcon(trackDisks[intColumnFourVacant][3].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
            }        
            // Decrease the vacant column value in column three
            intColumnFourVacant--;
        }

    }
    /**
     * Update the disk to fall into column Five
     */
    public void columnFive(){
        // Make sure that the user is playing a valid move in the game
        if (intColumnFiveVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnFiveVacant][4] = new RedDisk();
                mainScreenGui.boxesList[intColumnFiveVacant][4].setIcon(trackDisks[intColumnFiveVacant][4].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnFiveVacant][4] = new YellowDisk();
                mainScreenGui.boxesList[intColumnFiveVacant][4].setIcon(trackDisks[intColumnFiveVacant][4].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
            }      
            // Decrease the vacant column value in column three
            intColumnFiveVacant--;
        }    
        

    }
    
    /**
     * Update the disk to fall into column Five
     */
    public void columnSix(){
        // Make sure that the user is playing a valid move in the game
        if (intColumnSixVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnSixVacant][5] = new RedDisk();
                mainScreenGui.boxesList[intColumnSixVacant][5].setIcon(trackDisks[intColumnSixVacant][5].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnSixVacant][5] = new YellowDisk();
                mainScreenGui.boxesList[intColumnSixVacant][5].setIcon(trackDisks[intColumnSixVacant][5].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
            }
            // Decrease the vacant column value in column three
            intColumnSixVacant--;            
        }    
        

    }
    /**
     * Update the disk to fall into column Five
     */
    public void columnSeven(){
        
        // Make sure that the user is playing a valid move in the game
        if (intColumnSevenVacant > 0){
            // Check to see whos turn it is
            intNumOfClicks++;
            if ((intNumOfClicks % 2) == 1){
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnSevenVacant][6] = new RedDisk();
                mainScreenGui.boxesList[intColumnSevenVacant][6].setIcon(trackDisks[intColumnSevenVacant][6].imgDiskIcon);
                mainScreenGui.txtPlayerTwoBlank.setText("->Player Two Wins: " + intPlayerTwoWins);
                mainScreenGui.txtPlayerOneBlank.setText("Player One Wins: " + intPlayerOneWins);
                
                
            } else{
                // Update the track disks array, and change where the arrow is displaying whos turn it is
                trackDisks[intColumnSevenVacant][6] = new YellowDisk();
                mainScreenGui.boxesList[intColumnSevenVacant][6].setIcon(trackDisks[intColumnSevenVacant][6].imgDiskIcon);
                mainScreenGui.txtPlayerOneBlank.setText("->Player One Wins: " + intPlayerOneWins);
                mainScreenGui.txtPlayerTwoBlank.setText("Player Two Wins: " + intPlayerTwoWins);
            }        
            // Decrease the vacant column value in column three
            intColumnSevenVacant--;
        }    
        
    }
    @Override
    /**
     * Check to see if any user has won
     */
    public void findWinner(){
        // Declare variables used to track if theres a winner
        boolean isWinnerFoundRow = false;
        boolean isWinnerFoundColumn = false;
        boolean isWinnerFoundDiagonal = false;
        intDisksInARow = 0;
        intDisksInAColumn = 0;
        
        // Check Rows for Winner
        for (int row = 6; row >= 1; row--){
            intDisksInARow = 0;
            for (int column = 0; column <= 3; column++){
                
                isWinnerFoundRow = isWinnerRow(row ,column);
                if (isWinnerFoundRow == true)break;
            
            }
            
            if (isWinnerFoundRow == true)break;
      
        }
        // Check Column for Winner
        for (int column = 0; column < 7; column++){
            // Check strarting from the bottom of the grid (the highest row value)
            for (int row = 6; row > 3; row--){
                intDisksInAColumn = 0;
                isWinnerFoundColumn = isWinnerColumn(row , column);
                if (isWinnerFoundColumn == true){
                    break;
                }  
            }
            if (isWinnerFoundColumn == true){
                break;
            }    
        }
        
        // Check Diagnonal Winner
        isWinnerFoundDiagonal = isWinnerDiagonal();
        

        
        // Check to see if either of the users won
        if (isWinnerFoundRow || isWinnerFoundColumn || isWinnerFoundDiagonal){
            // Check to see which user won the game
            if (intNumOfClicks % 2 == 1){
                //Player One won
                JOptionPane.showMessageDialog(null, "Connect Four! Player One Wins!");
                intNumOfWins = 1;
                // Increase the number of times the player has won
                intPlayerOneWins++;
                mainScreenGui.txtPlayerOneBlank.setText("  Player One Wins: " + intPlayerOneWins);
                // Restart the game
                restartGame();
            } else {
                // Player two wins
                JOptionPane.showMessageDialog(null, "Connect Four! Player Two Wins!");
                intNumOfWins = 1;
                // Increase the number of times the player has won
                intPlayerTwoWins++;
                mainScreenGui.txtPlayerTwoBlank.setText("  Player Two Wins: " + intPlayerTwoWins);
                // Restart the game
                restartGame();
            }
        }
        
        // Check to see if theres a tie
        if (intNumOfClicks == 42 && intNumOfWins == 0){
            // Output the number of ties and restart the game
            intNumberOfTies++;
            JOptionPane.showMessageDialog(null, "The Two Players Tied");
            mainScreenGui.txtTieBlank.setText("  Number Of Ties: " + intNumberOfTies);
            restartGame();
            
        }
        
    }
    
    @Override
    /**
     * A Recursive Function which checks the rows for winners
     * @param intRowValue is the row number being checked
     * @param intColumnValue is the column value being checked
     * @return whether there is a winner or not
     */
    public boolean isWinnerRow(int intRowValue, int intColumnValue){
        // Check to see if the number of connections is equal to 4
        if (intDisksInARow == 4){
            return true;
        }
        // Check to see if we are at the last column, and instead of getting thrown an out of bounds error, we check previous value
        if (intColumnValue == 6 && trackDisks[intRowValue][intColumnValue].getColour().equals(trackDisks[intRowValue][intColumnValue -1].getColour()) && !trackDisks[intRowValue][intColumnValue].getColour().equals("Grey")){
            return true;
        } else if (intColumnValue == 6 && !trackDisks[intRowValue][intColumnValue].getColour().equals(trackDisks[intRowValue][intColumnValue - 1].getColour()) && !trackDisks[intRowValue][intColumnValue].getColour().equals("Grey")){
            return false;
        }
        
        // Use Recursion to see if the program should check the next disk
        String strCurrentIteration = (trackDisks[intRowValue][intColumnValue]).getColour();
        String strNextIteration = trackDisks[intRowValue][intColumnValue + 1].getColour();
        // Check to see if the parameters check out, and if not then return false
        if (strCurrentIteration.equals(strNextIteration) && !(strNextIteration.equals("Grey"))&& !(strCurrentIteration.equals("Grey"))){
            // Move on to the next value in the array
            intDisksInARow++;
            return isWinnerRow(intRowValue, (intColumnValue + 1));
        }
        else {
            return false;
        }
          
    
    }
    @Override
    /**
     * A Recursive Function which checks the Column for winners
     * @param intRowValue is the row number being checked
     * @param intColumnValue is the column value being checked
     * @return whether there is a winner or not
     */
    public boolean isWinnerColumn(int intRowValue, int intColumnValue){
        // Check to see if the number of connections is equal to 4
        if (intDisksInAColumn == 3){
            return true;
        }
        
        
        // Check to see if we are at the last column, and instead of getting thrown an out of bounds error, we check previous value
        if (intRowValue == 1 && trackDisks[intRowValue][intColumnValue].getColour().equals(trackDisks[(intRowValue + 1)][intColumnValue].getColour()) && !(trackDisks[intRowValue][intColumnValue].getColour().equals("Grey"))){
            return true;
        } else if (intRowValue == 1 && !trackDisks[intRowValue][intColumnValue].getColour().equals(trackDisks[(intRowValue + 1)][intColumnValue].getColour()) && !(trackDisks[intRowValue][intColumnValue].getColour().equals("Grey"))){
            return false;
        }
        // Use Recursion to see if the program should check the next disk
        String strCurrentIteration = trackDisks[intRowValue][intColumnValue].getColour();
        String strNextIteration = trackDisks[intRowValue - 1][intColumnValue].getColour();
        
        
        if (strCurrentIteration.equals(strNextIteration) && !strCurrentIteration.equals("Grey")){
            // Move on to the next value in the array
            intDisksInAColumn++;
            return isWinnerColumn((intRowValue - 1), intColumnValue);
        }
        else {
            return false;
        }
        
    }
    @Override
    /**
     * Function that checks if for winners diagonally
     * @return whether there is a winner or not
     */
    public boolean isWinnerDiagonal(){
        // Check to see which colour is being checked for
        String strDesiredColour;
        if (intNumOfClicks % 2 == 1){
            strDesiredColour = "Red";
        } else{
            strDesiredColour = "Yellow";
        }
        // Check for any wins in the ascending order (bottom left to top right)
        for (int i=4; i < 7; i++){
            for (int j= 0; j < 4; j++){
                if (trackDisks[i][j].getColour().equals(strDesiredColour) && trackDisks[i-1][j+1].getColour().equals(strDesiredColour) && trackDisks[i-2][j+2].getColour().equals(strDesiredColour) && trackDisks[i-3][j+3].getColour().equals(strDesiredColour))
                    return true;
            }
        }
        // Check for any wins in the decending order (bottom right to top left)
        for (int i=4; i < 7; i++){
            for (int j=3; j < 7; j++){
                if (trackDisks[i][j].getColour().equals(strDesiredColour) && trackDisks[i-1][j-1].getColour().equals(strDesiredColour) && trackDisks[i-2][j-2].getColour().equals(strDesiredColour) && trackDisks[i-3][j-3].getColour().equals(strDesiredColour))
                    return true;
            }
        }
        // If none of the conditions are met, it returns 
        return false;
    }
    /**
     * Restart the game
     */
    public void restartGame(){
        // Reset the variables needed for the next game
        intNumOfClicks = 0;
        intNumOfWins = 0;
        intColumnOneVacant = 6;
        intColumnTwoVacant = 6;
        intColumnThreeVacant = 6;
        intColumnFourVacant = 6;
        intColumnFiveVacant = 6;
        intColumnSixVacant = 6;
        intColumnSevenVacant = 6;
        
        // Reinitialize the array of disks
        for (int row=1; row< 7; row++){
           for (int col=0; col< 7; col++){
               trackDisks[row][col]= new BlankDisk();
           }
        }
        // Reset the icons of all the buttons
        // Reset all the images on the screen
        for (int i = 1; i < 7; i++){
            for (int j = 0; j < 7; j++){
                mainScreenGui.boxesList[i][j].setIcon(imgGrey);
            }
        }
    }
    
}
