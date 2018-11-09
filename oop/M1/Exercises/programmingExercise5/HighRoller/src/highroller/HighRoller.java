/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highroller;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class HighRoller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random diceRoller = new Random();
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("How many sides does your dice have? ");
        int diceSides = Integer.parseInt(userInput.nextLine());
        
        int rollResult = diceRoller.nextInt(diceSides)+1;
        
        System.out.println("TIME TO ROOOOOOOLLLL THE DICE!");
        System.out.println("I rolled a " + rollResult + ".");
        
        if(rollResult == 1)
        {System.out.println("You rolled a crit failure! Ouch.");}
        else if(rollResult == diceSides)
        {System.out.println("You rolled a critical! Nice Job!");}
    }
    
}
