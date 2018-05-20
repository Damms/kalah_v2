package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;


/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */

public class Kalah {
    
    public static void main(String[] args) {           
            new Kalah().play(new MockIO());
    }

    public void play(IO io) {
        
        House[] player1Houses = new House[KalahConstants.numberOfHouses];
        House[] player2Houses = new House[KalahConstants.numberOfHouses];
        Store player1 = new Store(KalahConstants.initSeedsInStore);
        Store player2 = new Store(KalahConstants.initSeedsInStore);

        // init buildings      
        for(int i = 0; i < 6; i++){
            player1Houses[i] = new House(KalahConstants.seedsInHouse); 
            player2Houses[i] = new House(KalahConstants.seedsInHouse); 
        }
        
        // create game components
        BoardManager moveManager = new BoardManager(player1Houses, player2Houses, player1, player2); // create new game
        GameController gameController = new GameController();
        InputManager inManager = new InputManager(io);
        OutputManager outManager = new OutputManager(io);
        
        // start game   
        gameController.start(moveManager, inManager, outManager);

    }
        
}
