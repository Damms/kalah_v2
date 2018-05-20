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

public class GameController {
   
    String keyBoard = "1";
    boolean playerTurn = false; // false = player1, true = player2
    boolean gameOver = false;
    boolean quit = false;
    int turnManager = 2; // 0 = empty house, 1 = anotherTurn, 2 = nextPlayerTurn
    int selectedHouse = 0;
    int[] gameValues = new int[(KalahConstants.numberOfHouses*2) + KalahConstants.numberOfPlayers];
     
        
    public void start(BoardManager game, InputManager inIO, OutputManager outIO){ 
        
        while(!gameOver){

            // update the backend gameboard and check status of the game
            gameValues = game.parseValues();
            gameOver = game.checkGameStatus(playerTurn); 

            outIO.printBoard(gameValues);
            manageUserInput(inIO);                   

            if(gameOver){

                outIO.printEndGame(gameValues);

                if(!quit){ 

                    outIO.printPlayerScore(gameValues);

                }
            } else { // move seeds if the game isn't over and change user turns

                turnManager = game.moveSeeds(selectedHouse, playerTurn);
                updateCurrentPlayerTurn(outIO);
                
            } 
        }
    }    
    
    
    public void manageUserInput(InputManager io){ 
        
        if(!gameOver){
            keyBoard = io.getUserSelectedHouse(playerTurn);
        }

        if("q".equals(keyBoard)){
            
            gameOver = true;
            quit = true;
            
        } else {
            
            selectedHouse = Integer.parseInt(keyBoard) - 1;
            
        }       
    }
    
    public void updateCurrentPlayerTurn(OutputManager io){
        
        if(turnManager == 2){ // next player turn
            
            playerTurn = !playerTurn;
            
        } else if (turnManager == 0){ // selected empty house
            
            io.printEmptyHouse(); 
            turnManager = 1;
            
        }
    }
    
}
