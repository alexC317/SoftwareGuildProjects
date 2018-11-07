/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allthetrivia;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class AllTheTrivia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String author;
        String city;
        String day;
        String company;
        
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Who wrote the legendary novel Frankenstein? ");
        author = myScanner.nextLine();
        
        System.out.print("What city hosts the Eiffel Tower? ");
        city = myScanner.nextLine();
        
        System.out.print("Thanksgiving falls on what day every year? ");
        day = myScanner.nextLine();
        
        System.out.print("Which game company created the Halo and Destiny franchises? ");
        company = myScanner.nextLine();
        
        System.out.println("Yep! " + city + " created Halo and Destiny!");
        System.out.println("It's also true that " + day + " wrote Frankenstein!");
        System.out.println("Every year, Thanksgiving is on the last " + author + " of the month.");
        System.out.println("And yes, the Eiffel Tower is located in, " + company + ", France!");
    }
    
}
