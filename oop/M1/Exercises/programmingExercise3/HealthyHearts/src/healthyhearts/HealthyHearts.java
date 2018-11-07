/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyhearts;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class HealthyHearts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int age;
        int maxHeartRate;
        float minBeats;
        float maxBeats;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("How old are you? ");
        age = myScanner.nextInt();
        
        maxHeartRate = 220 - age;
        minBeats = (float) (maxHeartRate * .5);
        maxBeats = (float) (maxHeartRate * .85);
        
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + minBeats + " - " + maxBeats + " beats per minute");
    }
    
}
