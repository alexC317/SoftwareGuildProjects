/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleCalculator;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class App {
    
    public static void main(String[] args){
        SimpleCalculator s = new SimpleCalculator();
        Scanner input = new Scanner(System.in);
        
        int control;
        int result;
        int num1;
        int num2;
        boolean quit = false;
        
        System.out.println("Welcome to the Simple Calculator!");
        do{
            System.out.println("Here are your options: ");
            System.out.println("1. Add 2 numbers.");
            System.out.println("2. Subtract 2 numbers.");
            System.out.println("3. Multiply 2 numbers.");
            System.out.println("4. Divide 2 numbers.");
            System.out.println("5. Quit the program.");
            System.out.print("Please enter your choice: ");
            
            control = input.nextInt();
            input.nextLine();
            
            switch(control){
                case 1:
                    System.out.print("Please enter the first number: ");
                    num1 = input.nextInt();
                    input.nextLine();
                    System.out.print("Please enter the second number: ");
                    num2 = input.nextInt();
                    input.nextLine();
                    result = s.add(num1, num2);
                    System.out.println("Your result is " + result + ".");
                    break;
                case 2:
                    System.out.print("Please enter the first number: ");
                    num1 = input.nextInt();
                    input.nextLine();
                    System.out.print("Please enter the second number: ");
                    num2 = input.nextInt();
                    input.nextLine();
                    result = s.subtract(num1, num2);
                    System.out.println("Your result is " + result + ".");
                    break;
                case 3:
                    System.out.print("Please enter the first number: ");
                    num1 = input.nextInt();
                    input.nextLine();
                    System.out.print("Please enter the second number: ");
                    num2 = input.nextInt();
                    input.nextLine();
                    result = s.multiply(num1, num2);
                    System.out.println("Your result is " + result + ".");
                    break;
                case 4:
                    System.out.print("Please enter the first number: ");
                    num1 = input.nextInt();
                    input.nextLine();
                    System.out.print("Please enter the second number: ");
                    num2 = input.nextInt();
                    input.nextLine();
                    result = s.divide(num1, num2);
                    System.out.println("Your result is " + result + ".");
                    break;
                case 5:
                    quit = true;
            }
            
            System.out.println(" ***** ");
        }while(!quit);
        
        System.out.println("Thanks for using me!");
        
    }
}
