/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizor;

import java.util.Scanner;
/**
 *
 * @author Alex
 */
public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Factorizor f = new Factorizor();
        
        System.out.print("What number would you like to factor? ");
        int userNum = input.nextInt();
        
        f.Factorizor(userNum);
    }
}
