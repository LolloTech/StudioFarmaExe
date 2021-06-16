/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studiofarmaexercise;

import java.util.Scanner;

/**
 *
 * @author User
 */

/**
 * This class purpose is to be a single access point for all the operations of:
 * - Print a screen on the console;
 * - Get a string from the console.
 * It exposes static methods, so it does not need to be instantiated.
 */
public class IOStream {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Print something on the console
     * @param stringToPrint - The strint that is has to be printed
     */
    public static void printOnConsole(String stringToPrint) {
        System.out.println(stringToPrint);
    }

    /**
     * It reads a string line, from the console
     * @return String - the read string from the console
     */
    public static String getString() {
        // Important: it is not syncronized!
        String read = "";
        
        if(in.hasNextLine()) {
            read = IOStream.in.nextLine();
        }
        return read;
    }
    
}
