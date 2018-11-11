/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doordonot;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class DoOrDoNot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n): ");
        boolean doIt;
        
        if (input.next().equals("y"))
        {doIt = true;} //DO IT
        else
        {doIt = false;} //DON'T YOU DARE
        
        boolean iDidIt = false;
        
//        do{
//            iDidIt = true;
//            break;
//        }while(doIt);
        while(doIt){
            iDidIt = true;
            break;
        }
        if(doIt && iDidIt)
        {System.out.println("I did it!");}
        else if(!doIt && iDidIt)
        {System.out.println("I know you said not to...but I totally did anyways.");}
        else
        {System.out.println("Don't look at me, I didn't do anything!");}
    }
    
}

//If you type y, it'll print out "I did it!"
//If you type n, it'll print out " I know you said not to...but I totally did anyways."
//For the while loop, it'll still print out "I did it" if you type in y
//But if you type in no, you'll get "Don't look at me, I didn't do anything!"
