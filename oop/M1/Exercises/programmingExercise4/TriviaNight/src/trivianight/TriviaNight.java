/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivianight;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class TriviaNight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int answer1;
        int answer2;
        int answer3;
        
        int correctAnswers = 0;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Welcome to Trivia Niiiiiiiiiiiiiiiiight! I'm gonna ask a few questions.");
        System.out.println("After the question shows up, type the /number/ of the answer.");
        System.out.println("Once all the answers are submitted, you'll know what you got right!");
        System.out.println("");
        System.out.println("Question 1!");
        System.out.println("In Dungeons and Dragons, what is the correct notation for rolling 3 six-sided dice?");
        System.out.println("1. 6d3                    2. 3^6d");
        System.out.println("3. 3d6                    4. 18m6");
        
        System.out.println("");
        System.out.print("Your answer: ");
        answer1 = myScanner.nextInt();
        
        if(answer1 == 3)
        {correctAnswers++;}
        
        System.out.println("");
        System.out.println("Question 2!");
        System.out.println("What is the average median earning for a web developer in NYC?");
        System.out.println("1. $10,000                    2. $50,000");
        System.out.println("3. $10,0000                   4. $30,000");
        
        System.out.println("");
        System.out.print("Your answer: ");
        answer2 = myScanner.nextInt();
        
        if(answer2 == 2)
        {correctAnswers++;}
        
        System.out.println("");
        System.out.println("Question 3! It's the last one!");
        System.out.println("What type of bass guitar does Haruko use in the FLCL series?");
        System.out.println("1. Rickenbacker 4001                    2. Gibson EB-0");
        System.out.println("2. Les Paul Custom                      3. Flying V");
        
        System.out.println("");
        System.out.print("Your answer: ");
        answer3 = myScanner.nextInt();
        
        if(answer3 == 1)
        {correctAnswers++;}
        
        if(correctAnswers == 0)
        {System.out.println("Might wanna google some stuff, you got nothing right, chief.");}
        else if(correctAnswers == 3)
        {System.out.println("Congrats, you got everything right!");}
        else
        {System.out.println("Nice, you got " + correctAnswers + " right!");}
        
    }
    
}
