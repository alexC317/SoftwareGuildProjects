/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passingtheturingtest;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class PassingTheTuringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userName;
        String AIName = "Cortana";
        String favColor;
        String favFood;
        double favNumber;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Hi! It's nice to meet you, what's your name? ");
        userName = myScanner.nextLine();
        
        System.out.println("Hey, " + userName + ", my name's " + AIName + "! I'm gonna ask some questions!");
        
        System.out.print("First, I wanna know what your favorite color is! ");
        favColor = myScanner.nextLine();
       
        System.out.println(favColor + "? Neat! I like green a lot, reminds me of an old friend.");
        
        System.out.print("I'm an AI, so I don't really have taste buds, but I'm interested to hear in what your favorite food is, " + userName + ": ");
        favFood = myScanner.nextLine();
        
        System.out.println("Wow, " + favFood + " sounds delicious!");
        
        System.out.print("Us AIs love crunching numbers, so give me a favorite number to work with! ");
        favNumber = myScanner.nextDouble();
        
        System.out.println("Nice. So if we take your " + favNumber + " and multiply it by the number of Halo rings...");
        System.out.println("We'll get " + (favNumber * 7));
        
        System.out.println("Well, it was nice talking to you, " + userName + ". I gotta get going back to my time, but maybe we'll meet again!");
    }
    
}
