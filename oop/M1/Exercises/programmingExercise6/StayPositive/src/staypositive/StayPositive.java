/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staypositive;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class StayPositive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int startNum;
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("What number should I count down from? ");
        startNum = userInput.nextInt();
        System.out.println("Let's goooooo!");
        
        int lineNum  = 9;
        while(startNum >= 0){
            
            if(lineNum > 0){
                System.out.print(startNum + " ");
                
                startNum--;
                lineNum--;
            }
            else if(lineNum == 0 && startNum >= 0){
                System.out.println(startNum + " ");
                
                startNum--;
                lineNum = 9;
            }
        }
        System.out.println("");
        System.out.println("Okay, we're done!");
    }
    
}
