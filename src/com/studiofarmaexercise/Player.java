/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studiofarmaexercise;

/**
 *
 * @author User
 */

/**
 * This class purpose is to represent a player of the game, implemented by this program.
 */
public class Player {
    private String name;

    protected Player(String name) {
        this.name = name;
    }
    protected String getName() {
        return this.name;
    }
}
