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
    boolean gameOver = false;
    boolean quit = false;
    int turnStatus = 2; // 0 = empty house, 1 = anotherTurn, 2 = nextPlayerTurn
    int selectedHouse = 0;
    int[] gameValues = new int[(KalahConstants.numberOfHouses*2) + KalahConstants.numberOfPlayers];
    
    BoardManager game;
    TurnManager turnManager;
    InputManager inIO;
    OutputManager outIO;
    
    public GameController(BoardManager game, TurnManager turnManager, InputManager inIO, OutputManager outIO){
        this.game = game;
        this.turnManager = turnManager;
        this.inIO = inIO;
        this.outIO = outIO;
    }
     
        
    public void start(){ 
        
        while(!gameOver){

            // update the backend gameboard and check status of the game
            gameValues = game.parseValues();
            gameOver = game.checkGameStatus(turnManager.getPlayerTurn()); 

            outIO.printBoard(gameValues);
            manageUserInput();                   

            if(gameOver){

                outIO.printEndGame(gameValues);

                if(!quit){ 

                    outIO.printPlayerScore(gameValues);

                }
            } else { // move seeds if the game isn't over and change user turns

                turnStatus = game.moveSeeds(selectedHouse, turnManager.getPlayerTurn());
                updateCurrentPlayerTurn();
                
            } 
        }
    }    
    
    
    public void manageUserInput(){ 
        
        if(!gameOver){
            keyBoard = inIO.getUserSelectedHouse(turnManager.getPlayerTurn());
        }

        if("q".equals(keyBoard)){
            
            gameOver = true;
            quit = true;
            
        } else {
            
            selectedHouse = Integer.parseInt(keyBoard) - 1;
            
        }       
    }
    
    public void updateCurrentPlayerTurn(){
        
        if(turnStatus == 2){ // next player turn
            
            turnManager.nextPlayerTurn();
            
        } else if (turnStatus == 0){ // selected empty house
            
            outIO.printEmptyHouse(); 
            turnStatus = 1;
            
        }
    }
    
}
