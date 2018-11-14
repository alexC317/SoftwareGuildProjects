/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doggenetics;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class DogGenetics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variable declaration
        int percentage = 0;
        int currentPercent = 0;
        int counter = 0;
        String dogName;
        
        //Special objects declatation
        Scanner input = new Scanner(System.in);
        
        //Program introduction and takes in the dog's name
        System.out.println("Welcome to our pedigree scanner!");
        System.out.print("First, I'll need your dog's name: ");
        dogName = input.nextLine();
        
        System.out.println("Thanks! Now pulling up " + dogName + "'s results..." );
        System.out.println("");
        System.out.println("Alright, looks like " + dogName + " is : ");
        System.out.println("");
        
        //Loops until the genetic makeup for the five breeds is calculated and displayed
        do {
            //Calls the percentage function until we've gone through the five breeds
            percentage = displayDNA(counter, percentage);
            counter++;
        } while (counter < 5);
        
        //Reminder that they're all good dogs, Brent
        System.out.println("No matter the genetic makeup, " + dogName + " is 100% a good dog!");
    }
    
    //Method that takes in where the loop's count is as well as total genetic percentage decoded and calculates
    //the DNA of each breed and displays it
    public static int displayDNA(int counter, int percentage){
        int currentPercent;
        Random r = new Random();
        switch(counter){
                case 0:
                    currentPercent = r.nextInt(101-percentage);
                    percentage += currentPercent;
                    System.out.println(currentPercent + "% Alaskan Malamute");
                    //System.out.println(percentage + " calculated");
                    return percentage;
                case 1:
                    currentPercent = r.nextInt(101-percentage);
                    percentage += currentPercent;
                    System.out.println(currentPercent + "% Pomeranian");
                    //System.out.println(percentage + " calculated");
                    return percentage;
                case 2:
                    currentPercent = r.nextInt(101-percentage);
                    percentage += currentPercent;
                    System.out.println(currentPercent + "% Shiba Inu");
                    //System.out.println(percentage + " calculated");
                    return percentage;
                case 3:
                    currentPercent = r.nextInt(101-percentage);
                    percentage += currentPercent;
                    System.out.println(currentPercent + "% Welsh Corgi");
                    //System.out.println(percentage + " calculated");
                    break;
                case 4:
                    currentPercent = 100-percentage;
                    percentage += currentPercent;
                    System.out.println(currentPercent + "% German Shepherd");
                    //System.out.println(percentage + " calculated");
                    return percentage;
            }
        
        return percentage;
    }
}
