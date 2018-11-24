/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class LuckySevens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        
        int startingAmount;
        int money;
        int highestAmount;
        int dice1;
        int dice2;
        int rollSum;
        int rollCounter = 0;
        int highestRoll = 0;
        
        System.out.print("How many dollars do you have? ");
        startingAmount = input.nextInt();
        input.nextLine();
        
        money = startingAmount;
        highestAmount = startingAmount;
        
        do{
            dice1 = r.nextInt(6)+1;
            dice2 = r.nextInt(6)+1;
            if(dice1+dice2 == 7){
                money += 4;
            }
            else{
                money -= 1;
            }
            
            if(money > highestAmount){
                highestAmount = money;
                highestRoll = rollCounter;
            }
            rollCounter++;
        }while(money > 0);
        
        System.out.println("You are broke after " + rollCounter + " rolls.");
        System.out.println("You should have quit after " + highestRoll + " rolls when you had $" + highestAmount + ".");
    }
    
}
