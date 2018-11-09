/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortunecookie;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class FortuneCookie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random saying = new Random();
        int choice = saying.nextInt(10)+1;
        
        System.out.print("Your Geek Fortune: ");
        if(choice == 1)
        {System.out.println("These aren't the droids you're looking for.");}
        else if(choice == 2)
        {System.out.println("Never go in against a Sicilian when death is on the line!");}
        else if(choice == 3)
        {System.out.println("Goonies never say die.");}
        else if(choice == 4)
        {System.out.println("With great power, there must also come -- great responsibility");}
        else if(choice == 5)
        {System.out.println("Never argue with the data.");}
        else if(choice == 6)
        {System.out.println("Try not. Do, or do not. There is no try.");}
        else if(choice == 7)
        {System.out.println("You are a leaf on the wind; watch how you soar.");}
        else if(choice == 8)
        {System.out.println("Do absolutely nothing, and it will be everything that you thought it could be.");}
        else if(choice == 9)
        {System.out.println("Kneel before Zod.");}
        else if(choice == 10)
        {System.out.println("Make it so.");}
    }
    
}
