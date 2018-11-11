/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecount;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class TheCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int startNum;
        int endNum;
        int increment;
        int flag = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! *** ");
        System.out.print("Start at : ");
        startNum = input.nextInt();
        
        System.out.print("Stop at : ");
        endNum = input.nextInt();
        
        System.out.print("Count by : ");
        increment = input.nextInt();
        
        for(int i = startNum; i < endNum; i += increment){
            System.out.print(i + " ");
            flag++;
            
            if(flag%3 == 0)
            {System.out.println("- Ah ah ah!");}
        }
    }
    
}
