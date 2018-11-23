/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizor;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Factorizor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userNum;
        int temp = 0;
        int sum = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("What number would you like to factor? ");
        userNum = input.nextInt();
        System.out.println("The factors of " + userNum +  " are: ");
        
        for(int i = 1; i < userNum; i++){
            if(userNum%i == 0){
                System.out.println(i);
                temp = i;
                sum += i;
            }
        }
        
        if(sum == userNum){
            System.out.println(userNum + " is a perfect number.");
        }
        else{
            System.out.println(userNum + " is not a perfect number.");
        }
        
        if(temp == 1){
            System.out.println(userNum + " is a prime number.");
        }
        else{
            System.out.println(userNum + " is not a prime number.");
        }
        
    }
    
}
