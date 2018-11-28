/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleCalculator;

import UserIO.UserIO;
import UserIO.UserIOImpl;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class App {
    
    public static void main(String[] args){
        SimpleCalculator s = new SimpleCalculator();
        Scanner input = new Scanner(System.in);
        UserIOImpl io = new UserIOImpl();
        
        int control;
        int result;
        int num1;
        int num2;
        boolean quit = false;
        
        io.print("Welcome to the Simple Calculator!");
        do{
            io.print("Here are your options: ");
            io.print("1. Add 2 numbers.");
            io.print("2. Subtract 2 numbers.");
            io.print("3. Multiply 2 numbers.");
            io.print("4. Divide 2 numbers.");
            io.print("5. Quit the program.");
            io.print("Please enter your choice: ");
            
            control = input.nextInt();
            input.nextLine();
            
            switch(control){
                case 1:
                    num1 = io.readInt("Please enter the first number: ");
                    num2 = io.readInt("Please enter the second number: ");
                    result = s.add(num1, num2);
                    io.print("Your result is " + result + ".");
                    break;
                case 2:
                    num1 = io.readInt("Please enter the first number: ");
                    num2 = io.readInt("Please enter the second number: ");
                    result = s.subtract(num1, num2);
                    io.print("Your result is " + result + ".");
                    break;
                case 3:
                    num1 = io.readInt("Please enter the first number: ");
                    num2 = io.readInt("Please enter the second number: ");
                    result = s.multiply(num1, num2);
                    io.print("Your result is " + result + ".");
                    break;
                case 4:
                    num1 = io.readInt("Please enter the first number: ");
                    num2 = io.readInt("Please enter the second number: ");
                    result = s.divide(num1, num2);
                    io.print("Your result is " + result + ".");
                    break;
                case 5:
                    quit = true;
            }
            
            io.print(" ***** ");
        }while(!quit);
        
        io.print("Thanks for using me!");
        
    }
}
