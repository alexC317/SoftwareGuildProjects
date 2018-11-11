/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmefinally;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class GuessMeFinally {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userNum;
        int matchNum;
        boolean isRight = false;
        
        Scanner userInput = new Scanner(System.in);
        Random selector = new Random();
        
        matchNum = selector.nextInt(201) - 100;
        
        System.out.println("Pick a number between -100 and 100, see if you can match mine!");
        System.out.print("Your guess: ");
        
        userNum = userInput.nextInt();
        
        if(userNum == matchNum){
            System.out.println("Wow, nice guess! That was it!");
            isRight = true;
        }
        
        while(!isRight){
            if(userNum == matchNum){
                System.out.println("Finally, it's about time you got it!");
                isRight = true;
            
            }
            else if(userNum > matchNum) {
                System.out.println("That was too high, but I'll give you another shot.");
                System.out.print("Your guess: ");
            
                userNum = userInput.nextInt();
            }
            
            else if(userNum < matchNum){
                System.out.println("That was too low, but I'll give you another chance.");
                System.out.print("Your guess: ");
            
                userNum = userInput.nextInt();
            }
        }
        
        
        System.out.println("My number was: " + matchNum);
               
        
    }
    
}
