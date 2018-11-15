/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesort;

/**
 *
 * @author Alex
 */
public class SimpleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        
        int[] wholeNumbers = myNewMethod(firstHalf, secondHalf);
        
        
        System.out.println("Here ya go - all nice and ordered:");
        for(int z = 0; z < wholeNumbers.length; z++)
        {System.out.print(wholeNumbers[z] + " ");}
    }

    public static int[] myNewMethod(int[] p1, int[] secondHalf) {
        int[] wholeNumbers = new int[24];
        int i = 0; //firstHalf counter
        int j = 0; //secondHalf counter
        for(int k = 0; k < wholeNumbers.length; k++)
        {
            if(i < p1.length) {
                if(p1[i] < secondHalf[j]){
                    wholeNumbers[k] = p1[i];
                    i++;
                }
                else{
                    wholeNumbers[k] = secondHalf[j];
                    j++;
                }
            }
            else if(i == p1.length && j < secondHalf.length){
                wholeNumbers[k] = secondHalf[j];
                j++;
            }
            else if(j < secondHalf.length){
                if(secondHalf[j] < p1[i]){
                    wholeNumbers[k] = secondHalf[j];
                    j++;
                }
            }
            else if(j == secondHalf.length && i < p1.length){
                wholeNumbers[k] = p1[i];
                i++;
            }
        }
        return wholeNumbers;
    }
    
}
