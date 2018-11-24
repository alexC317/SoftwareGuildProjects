/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class InterestCalculator {

    public void calculate() {
        //Input variables
        int userInput;
        double annIntRate;
        double initPrincipal;
        int years;

        //Calculation variables
        double cmpIntRate;
        double cmpPeriod = 1.0;
        double currentBalance = 0.0;
        double intEarned = 0.0;
        DecimalFormat output = new DecimalFormat("###.##");

        Scanner input = new Scanner(System.in);

        System.out.println("Please input if the compound period will be: ");
        System.out.println("1. Quarterly");
        System.out.println("2. Monthly");
        System.out.println("3. Daily");
        System.out.print("Compound Period: ");
        userInput = input.nextInt();
        input.nextLine();

        if (userInput == 1) {
            cmpPeriod = 4.0;
        } else if (userInput == 2) {
            cmpPeriod = 12.0;
        } else if (userInput == 3) {
            cmpPeriod = 365.0;
        }

        System.out.print("Please input the plan's annual interest rate: ");
        annIntRate = input.nextDouble();
        input.nextLine();

        System.out.print("Please input the initial amount of principal to calculate: ");
        initPrincipal = input.nextDouble();
        input.nextLine();

        System.out.print("Please input how many years the money should stay in the fund: ");
        years = input.nextInt();
        input.nextLine();

        currentBalance = initPrincipal;
        cmpIntRate = annIntRate / cmpPeriod;

        for (int currentYear = 0; currentYear <= years; currentYear++) {
            System.out.println("**** Results for year " + currentYear + " ****");
            System.out.println("Starting principal: $" + output.format(currentBalance));
            for (int i = 0; i < 4; i++) {
                intEarned += (currentBalance * (1 + (cmpIntRate / 100))) - currentBalance;
                currentBalance *= (1 + (cmpIntRate / 100));
            }
            System.out.println("Ending principal: $" + output.format(currentBalance));
            System.out.println("Interest earned for the year: $" + output.format(intEarned));
            System.out.println("");
            intEarned = 0.0;
        }
    }

}
