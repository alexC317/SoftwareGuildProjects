/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.view;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner input = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.print(msg);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.print(prompt);
        double value;
        try {
            value = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            return readDouble("Please enter a valid number: ");
        }
        return value;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.print(prompt);
        double value;
        try {
            value = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            return readDouble("Please enter a valid number: ", min, max);
        }
        if (value > max || value < min) {
            return readDouble("Please enter a number between the range of " + min + " and " + max + ".", min, max);
        }
        return value;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.print(prompt);
        float value;
        try {
            value = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            return readFloat("Please enter a valid number: ");
        }
        return value;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float value;
        try {
            value = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            return readFloat("Please enter a valid number: ", min, max);
        }
        if (value < min || value > max) {
            return readFloat("Please enter a number between the range of " + min + " and " + max + ".", min, max);
        }
        return value;
    }

    @Override
    public int readInt(String prompt) {
        System.out.print(prompt);
        int value;
        try {
            value = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return readInt("Please enter a valid number: ");
        }
        return value;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.print(prompt);
        int value;
        try {
            value = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return readInt("Please enter a valid number: ", min, max);
        }
        if (value < min || value > max) {
            return readInt("Please enter a number between the range of " + min + " and " + max + ".", min, max);
        }
        return value;
    }

    @Override
    public long readLong(String prompt) {
        System.out.print(prompt);
        long value;
        try {
            value = Long.parseLong(input.nextLine());
        } catch (NumberFormatException e) {
            return readLong("Please enter a valid number: ");
        }
        return value;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.print(prompt);
        long value;
        try {
            value = Long.parseLong(input.nextLine());
        } catch (NumberFormatException e) {
            return readLong("Please enter a valid number: ", min, max);
        }

        if (value < min || value > max) {
            return readLong("Please enter a number between the range of " + min + " and " + max + ".", min, max);
        }
        return value;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.print(prompt);
        BigDecimal value;
        try {
            value = new BigDecimal(input.nextLine());
        } catch (NumberFormatException e) {
            return readBigDecimal("Please enter a valid number: ");
        }
        return value;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        System.out.print(prompt);
        BigDecimal value;
        try {
            value = new BigDecimal(input.nextLine());
        } catch (NumberFormatException e) {
            return readBigDecimal("Please enter a valid number: ", min, max);
        }
        if (value.compareTo(min) == -1 || value.compareTo(max) == 1) {
            return readBigDecimal("Please enter a number between the range of " + min.toString() + " and " + max.toString() + ".", min, max);
        }
        return value;
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}
