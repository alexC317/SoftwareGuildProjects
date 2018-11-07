/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doitbetter;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class DoItBetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double miles;
        double myMiles;
        int hotDogs;
        int myHotDogs;
        int languages;
        int myLanguages;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("How many miles can you run? ");
        miles = myScanner.nextDouble();
        myMiles = (miles*2)+1;
        
        System.out.print("Pfft, I can do " + myMiles + " miles easy. How many hot dogs can you eat? ");
        hotDogs = myScanner.nextInt();
        myHotDogs = (hotDogs*2)+1;
        
        System.out.print("That's nothing! I can eat " + myHotDogs + " hot dogs, no sweat. ");
        System.out.print("How many languages do you know? ");
        languages = myScanner.nextInt();
        myLanguages = languages*2+1;
        
        System.out.println("Sorry, compadre, pero yo se hablar " + myLanguages + " idiomas. Je suis desole!");
    }
    
}
