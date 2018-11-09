/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knockknock;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class KnockKnock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock Knock! Guess who!!");
        String nameGuess = inputReader.nextLine();
        
        if(nameGuess == "Marty McFly"){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future.");
        }
        else{
            System.out.println("Dude, do I -look- like " + nameGuess +"?");
        }
    }
    
}
//If you change .equals() to == when comparing strings, it doesn't work as expected.
//If you don't capitalize the right letters, you can make the inputted answer lowercase (using .toLowerCase())
//and then change the "Marty McFly" in the if statement to be all lowercase letters