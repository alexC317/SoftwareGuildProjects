/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biggerbetteradder;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class BiggerBetterAdder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Please input your first number to add: ");
        num1 = myScanner.nextInt();
        
        System.out.print("Please input the second number to add: ");
        num2 = myScanner.nextInt();
        
        System.out.print("Please input the last number to add: ");
        num3 = myScanner.nextInt();
        
        int sum = num1+num2+num3;
        
        System.out.println("Your sum is: " + sum);
        System.out.print("Once more, with clarity, your sum of: " + num1 + ", ");
        System.out.println(num2 + ", " + num3 + " is: " + sum);
    }
    
}
