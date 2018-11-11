/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalfizzbuzz;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class TraditionalFizzBuzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userNum;
        int counter = 0;
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("How many units of fizzing and buzzing do you need in your life? ");
        userNum = userInput.nextInt();
        
        for(int i = 0; counter < userNum; i++)
        {
            if(i%3 == 0 && i%5  == 0 && i!=0){
                System.out.println("fizz buzz");
                counter++;
            }
            else if(i%3 == 0 && i!=0){
                System.out.println("fizz ");
                counter++;
            }
            else if(i%5 == 0 && i!=0){
                System.out.println("buzz");
                counter++;
            }
            else
            {System.out.println(i);}
            
        }
        
        System.out.println("TRADITION!!!!!");
    }
    
}
