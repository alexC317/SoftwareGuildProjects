/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class LuckySevens {

    public void gamble(int startingAmount) {
        Random r = new Random();

        int money;
        int highestAmount;
        int dice1;
        int dice2;
        int rollSum;
        int rollCounter = 0;
        int highestRoll = 0;

        money = startingAmount;
        highestAmount = startingAmount;

        do {
            dice1 = r.nextInt(6) + 1;
            dice2 = r.nextInt(6) + 1;

            money = outcome(dice1, dice2, money);

            if (money > highestAmount) {
                highestAmount = money;
                highestRoll = rollCounter;
            }
            
            rollCounter++;
        } while (money > 0);

        System.out.println("You are broke after " + rollCounter + " rolls.");
        System.out.println("You should have quit after " + highestRoll + " rolls when you had $" + highestAmount + ".");
    }

    private int outcome(int dice1, int dice2, int money) {
        if (dice1 + dice2 == 7) {
            return money += 4;
        } else {
            return money -= 1;
        }
    }

}
