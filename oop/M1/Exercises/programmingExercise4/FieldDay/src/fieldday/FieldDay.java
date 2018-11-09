/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fieldday;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class FieldDay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userName;
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("What is your last name? ");
        userName = userInput.nextLine();
        
        if(userName.compareTo("Baggins") < 0)
        {System.out.println("Cool, looks like you're on the Red Dragons");}
        else if(userName.compareTo("Baggins") > 0 && userName.compareTo("Dresden") < 0)
        {System.out.println("It seems you're on the Dark Wizards team.");}
        else if(userName.compareTo("Dresden") > 0 && userName.compareTo("Howl") < 0)
        {System.out.println("You're part of the Moving Castles!.");}
        else if(userName.compareTo("Howl") > 0 && userName.compareTo("Potter") < 0)
        {System.out.println("Congrats, you're playing with the Golden Snitches!");}
        else if(userName.compareTo("Potter") > 0 && userName.compareTo("Vimes") < 0)
        {System.out.println("You'll be on the Night Guards team!");}
        else if(userName.compareTo("Vimes") > 0)
        {System.out.println("Finally, you'll be on the Black Holes!");}
        
    }
    
}
