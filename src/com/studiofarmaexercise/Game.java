package com.studiofarmaexercise;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> possibleMoves = new ArrayList<Integer>();
    private int pizzasNumber;
    private int playersNumber;
    private int turnCounter;
    private Player[] players;
    private Player actualPlayer;
    private List<Integer> listOfMoves = new ArrayList<Integer>();


    public Game() {
        // pizzasNumber = 10 + (int)(Math.random()*10);
        possibleMoves.add(1);
        possibleMoves.add(2);
        possibleMoves.add(3);
        pizzasNumber = 12;
        playersNumber = 2;
        players = new Player[playersNumber];
        actualPlayer = null;
        turnCounter = 0;
    }



    private void getPlayersName() {
        IOStream.printOnConsole("Benvenuto!");
        for(int i=0; i < playersNumber; i++) {
            String name = "";

            IOStream.printOnConsole("Inserisci il nome del giocatore " + (i+1));
            name = IOStream.getString();
            players[i] = new Player(name);
        }
    }

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

    protected void startGame() {
        this.getPlayersName();
        actualPlayer = players[0];
    }
    protected void endGame() {
        IOStream.printOnConsole(actualPlayer.getName() + " si mangerà la pizza avvelenata!");
        IOStream.printOnConsole("Al turno: " + this.turnCounter );
        actualPlayer = players[0];
    }
    protected void makeGameMove() {
        int actualMove;
        String actualMoveString;

        if (turnCounter > 0 && this.isSkipTurnForPlayer()) {
            listOfMoves.add(null);
            turnCounter++;
            actualPlayer = players[turnCounter % playersNumber];
            IOStream.printOnConsole("Giocatore " + actualPlayer.getName() + " turno skippato?");
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

    private boolean isSkipTurnForPlayer() {
        if (this.pizzasNumber == listOfMoves.get(listOfMoves.size() - 1)) {
            return true;
        }
        return false;
    }
    protected boolean isNotOverYet() {
        if(pizzasNumber == 0 || listOfMoves.get(listOfMoves.size() - 1) == null) {
            return false;
        }
        return true;
    }
    protected void printDebugInfo() {
        IOStream.printOnConsole("Mosse precedenti: ");
        IOStream.printOnConsole(this.listOfMoves.toString());
        IOStream.printOnConsole("Sono rimaste pizze numero: -> " + this.pizzasNumber);
    }
}
