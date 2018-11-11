/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springforwardfallback;

/**
 *
 * @author Alex
 */
public class SpringForwardFallBack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("It's Spring...!");
        for(int i = 1; i < 11; i++)
        {System.out.print(i + ", ");}
        
        System.out.println("\nOh no, it's fall...");
        for(int i = 10; i > 0; i--)
        {System.out.print(i + ", ");}
    }
    
}

//For the first loop, it starts at 0 and ends at 9
//For the second loop, it starts at 10 and ends at 1