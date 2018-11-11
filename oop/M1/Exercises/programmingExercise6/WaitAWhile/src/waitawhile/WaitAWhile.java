/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waitawhile;

/**
 *
 * @author Alex
 */
public class WaitAWhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int timeNow = 5;
        int bedTime = 10;
        
        while(timeNow < bedTime){
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiiittle longer....");
            timeNow++;
        }
        
        System.out.println("Oh. It's " +timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
    
}

//If you change bedTime's value to 11, the loop would continue until it got up to 11 o'clock.
//If you kept bedTime's original value, but made timeNow 11, the loop would never run because
//the condition would not be true.
//If you remove timeNow++ at the end of the loop, you would enter an infinite loop.
