/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class RollerCoaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");
        
        String keepRiding = "y";
        int loopsLooped = 0;
        //while(keepRiding.equals("y")){
        while(keepRiding.equals("n")){
            System.out.println("WHEEEEEEEEEEeeeEEEEEEeeee.....!!!!");
            System.out.print("Want to keep going? (y/n): ");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }
        
        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped +" times!!");
    }
    
}

//If you change the while condition to no, the loop will never trigger because
//the condition is never true to begin with, so you loop 0 rttimes.
//There is no int in front of loopsLooped when we give it value
//because we have already declared it. If we were to redeclare it, we would end up with a new
//instance of loopsLooped every time the code loops