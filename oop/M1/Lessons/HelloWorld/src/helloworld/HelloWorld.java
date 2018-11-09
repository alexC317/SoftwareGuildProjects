/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    
      public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Hello World, My name is Randall");
        String myHero = "Goku";
        int lvl = 0;
        int maxHP = r.nextInt(50-1)+1;
        int currentHP = maxHP;
        
       
        System.out.println("What is your name Hero?");
        myHero = myScanner.nextLine();
        
        System.out.println("Your hero name is: " + myHero);
        System.out.println(currentHP + "/" + maxHP);
        
        
        int numSteps = 0;
        int numFloors = 0;
        int gold = 10;
        while(currentHP > 0){
            // Play the game
            for (int i = 0; i < 10; i++) {
                numSteps++;
                if(r.nextBoolean()){
                    System.out.println("You've encounter a goblin");
                    currentHP -= 2;
                    if(currentHP <= 0){
                        break;
                    }
                    gold+=3;
                }
            }
            if( currentHP > 0 && numSteps % 10 == 0){
       
                System.out.println("You've cleared " + ++numFloors);
             
            }
        }
        System.out.println("You have Died!");
        System.out.println("You've reached floor " + numFloors);
        System.out.println("You've taken " + numSteps + "steps");
        

    }
      
      public static String PromptUser(String message){
          String result = "";
          
          return result;
      }
}
