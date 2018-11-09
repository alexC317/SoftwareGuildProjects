/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessme;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class GuessMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int guessNum = 317;
        int userNum;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Please pick a number to guess! ");
        userNum = Integer.parseInt(myScanner.nextLine());
        
        System.out.println("");
        if(guessNum == userNum){
            System.out.println("Wow, nice guess! That was it!");
        }
        else if(guessNum > userNum){
            System.out.println("Ha, nice try - too low! I chose " + guessNum + ".");
        }
        else{
            System.out.println("Too bad, way too high. I chose " + guessNum + ".");
        }
    }
    
}
