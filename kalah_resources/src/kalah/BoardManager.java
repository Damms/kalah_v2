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

public class BoardManager {   
    int seedsInHouse = 0;
    int firstHouse = -1;
    int currentHouse;        
    boolean endingPlayerTurn;           
    
    House[] player1Houses = new House[KalahConstants.numberOfHouses];
    House[] player2Houses = new House[KalahConstants.numberOfHouses];
    Store player1Store = null;
    Store player2Store = null;
    
    int[] values = new int[(KalahConstants.numberOfHouses*2) + KalahConstants.numberOfPlayers]; 
    
    public BoardManager(House[] player1House, House[] player2House, Store p1Store, Store p2Store){
        for(int i = 0; i < KalahConstants.numberOfHouses; i++){
            this.player1Houses[i] = player1House[i];
            this.player2Houses[i] = player2House[i];
        }
        this.player1Store = p1Store;
        this.player2Store = p2Store;
    }
    
    
    // Return values : 0 = empty house try again, 1 = anotherTurn, 2 = nextPlayerTurn
    public int moveSeeds(int houseNum, boolean playerTurn){ 
        seedsInHouse = 0;
        currentHouse = houseNum;
        endingPlayerTurn = playerTurn;
        
        getSeedsInHouse(playerTurn);
        
        if(seedsInHouse == 0){ 
            return 0; 
        }
        
        spreadSeeds(playerTurn);

        return captureCheck(playerTurn);
        
    }
    
     // update display values with backend stored values
    public void getSeedsInHouse(boolean playerTurn){
        
        if(playerTurn){ // player 2 turn
            seedsInHouse = this.player2Houses[currentHouse].getSeeds();
            this.player2Houses[currentHouse].setSeeds(0);
        } else { // player 1 turn
            seedsInHouse = this.player1Houses[currentHouse].getSeeds();
            this.player1Houses[currentHouse].setSeeds(0);
        }
        
    }
    
    public void spreadSeeds(boolean playerTurn){

        while(seedsInHouse > 0){
            currentHouse++;
            
            if(currentHouse == KalahConstants.numberOfHouses){ 
                addSeedToStore(playerTurn);
            } 
            else { 
                addSeedToHouse(playerTurn);
            }            
            
        }
    }
    
    public void addSeedToStore(boolean playerTurn){
        currentHouse = firstHouse;
                
        if(endingPlayerTurn == playerTurn && seedsInHouse > 0){ 

            if(playerTurn){ // player 2
                this.player2Store.incrementSeeds();
            } else { // player 1 
                this.player1Store.incrementSeeds();
            }
            
            seedsInHouse--; 

            if(seedsInHouse == 0){ 
                currentHouse = KalahConstants.emptyHouse;
            }
            
        }
        endingPlayerTurn = !endingPlayerTurn;
    }
    
    public void addSeedToHouse(boolean playerTurn){
        
        if(endingPlayerTurn){ // player 2
            this.player2Houses[currentHouse].incrementSeeds();
        } else { // player 1
            this.player1Houses[currentHouse].incrementSeeds();
        }
        seedsInHouse--; 
        
    }
    
        // update display values with backend stored values
    public int[] parseValues(){ 
        
        values[0] = this.player1Store.getSeeds();
        values[1] = this.player2Store.getSeeds();
        
        for(int i = 0; i < KalahConstants.numberOfHouses; i++){
            values[2+i] = this.player1Houses[i].getSeeds();
            values[8+i] = this.player2Houses[i].getSeeds();
        }
        
        return values;
        
    }
    
    // check if one side has been cleared - graceful end
    public boolean checkGameStatus(boolean playerTurn){ 
        
        boolean checkEndGameRule = GameRules.endGameRuleCheck(playerTurn, player1Houses, player2Houses);
        
        return checkEndGameRule;
        
    }
    
    public int captureCheck(boolean playerTurn){ 
        int seedsInOppositeHouse;
        
        if(currentHouse == KalahConstants.emptyHouse){
            return 1; 
        }
        
        boolean checkCaptureCheckRule = GameRules.captureRuleCheck(playerTurn, endingPlayerTurn, this.player1Houses, this.player2Houses, currentHouse);
        
        if(checkCaptureCheckRule){
            if(endingPlayerTurn){ // ends on player 2 side

                if(playerTurn){ // was originally player 2 turn
                    
                    seedsInOppositeHouse = this.player1Houses[(KalahConstants.numberOfHouses-1) - currentHouse].getSeeds();
                    this.player2Store.add(seedsInOppositeHouse+1);
                    this.player2Houses[currentHouse].setSeeds(0); // sets current house to 0
                    this.player1Houses[(KalahConstants.numberOfHouses-1) - currentHouse].setSeeds(0); // sets opposite house to 0 seeds
                    return 2; // next players turn
                    
                }
            } 
            else { // ends on player 1 side

                if(!playerTurn){ // was originally player 1 turn
                    
                    seedsInOppositeHouse = this.player2Houses[(KalahConstants.numberOfHouses-1) - currentHouse].getSeeds();
                    this.player1Store.add(seedsInOppositeHouse+1);
                    this.player1Houses[currentHouse].setSeeds(0); // sets current house to 0
                    this.player2Houses[(KalahConstants.numberOfHouses-1) - currentHouse].setSeeds(0); // sets opposite house to 0 seeds
                    return 2; // next players turn
                   
                }
            }
        }
        return 2; 
    }
  
}
