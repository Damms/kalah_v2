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
public class TurnManager {
    boolean playerTurn = false; // false = player1, true = player2
    
    public boolean getPlayerTurn(){ 
        return this.playerTurn;
    }
    
    public void nextPlayerTurn(){ 
        this.playerTurn = !this.playerTurn;
    }
    
}
