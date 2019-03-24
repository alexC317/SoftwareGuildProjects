/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.views;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;


public class UserConsoleIOImpl implements UserIO {
    private static Scanner sc = new Scanner(System.in);
    @Override
    public String promptString(String messagge) {
        return sc.nextLine();
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public int promptInt(String message) {
        int result = 0;
        while(!sc.hasNextInt()){
            display("Invalid Input");
        }
        return sc.nextInt();
        
    }

    @Override
    public LocalDate promptDate(String message) {
        LocalDate date = null;
        boolean isValid = false;
        while(!isValid){
            String input = promptString(message);
            try {
                date = LocalDate.parse(input);
                isValid = true;
            } catch (DateTimeException e) {
                display("Invalid Date format");
            }
        }
        return date;
    }
    
}
