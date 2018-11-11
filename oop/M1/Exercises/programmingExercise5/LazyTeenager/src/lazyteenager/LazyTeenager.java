/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyteenager;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class LazyTeenager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random chance = new Random();
        int chanceCount = 0;
        int probability = 0;
        int patience = 15;
        int chan;
        
        do{
            chanceCount++;
            System.out.println("Clean your room!! (x"+chanceCount+")");
            probability += 5;
            
            if(probability > chance.nextInt(101)){
                System.out.println("Good, you're finally cleaning it up.");
                break;
            }
            
            patience--;
            if(patience == 0){            
                System.out.println("THAT'S IT! I'M DOING IT!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
        }while(patience > 0);
        
    }
    
}
