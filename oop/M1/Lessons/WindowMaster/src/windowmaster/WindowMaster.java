/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowmaster;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class WindowMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //decalre variables for height and width
        float height;
        float width;
 
        //declare other variabkes
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        //declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);
        
        // get input from the user

        height = readValue("Please enter window height: ");
        width = readValue("Please enter window width: ");
        
        // calculate the area of the window
        areaOfWindow = height * width;
        
        // calculate the perimeter of the window
        perimeterOfWindow = 2*(height + width);
        
        // calculate total cost - use hard coded for material cost
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));
        
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = "+ cost);
    }
        
        public static float readValue(String prompt){
            Scanner sc = new Scanner(System.in);
            System.out.println(prompt);
            String input = sc.nextLine();
            float floatVal = Float.parseFloat(input);
            return floatVal;
        }
    
}

