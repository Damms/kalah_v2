/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalah;

/**
 *
 * @author Jaedyn
 */

public class KalahConstants {
    public static final int numberOfHouses = 6;
    public static final int seedsInHouse = 4;
    public static final int numberOfPlayers = 2;
    public static final int initSeedsInStore = 0;
    public static final int emptyHouse = 10;
    
    public static final String player1InputText = "Player P1's turn - Specify house number or 'q' to quit: ";
    public static final String player2InputText = "Player P2's turn - Specify house number or 'q' to quit: ";
    public static final String player1WinMessage = "Player 1 wins!";
    public static final String player2WinMessage = "Player 2 wins!";
    public static final String tiedMessage = "A tie!";
    public static final String gameOverMessage = "Game over";
    public static final String emptyHouseMessage = "House is empty. Move again.";
    public static final String player1ScoreMessage = "\tplayer 1:";
    public static final String player2ScoreMessage = "\tplayer 2:";
    public static final String topBoardOutput = "| P2 | 6[%2d] | 5[%2d] | 4[%2d] | 3[%2d] | 2[%2d] | 1[%2d] | %2d |";
    public static final String bottomBoardOutput = "| %2d | 1[%2d] | 2[%2d] | 3[%2d] | 4[%2d] | 5[%2d] | 6[%2d] | P1 |";
    public static final String boardBreak1 = "+----+-------+-------+-------+-------+-------+-------+----+";
    public static final String boardBreak2 = "|    |-------+-------+-------+-------+-------+-------|    |";
}
