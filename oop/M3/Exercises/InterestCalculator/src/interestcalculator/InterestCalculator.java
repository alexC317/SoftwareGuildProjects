/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        BigDecimal annIntRate;
        BigDecimal initPrincipal;
        int years;

        //Calculation variables
        BigDecimal cmpIntRate;
        BigDecimal cmpPeriod = null;
        BigDecimal currentBalance;
        BigDecimal intEarned = new BigDecimal("0");

        Scanner input = new Scanner(System.in);

        System.out.println("Please input if the compound period will be: ");
        System.out.println("1. Quarterly");
        System.out.println("2. Monthly");
        System.out.println("3. Daily");
        System.out.print("Compound Period: ");
        userInput = input.nextInt();
        input.nextLine();

        switch (userInput) {
            case 1:
                cmpPeriod = new BigDecimal("4");
                break;
            case 2:
                cmpPeriod = new BigDecimal("12");
                break;
            case 3:
                cmpPeriod = new BigDecimal("365");
                break;
            default:
                break;
        }

        System.out.print("Please input the plan's annual interest rate: ");
        annIntRate = new BigDecimal(input.nextLine());

        System.out.print("Please input the initial amount of principal to calculate: ");
        String amount = input.nextLine();
        initPrincipal = new BigDecimal(amount);
        currentBalance = new BigDecimal(amount);

        System.out.print("Please input how many years the money should stay in the fund: ");
        years = input.nextInt();

        cmpIntRate = annIntRate.divide(cmpPeriod, 2, RoundingMode.HALF_UP);

        for (int currentYear = 0; currentYear <= years; currentYear++) {
            System.out.println("**** Results for year " + currentYear + " ****");
            System.out.println("Starting principal: $" + currentBalance.setScale(2, RoundingMode.HALF_UP));
            for (int i = 0; i < 4; i++) {
                BigDecimal cmpIntPercentBase = cmpIntRate.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
                BigDecimal cmpIntPercentOffset = cmpIntPercentBase.add(new BigDecimal("1"));
                BigDecimal cmpIntGained = cmpIntPercentOffset.multiply(currentBalance);
                cmpIntGained = cmpIntGained.subtract(currentBalance);
                intEarned = intEarned.add(cmpIntGained);
                
                currentBalance = currentBalance.multiply(cmpIntPercentOffset);
                
            }
            System.out.println("Ending principal: $" + currentBalance.setScale(2, RoundingMode.HALF_UP));
            System.out.println("Interest earned for the year: $" + intEarned.setScale(2, RoundingMode.HALF_UP));
            System.out.println("");
            intEarned = new BigDecimal("0.0");
        }
    }

}
