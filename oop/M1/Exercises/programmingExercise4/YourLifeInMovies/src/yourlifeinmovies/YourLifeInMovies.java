/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourlifeinmovies;
import java.util.Scanner;
/**
 *
 * @author Alex
 */
public class YourLifeInMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userName;
        int userYear;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Hey, let's play a game! What's your name? ");
        userName = myScanner.nextLine();
        
        System.out.print("Ok, " + userName + ", when were you born? ");
        userYear = Integer.parseInt(myScanner.nextLine());
        
        if(userYear < 2005){
            System.out.println("Did you know that Pixar's up came out half a decade ago?");
            if(userYear < 1995){
                System.out.println("And that the first Harry Potter film came out over 15 years ago?");
                if(userYear < 1985){
                    System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
                    if(userYear < 1975){
                        System.out.println("Additionally, the Jurassic Park release is close to the date of the first lunar landing that it is to today!");
                        if(userYear < 1965){
                            System.out.println("Cherry on the top? MASH has been around for almost half a century!");
                        }
                    }
                }
            }
        }
    }
}
