/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 * Creates an interface to check if the user wins or loses
 * @author Colin Chambachan
 * date August 25th, 2020
 */
public interface WinnerInterface {
    
    // Declare all the functions that are to be overwritten
    public void findWinner();
    public boolean isWinnerRow(int intRowValue, int intColumnValue);
    public boolean isWinnerColumn(int intRowValue, int intColumnValue);
    public boolean isWinnerDiagonal();
    
}
