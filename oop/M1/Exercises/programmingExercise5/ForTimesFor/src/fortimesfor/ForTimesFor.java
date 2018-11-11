/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortimesfor;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class ForTimesFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int testNum;
        int userNum;
        int correctNum = 0;
        
        System.out.print("Which times table shall I recite? ");
        testNum = userInput.nextInt();
        
        for(int i = 1; i < 16; i++){
            System.out.print(i + " * " + testNum + " is: ");
            userNum = userInput.nextInt();
            
            if(userNum == (i*testNum)){
                System.out.println("Correct!");
                correctNum++;
            }
            else{
                System.out.println("Sorry, the correct answer is: " + (i*testNum));
            }
        
        }
        
        if(correctNum < 7)
        {System.out.println("You only got " + correctNum + " right. You should study more.");}
        else if(correctNum > 13)
        {System.out.println("Wow! You got " + correctNum + " right! You're amazing!");}
        else
        {System.out.println("You got " + correctNum + " right!");
        
        }
    }
    
}
