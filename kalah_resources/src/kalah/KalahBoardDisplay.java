/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalah;

/**
 *
 * @author jdamm
 */
public interface KalahBoardDisplay {
    
     public void printBoard(int[] values);
     void printPlayerScore(int[] values);
     void printEndGame(int[] values);
     void printEmptyHouse();
    
}
