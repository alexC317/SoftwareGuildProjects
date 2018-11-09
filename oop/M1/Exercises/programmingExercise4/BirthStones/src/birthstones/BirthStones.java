/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthstones;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class BirthStones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userNum;
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Please input the number of the month you want to know: ");
        userNum = Integer.parseInt(myScanner.nextLine());
        
        if(userNum == 1)
        {System.out.println("January's birthstone is Garnet.");}
        else if(userNum == 2)
        {System.out.println("February's birthstone is Amethyst.");}
        else if(userNum == 3)
        {System.out.println("March's birthstone is Aquamarine.");}
        else if(userNum == 4)
        {System.out.println("April's birthstone is Diamond.");}
        else if(userNum == 5)
        {System.out.println("May's birthstone is Emerald.");}
        else if(userNum == 6)
        {System.out.println("June's birthstone is Pearl.");}
        else if(userNum == 7)
        {System.out.println("July's birthstone is Ruby.");}
        else if(userNum == 8)
        {System.out.println("August's birthstone is Peridot.");}
        else if(userNum == 9)
        {System.out.println("September's birthstone is Sapphire.");}
        else if(userNum == 10)
        {System.out.println("October's birthstone is Opal.");}
        else if(userNum == 11)
        {System.out.println("November's birthstone is Topaz.");}
        else if(userNum == 12)
        {System.out.println("December's birthstone is Turquoise.");}
        else
        {System.out.println(userNum + " does not equate to a known month.");}
        
        
    }
    
}
