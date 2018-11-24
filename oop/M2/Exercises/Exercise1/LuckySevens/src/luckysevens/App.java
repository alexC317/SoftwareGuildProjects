/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class App {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LuckySevens l7 = new LuckySevens();
        
        System.out.print("How many dollars do you have? ");
        l7.gamble(input.nextInt());
        
    }
}
