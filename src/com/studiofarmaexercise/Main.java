/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studiofarmaexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {


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
