/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bewarethekraken;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class BewareTheKraken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random fish = new Random();
        int choice;
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooooOOOooOOOoooo.....! *SPLASH*");
        
        int depthDivedInFt = 0;
        
        // Turns out the ocean is only soi deep, 36200 at the deepest survey,
        // so if we reach the bottom...we should probably stop
        
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            
            System.out.print("Do you want to stop? (y/n): ");
            if(input.nextLine().equals("y")){
                System.out.println("Okay, back up we go!");
                break;
            }
            
            if(depthDivedInFt >= 20000){
                System.out.println("Uhh, I think I see a Kraken, guys....");
                System.out.println("TIME TO GO!");
                break;
            }
            
           choice = fish.nextInt(3);
            
            if(choice == 0)
            {System.out.println("You see a manta ray!");}
            else if(choice == 1)
            {System.out.println("You see a swordfish!");}
            else if(choice == 2)
            {System.out.println("You see an eel!");}
            
            // I can swim, really fast, 500ft at a time
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I think we can do better next time!");
    }
    
}

//If you change the while's condition to read true, it'll keep looping until it reaches 20000.