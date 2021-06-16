
package com.studiofarmaexercise;

/**
 *
 * @author User
 */
public class Main {

    /**
     * The Main method of the class Main
     * @param args - arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.startGame();
            do {
                game.makeGameMove();
                game.printDebugInfo();
            } while (game.isNotOverYet());
            game.endGame();
        } catch (Exception Exp) {
            IOStream.printOnConsole("Exception on main Thread");
            IOStream.printOnConsole(Exp.toString());
            System.exit(-1);
        }
    }
    
}
