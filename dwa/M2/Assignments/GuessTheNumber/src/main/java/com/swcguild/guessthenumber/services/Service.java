/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.services;

/**
 *
 * @author Alex
 */
public interface Service {

    public String generateRandomNumber();

    public void checkGuess(String guess);
}
