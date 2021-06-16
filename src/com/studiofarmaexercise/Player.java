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
public class Player {
    private String name;

    protected Player(String name) {
        this.name = name;
    }
    protected String getName() {
        return this.name;
    }
}
