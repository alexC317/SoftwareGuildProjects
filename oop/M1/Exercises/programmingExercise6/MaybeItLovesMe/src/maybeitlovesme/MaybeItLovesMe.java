/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybeitlovesme;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class MaybeItLovesMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        int petals = r.nextInt(77)+13;
        int loopCounter = 0;
        
        while(petals>0)
        {
            if(loopCounter%2 == 0)
            {System.out.println("It loves me NOT!");}
            else
            {System.out.println("It LOVES me!");}
            petals--;
            loopCounter++;
        }
        
        if(loopCounter%2 == 1)
        {System.out.println("Awwww, bummer.");}
        else
        {System.out.println("Oh, wow! It really LOVES ME!");}
    }
    
}
