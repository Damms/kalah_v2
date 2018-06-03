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
public interface KalahBoardLogic {
    
    int[] getBoardValues();
    int moveSeeds(int houseNum, boolean playerTurn);
    void getSeedsInHouse(boolean playerTurn);
    void spreadSeeds(boolean playerTurn);
    void addSeedToStore(boolean playerTurn);
    void addSeedToHouse(boolean playerTurn);
    
}
