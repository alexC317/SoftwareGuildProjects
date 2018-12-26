/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumpractice1;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int result = howLongUntilFriday();
        System.out.println(result + " day(s) till Friday.");
    }

    public enum DaysOfTheWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private static int howLongUntilFriday() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a day of the week: ");
        DaysOfTheWeek day = DaysOfTheWeek.valueOf(input.nextLine().toUpperCase());

        switch (day) {
            case MONDAY:
                return 4;
            case TUESDAY:
                return 3;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 1;
            case FRIDAY:
                return 0;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 7;
            default:
                throw new UnsupportedOperationException();
        }

    }

}
