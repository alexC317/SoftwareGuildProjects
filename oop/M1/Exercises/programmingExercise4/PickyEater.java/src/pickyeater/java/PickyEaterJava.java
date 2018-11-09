/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickyeater.java;

import java.util.Scanner;
/**
 *
 * @author Alex
 */
public class PickyEaterJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("How many times has it been fried? (#) ");
        int timesFried =  userInput.nextInt();
        
        System.out.print("Does it have any spinach in it? (y/n) ");
        String hasSpinach = userInput.next();
        
        System.out.print("Is it covered in cheese? (y/n) ");
        String cheeseCovered = userInput.next();
        
        System.out.print("How many pats of butter are on top? (#) ");
        int butterPats = userInput.nextInt();
        
        System.out.print("Is it covered in chocolate? (y/n) ");
        String chocolateCovered = userInput.next();
        
        System.out.print("Does it have a funny name? (y/n) ");
        String funnyName = userInput.next();
        
        System.out.print("Is it broccoli? ");
        String isBroccoli = userInput.next();
        
        if(hasSpinach.equals("y") || funnyName.equals("y"))
        {System.out.println("There's no way that'll get eaten.");}
        else if((2 < timesFried && timesFried < 4) && (chocolateCovered.equals("y")))
        {System.out.println("Oh, it's like a deep-fried Snickers. That'll be a hit!");}
        else if(timesFried == 2 && cheeseCovered.equals("y"))
        {System.out.println("Mmm. Yeah, fried cheesy doodles will get eaten.");}
        else if(isBroccoli.equals("y") && butterPats > 6 && cheeseCovered.equals("y"))
        {System.out.println("As long as the green is hidden by the cheddar, it'll happen!");}
        else if(isBroccoli.equals("y"))
        {System.out.println("Oh, green stuff like that might as well go in the bin.");}
        
    }
    
}
