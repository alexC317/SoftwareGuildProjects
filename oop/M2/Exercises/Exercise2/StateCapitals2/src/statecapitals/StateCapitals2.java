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
        HashMap<String, Capital> stateCapitals = new HashMap<>();
        Scanner input = new Scanner(System.in);

        stateCapitals.put("Alabama", new Capital("Montgomery", 205764, 155.4));
        stateCapitals.put("Alaska", new Capital("Juneau", 31275, 2716.7));
        stateCapitals.put("Arizona", new Capital("Phoenix", 1445632, 474.9));
        stateCapitals.put("Arkansas", new Capital("Little Rock", 193524, 116.2));
        stateCapitals.put("California", new Capital("Sacramento", 466488, 97.2));
        stateCapitals.put("Colorado", new Capital("Denver", 600158, 153.4));
        stateCapitals.put("Connecticut", new Capital("Hartford", 124775, 17.3));
        stateCapitals.put("Delaware", new Capital("Dover", 36047, 22.4));
        stateCapitals.put("Florida", new Capital("Tallahassee", 181376, 95.7));
        stateCapitals.put("Georgia", new Capital("Atlanta", 420003, 131.7));
        stateCapitals.put("Hawaii", new Capital("Honolulu", 337256, 85.7));
        stateCapitals.put("Idaho", new Capital("Boise", 205671, 63.8));
        stateCapitals.put("Illinois", new Capital("Springfield", 116250, 54.0));
        stateCapitals.put("Indiana", new Capital("Indianapolis", 802445, 361.5));
        stateCapitals.put("Iown", new Capital("Des Moines", 203433, 75.8));
        stateCapitals.put("Kansas", new Capital("Topeka", 127473, 56.0));
        stateCapitals.put("Kentucky", new Capital("Frankfort", 25527, 14.7));
        stateCapitals.put("Louisiana", new Capital("Baton Rouge", 229493, 76.8));
        stateCapitals.put("Maine", new Capital("Augusta", 19136, 55.4));
        stateCapitals.put("Maryland", new Capital("Annapolis", 38394, 6.73));
        stateCapitals.put("Massachusetts", new Capital("Boston", 617594, 48.4));
        stateCapitals.put("Michigan", new Capital("Lansing", 114294, 35.0));
        stateCapitals.put("Minnesota", new Capital("Saint Paul", 285068, 52.8));
        stateCapitals.put("Mississippi", new Capital("Jackson", 173514, 104.9));
        stateCapitals.put("Missouri", new Capital("Jefferson City", 43079, 27.3));
        stateCapitals.put("Montana", new Capital("Helena", 28190, 14.0));
        stateCapitals.put("Nebraska", new Capital("Lincoln", 258379, 74.6));
        stateCapitals.put("Nevada", new Capital("Carson City", 55274, 143.4));
        stateCapitals.put("New Hampshire", new Capital("Concord", 42695, 64.3));
        stateCapitals.put("New Jersey", new Capital("Trenton", 84913, 7.66));
        stateCapitals.put("New Mexico", new Capital("Santa Fe", 75764, 37.3));
        stateCapitals.put("New York", new Capital("Albany", 97856, 21.4));
        stateCapitals.put("North Carolina", new Capital("Raleigh", 403892, 114.6));
        stateCapitals.put("North Dakota", new Capital("Bismarck", 61272, 26.9));
        stateCapitals.put("Ohio", new Capital("Columbus", 787033, 210.3));
        stateCapitals.put("Oklahoma", new Capital("Oklahoma City", 579999, 607.0));
        stateCapitals.put("Oregon", new Capital("Salem", 154637, 45.7));
        stateCapitals.put("Pennsylvania", new Capital("Harrisburg", 49528, 8.11));
        stateCapitals.put("Rhode Island", new Capital("Providence", 178042, 18.5));
        stateCapitals.put("South Carolina", new Capital("Columbia", 129272, 125.2));
        stateCapitals.put("South Dakota", new Capital("Pierre", 13646, 13.0));
        stateCapitals.put("Tennessee", new Capital("Nashville", 601222, 473.3));
        stateCapitals.put("Texas", new Capital("Austin", 790390, 251.5));
        stateCapitals.put("Utah", new Capital("Salt Lake City", 186440, 109.1));
        stateCapitals.put("Vermont", new Capital("Montpelier", 7855, 10.2));
        stateCapitals.put("Virginia", new Capital("Richmond", 204214, 60.1));
        stateCapitals.put("Washington", new Capital("Olympia", 46478, 16.7));
        stateCapitals.put("West Virginia", new Capital("Charleston", 51400, 31.6));
        stateCapitals.put("Wisconsin", new Capital("Madison", 233209, 68.7));
        stateCapitals.put("Wyoming", new Capital("Cheyenne", 59466, 21.1));

        System.out.println("All states and their corresponding capitals have been loaded into the program.");
        System.out.println("Let's proceed!");

        Set<String> keys = stateCapitals.keySet();

        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("=========");
        for (String k : keys) {
            System.out.println(k + " - " + stateCapitals.get(k).getCapitalName() + " | Pop: " + stateCapitals.get(k).getCapitalPop() + " | Area: " + stateCapitals.get(k).getSqMiles() + " sq mi");
        }
        
        System.out.println();
        System.out.print("Please enter a minimum population count: ");
        userChoice = Integer.parseInt(input.nextLine());
        System.out.println();
        
        for(String k : keys){
            if(stateCapitals.get(k).getCapitalPop() >= userChoice){
                System.out.println(k + " - " + stateCapitals.get(k).getCapitalName() + " | Pop: " + stateCapitals.get(k).getCapitalPop() + " | Area: " + stateCapitals.get(k).getSqMiles() + " sq mi");
            }
        }
    }

}
