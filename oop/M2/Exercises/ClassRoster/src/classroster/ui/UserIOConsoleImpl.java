/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.ui;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class UserIOConsoleImpl implements UserIO{
    @Override
    public void print(String message){
        System.out.print(message);
    }
    
    @Override
    public double readDouble(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        double input = Double.parseDouble(sc.nextLine());
        return input;
    }
    
    @Override
    public double readDouble(String prompt, double min, double max){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        double input = Double.parseDouble(sc.nextLine());
        
        if(input < min || input > max){
            return readDouble("\n Please enter a new number: ", min, max);
        }
        
        return input;
    }
    
    @Override
    public float readFloat(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        float input = Float.parseFloat(sc.nextLine());
        return input;
    }
    
    @Override
    public float readFloat(String prompt, float min, float max){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        float input = Float.parseFloat(sc.nextLine());
        
        if(input < min || input > max){
            return readFloat("\n Please input a new number: ", min, max);
        }
        
        return input;
    }
    
    @Override
    public int readInt(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        return input;
    }
    
    @Override
    public int readInt(String prompt, int min, int max){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        
        if(input < min || input > max){
            return readInt("Please input a new number: ", min, max);
        }
        
        return input;
    }
    
    @Override
    public long readLong(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        long input = Long.parseLong(sc.nextLine());
        return input;        
    }
    
    @Override
    public long readLong(String prompt, long min, long max){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        long input = Long.parseLong(sc.nextLine());
        
        if(input < min || input > max){
            return readLong("\n Please input a new number: ", min, max);
        }
        
        return input;
    }
    
    @Override
    public String readString(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
}
