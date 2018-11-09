/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alittlechaos;
import java.util.Random;
/**
 *
 * @author Alex
 */
public class ALittleChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(50) + 50;
        
        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);
        
        System.out.println("Or just keep generating new values.");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");
        
        System.out.print(randomizer.nextInt(3) + ", ");
        System.out.print(randomizer.nextInt(17) + ", ");
        System.out.print(randomizer.nextInt(317) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));
        
        //If you change nextInt(101) to nextInt(50) + 50, it will create a random number from 0 to 50
        //then offset it by 50
    }
    
}
