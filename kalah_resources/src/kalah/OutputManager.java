/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 *
 * @author Jaedyn
 */
public class OutputManager implements KalahBoardDisplay {
    
    IO io;
    int[] playerScores = new int[2];
    
    public OutputManager(IO io) {
        this.io = io;
    }
    
    
    @Override
     public void printBoard(int[] values) {
        io.println(KalahConstants.boardBreak1); 
        String player2Line = String.format(KalahConstants.topBoardOutput, values[13], values[12], values[11], values[10], values[9], values[8], values[0]);
        io.println(player2Line);
        io.println(KalahConstants.boardBreak2);
        String player1Line = String.format(KalahConstants.bottomBoardOutput, values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
        io.println(player1Line);
        io.println(KalahConstants.boardBreak1);
    }
    
    @Override
    public void printPlayerScore(int[] values) {
        updatePlayerScores(values);
        
        io.println(KalahConstants.player1ScoreMessage + playerScores[0] );
        io.println(KalahConstants.player2ScoreMessage  + playerScores[1] );

        if(playerScores[0] >  playerScores[1]){
            io.println(KalahConstants.player1WinMessage);
        } else if (playerScores[0] <  playerScores[1]){
            io.println(KalahConstants.player2WinMessage);
        } else {
            io.println(KalahConstants.tiedMessage);
        }
    }

    @Override
    public void printEndGame(int[] values) {
        io.println(KalahConstants.gameOverMessage);
        printBoard(values);
    }
    
    @Override
    public void printEmptyHouse() {
       io.println(KalahConstants.emptyHouseMessage); 
    }
    
    public void updatePlayerScores(int[] values) {
        playerScores[0] = values[0]+values[2]+values[3]+values[4]+values[5]+values[6]+values[7]; // store + houses
        playerScores[1] = values[13]+values[12]+values[11]+values[10]+values[9]+values[8]+values[1]; // houses + store
    }  
    
}
