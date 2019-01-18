/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanagermaven.view;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double input = Double.parseDouble(sc.nextLine());
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double input = Double.parseDouble(sc.nextLine());
        if (input < min || input > max) {
            return readDouble("Please enter a new number: ", min, max);
        }
        return input;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float input = Float.parseFloat(sc.nextLine());
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float input = Float.parseFloat(sc.nextLine());

        if (input < min || input > max) {
            return readFloat("Please input a new number: ", min, max);
        }
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int input = Integer.parseInt(sc.nextLine());
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int input = Integer.parseInt(sc.nextLine());

        if (input < min || input > max) {
            input = readInt("Please enter another number.", min, max);
        }
        return input;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long input = Long.parseLong(sc.nextLine());
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long input = Long.parseLong(sc.nextLine());

        if (input < min || input > max) {
            return readLong("Please input a new number: ", min, max);
        }
        return input;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input;
        input = sc.nextLine();
        return input;
    }

}
