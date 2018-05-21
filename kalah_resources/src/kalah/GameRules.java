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
public class GameRules {
    
        // check if one side has been cleared - graceful end
    public static boolean endGameRule(boolean playerTurn, BoardManager board){ // refactor this out
        int count1 = 0, count2 = 0;
        
        for(int i = 0; i < KalahConstants.numberOfHouses; i++){
            
            if(playerTurn){
                if(board.player2Houses[i].getSeeds() == 0){
                    count2++;
                }
            } else {
                if(board.player1Houses[i].getSeeds() == 0){
                count1++;
                }
            }
            
        }
        
        return count1 == KalahConstants.numberOfHouses || count2 == KalahConstants.numberOfHouses;
        
    }
    
    public static boolean captureRule(boolean startingPlayerTurn, BoardManager board){ 
            
        int seedsInOppositeHouse;
        
        if(board.endingPlayerTurn){ // ends on player 2 side
            
            if(startingPlayerTurn){ // was originally player 2 turn
                seedsInOppositeHouse = board.player1Houses[(KalahConstants.numberOfHouses-1) - board.currentHouse].getSeeds();
                
                if(board.player2Houses[board.currentHouse].getSeeds() == 1 && seedsInOppositeHouse > 0){
                    return true;
                }
            }
        } 
        else { // ends on player 1 side
            
            if(!startingPlayerTurn){ // was originally player 1 turn
                seedsInOppositeHouse = board.player2Houses[(KalahConstants.numberOfHouses-1) - board.currentHouse].getSeeds();
                
                if(board.player1Houses[board.currentHouse].getSeeds() == 1 && seedsInOppositeHouse > 0){ 
                    return true;
                }
            }
        }
        return false; 
    }
    
}
