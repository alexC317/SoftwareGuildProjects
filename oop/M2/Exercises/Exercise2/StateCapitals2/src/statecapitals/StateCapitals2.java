/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class StateCapitals2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userChoice = 0;
        HashMap<String, String> stateCapitals = new HashMap<>();
        Scanner input = new Scanner(System.in);

        stateCapitals.put("Alabama", "Montgomery");
        stateCapitals.put("Alaska", "Juneau");
        stateCapitals.put("Arizona", "Phoenix");
        stateCapitals.put("Arkansas", "Little Rock");
        stateCapitals.put("California", "Sacramento");
        stateCapitals.put("Colorado", "Denver");
        stateCapitals.put("Connecticut", "Hartford");
        stateCapitals.put("Delaware", "Dover");
        stateCapitals.put("Florida", "Tallahassee");
        stateCapitals.put("Georgia", "Atlanta");
        stateCapitals.put("Hawaii", "Honolulu");
        stateCapitals.put("Illinois", "Springfield");
        stateCapitals.put("Indiana", "Indianapolis");
        stateCapitals.put("Iown", "Des Moines");
        stateCapitals.put("Kansas", "Topeka");
        stateCapitals.put("Kentucky", "Frankfort");
        stateCapitals.put("Louisiana", "Baton Rouge");
        stateCapitals.put("Maine", "Augusta");
        stateCapitals.put("Maryland", "Annapolis");
        stateCapitals.put("Massachusetts", "Boston");
        stateCapitals.put("Michigan", "Topeka");
        stateCapitals.put("Minnesota", "Saint Paul");
        stateCapitals.put("Mississippi", "Jackson");
        stateCapitals.put("Missouri", "Jefferson City");
        stateCapitals.put("Montana", "Helena");
        stateCapitals.put("Nebraska", "Lincoln");
        stateCapitals.put("Nevada", "Carson City");
        stateCapitals.put("New Hampshire", "Concord");
        stateCapitals.put("New Jersey", "Trenton");
        stateCapitals.put("New Mexico", "Santa Fe");
        stateCapitals.put("New York", "Albany");
        stateCapitals.put("North Carolina", "Raleigh");
        stateCapitals.put("North Dakota", "Bismarck");
        stateCapitals.put("Ohio", "Columbus");
        stateCapitals.put("Oklahoma", "Oklahoma City");
        stateCapitals.put("Oregon", "Salem");
        stateCapitals.put("Pennsylvania", "Harrisburg");
        stateCapitals.put("Rhode Island", "Providence");
        stateCapitals.put("South Carolina", "Columbia");
        stateCapitals.put("South Dakota", "Pierre");
        stateCapitals.put("Tennessee", "Nashville");
        stateCapitals.put("Texas", "Austin");
        stateCapitals.put("Utah", "Salt Lake City");
        stateCapitals.put("Vermont", "Montpelier");
        stateCapitals.put("Virginia", "Richmond");
        stateCapitals.put("Washington", "Olympia");
        stateCapitals.put("West Virginia", "Charleston");
        stateCapitals.put("Wisconsin", "Madison");
        stateCapitals.put("Wyoming", "Cheyenne");

        System.out.println("All states and their corresponding capitals have been loaded into the program.");
        System.out.println("How should we proceed?");
        System.out.println("1. Display all states.");
        System.out.println("2. Display all capitals.");
        System.out.println("3. Display all states with their capitals.");
        System.out.print("Please enter your choice: ");

        userChoice = Integer.parseInt(input.nextLine());
        Set<String> keys = stateCapitals.keySet();

        switch (userChoice) {
            case 1:
                System.out.println("STATES:");
                System.out.println("=========");
                for (String k : keys) {
                    System.out.println(k);
                }
                break;
            case 2:
                System.out.println("CAPITALS:");
                System.out.println("=========");
                for (String k : keys) {
                    System.out.println(stateCapitals.get(k));
                }
                break;
            case 3:
                System.out.println("STATES/CAPITAL PAIRS:");
                System.out.println("=========");
                for (String k : keys) {
                    System.out.println(k + " - " + stateCapitals.get(k));
                }
                break;
        }
    }

}
