/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinflipper;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class CoinFlipper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random coinFlip = new Random();
        boolean coinResult = coinFlip.nextBoolean();
        
        System.out.println("Let's flip out!");
        if(coinResult == true)
        {System.out.println("You got heads!");}
        else
        {System.out.println("You got tails!");}
        
    }
    
}
