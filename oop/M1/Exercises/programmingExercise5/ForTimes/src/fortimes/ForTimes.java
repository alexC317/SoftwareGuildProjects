/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortimes;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class ForTimes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int userNum;
        
        System.out.print("Which times table shall I recite? ");
        userNum = userInput.nextInt();
        
        for(int i = 1; i < 16; i++)
        {System.out.println(i + " * " + userNum + " is: " + (i*userNum));}
    }
    
}
