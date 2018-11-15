/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summativesum;

/**
 *
 * @author Alex
 */
public class SummativeSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variable declaration
        int sum;
        int[] arr1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] arr2 = {999, -60, -77, 14, 160, 301};
        int[] arr3 = {10, 20, 30, 40 ,50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};
        
        //Calls and updates the sum variable with addArray and prints out the result
        sum = addArray(arr1);
        System.out.println("#1 Array Sum: " + sum);
        sum = addArray(arr2);
        System.out.println("#2 Array Sum: " + sum);
        sum = addArray(arr3);
        System.out.println("#3 Array Sum: " + sum);
    }
    
    //Static method that takes in an array, adds all of its contents together and then returns the result
    public static int addArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    
    
}
