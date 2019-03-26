/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.views;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.springframework.format.annotation.DateTimeFormat;

public class UserConsoleIOImpl implements UserIO {

    private static Scanner sc = new Scanner(System.in);

    @Override
    public String promptString(String message) {
        display(message);
        return sc.nextLine();
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public int promptInt(String message) {
        int result = 0;
        display(message);
        while (!sc.hasNextInt()) {
            display("Invalid Input");
        }
        result = sc.nextInt();
        sc.nextLine();
        return result;
    }

    @Override
    public LocalDate promptDate(String message) {
        LocalDate date = null;
        boolean isValid = false;
        while (!isValid) {
            String input = promptString(message);
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate lDate = LocalDate.parse(input, format);
                return lDate;
            } catch (DateTimeException e) {
                display("Invalid Date format");
            }
        }
        return date;
    }

}
