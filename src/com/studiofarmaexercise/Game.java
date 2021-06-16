package com.studiofarmaexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * This class purpose is to have the responsibility of holding all the game's detailed info and it contains the
 * business logic of the game implemented by this standalone application
 * @author User
 */
public class Game {
    private List<Integer> possibleMoves = new ArrayList<Integer>();
    private int pizzasNumber;
    private int playersNumber;
    private int turnCounter;
    private Player[] players;
    private Player actualPlayer;
    private List<Integer> listOfMoves = new ArrayList<Integer>();


    public Game() {
        pizzasNumber = 10 + (int)(Math.random()*10);
        possibleMoves.add(1);
        possibleMoves.add(2);
        possibleMoves.add(3);
        playersNumber = 2;
        players = new Player[playersNumber];
        actualPlayer = null;
        turnCounter = 0;
    }


    /**
     * This method purpose is to get the players name as info from the console
     */

    private void getPlayersName() {
        IOStream.printOnConsole("Benvenuto!");
        for(int i=0; i < playersNumber; i++) {
            String name = "";

            IOStream.printOnConsole("Inserisci il nome del giocatore " + (i+1));
            name = IOStream.getString();
            players[i] = new Player(name);
        }
    }

    /**
     * This method purpose is to check if it is a VALID move, the move made by the actual player and that it is
     * contained as a parameter "move"
     * @param move - the move made by the actual player
     * @return boolean - it is a valid move or not
     * @throws Exception E - Any Exception that occurs here
     */
    private boolean isAValidMoveForActualPlayer(String move) {
        try {
            int castedMove = Integer.parseInt(move);

            if (!possibleMoves.contains(castedMove)) {
                IOStream.printOnConsole("Mossa rifiutata; Puoi mangiare solo 1 | 2 | 3 pizze !");
                return false;
            }
            else if (listOfMoves.isEmpty() || listOfMoves.get(listOfMoves.size() - 1) != castedMove) {
                return true;
            }
            else {
                return false;
            }
        } catch(Exception E) {
            IOStream.printOnConsole(E.toString());
            return false;
        }
    }

    /**
     * This method has the responsibility of "starting" the game; in our context it means to get the initial info
     * used by this program, and it sets the current player to the first registered player
     */
    protected void startGame() {
        this.getPlayersName();
        actualPlayer = players[0];
    }
    /**
     * This method has the responsibility of "ending" the game; in our context it means to print who will eat the
     * poisoned pizza, and in which turn he/she will eat it
     */
    protected void endGame() {
        IOStream.printOnConsole(actualPlayer.getName() + " si mangerà la pizza avvelenata!");
        IOStream.printOnConsole("Al turno: " + this.turnCounter );
    }

    /**
     * This method has the responsibility of making the players able to make their moves.
     * It will do so checking if the current turn is also to be skipped (because the currant player will be unable to
     * make his/her own move).
     */
    protected void makeGameMove() {
        int actualMove;
        String actualMoveString;

        if (turnCounter > 0 && this.isSkipTurnForPlayer()) {
            listOfMoves.add(null);
            IOStream.printOnConsole("Giocatore " + actualPlayer.getName() + " turno skippato");
            turnCounter++;
            actualPlayer = players[turnCounter % playersNumber];
        }
        else {
            do {
                IOStream.printOnConsole("Giocatore " + actualPlayer.getName() + " quante pizze vuoi mangiare?");
                actualMoveString = IOStream.getString();

            } while (!this.isAValidMoveForActualPlayer(actualMoveString));
            listOfMoves.add(actualMove = Integer.parseInt(actualMoveString));
            pizzasNumber -= actualMove;
            if (pizzasNumber != 0) {
                turnCounter++;
                actualPlayer = players[turnCounter % playersNumber];
            }
        }
    }

    /**
     * This method has the responsibility that consists to verify if the current player has to skip his turn; the player
     * must skip his/her turn if and only if he/she can't make any useful move.
     *
     * The turn must be skipped when the last move made by a player is equal to the number of remaining pizzas.
     * The reason is that, if there are
     * - 3 remaining pizzas, 3 is the last move from player B -> player A will lose either if he/she eats 1 or 2 pizzas
     * - 2 remaining pizzas, 3 is the last move from player B -> player A will lose either if he/she eats 1 or 2 pizzas
     * @return boolean - is the turn to be skipped or not
     */
    private boolean isSkipTurnForPlayer() {
        if (this.pizzasNumber == listOfMoves.get(listOfMoves.size() - 1)) {
            return true;
        }
        return false;
    }

    /**
     * This method purpose is to check if the game has playable or if it has arrived at his final stage.
     * @return boolean - is the game to be ended or not
     */
    protected boolean isNotOverYet() {
        if(pizzasNumber == 0 || listOfMoves.get(listOfMoves.size() - 1) == null) {
            return false;
        }
        return true;
    }

    /**
     * This method is used to print useful debug information.
     */
    protected void printDebugInfo() {
        IOStream.printOnConsole("Mosse precedenti: ");
        IOStream.printOnConsole(this.listOfMoves.toString());
        IOStream.printOnConsole("Sono rimaste : -> " + this.pizzasNumber + " pizze");
    }
}
