/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyhearts;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class HealthyHearts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variable declarations
        int userAge = 0;
        int maxHR;
        int minTarget;
        int maxTarget;
        boolean validInput = false;
        
        //Special Objects declaration
        Scanner input = new Scanner(System.in);
        
        while(!validInput){
            System.out.print("What is your age? ");
            if(!input.hasNextInt()){
                System.out.println("That's not a valid number, please try again.");
            }
            else{
                userAge = input.nextInt();
                validInput = true;
            }
        }
        
        maxHR = 220 - userAge;
        minTarget = (int)Math.round(maxHR * .5);
        maxTarget = (int)Math.round(maxHR * .85);
        System.out.println("Your maximum heart rate should be " + maxHR + " beats per minute.");
        System.out.println("Your target HR Zone is " + minTarget + " - " + maxTarget +" beats per minute.");
        
    }
    
}
