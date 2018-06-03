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

public class InputManager implements KalahBoardInput {
    
    IO io;
    
    public InputManager(IO io) {
        this.io = io;
    }
     
    
    @Override
    public String getUserSelectedHouse(boolean playerTurn) {
       String userInput;
       
       if(playerTurn){
            return userInput = io.readFromKeyboard(KalahConstants.player2InputText);
        } else {
            return userInput = io.readFromKeyboard(KalahConstants.player1InputText);
        }
    }
    
}
