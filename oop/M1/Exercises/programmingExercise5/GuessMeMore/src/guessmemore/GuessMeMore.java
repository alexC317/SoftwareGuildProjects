/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmemore;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Alex
 */
public class GuessMeMore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userNum;
        int matchNum;
        
        Scanner userInput = new Scanner(System.in);
        Random selector = new Random();
        
        matchNum = selector.nextInt(201) - 100;
        
        System.out.println("Pick a number between -100 and 100, see if you can match mine!");
        System.out.print("Your guess: ");
        
        userNum = userInput.nextInt();
        
        if(userNum == matchNum)
        {System.out.println("Alright, you guessed my number!");}
        else{
            System.out.println("That wasn't it but, I'll give you another chance.");
            System.out.print("Your guess: ");
            
            userNum = userInput.nextInt();
            
            if(userNum == matchNum)
            {System.out.println("Nice, you got it this time!");}
            else
            {System.out.println("Sorry, no dice this time either.");}
        }
        
        System.out.println("My number was: " + matchNum);
               
        
    }

    
}
