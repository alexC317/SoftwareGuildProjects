/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacerustlers;

/**
 *
 * @author Alex
 */
public class SpaceRustlers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        
        if(aliens > spaceships)
        {System.out.println("Vroom, vroom! Let's get going!");} 
        else
        {System.out.println("There aren't enough green guys to drive these ships!");}
        
        if(cows == spaceships)
        {System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");}
        else if(cows > spaceships)
        {System.out.println("Dangit! I don't know how we're going to fit all these cows in here!");}
        else
        {System.out.println("Too many ships! Not enough cows.");}
        
        if(aliens > cows)
        {System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");}
        else
        {System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!");}
        
        //The if blocks will decide if a certain condition is true, and then output
        //something to the console depending on the result.
        //The else if adds another condition to be tested in order to have more branching paths
        
        //If you remove the else if block, the code as written will jump to the else block (and giventhe current values, be kind of a wrong statement
    }
}
