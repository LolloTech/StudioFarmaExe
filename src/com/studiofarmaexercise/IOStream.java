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
public class IOStream {
    private static final Scanner in = new Scanner(System.in);
    
    public static void printOnConsole(String stringToPrint) {
        System.out.println(stringToPrint);
    }
    public static String getString() {
        // Important: it is not syncronized!
        String read = "";
        
        if(in.hasNextLine()) {
            read = IOStream.in.nextLine();
        }
        return read;
    }
    
}
