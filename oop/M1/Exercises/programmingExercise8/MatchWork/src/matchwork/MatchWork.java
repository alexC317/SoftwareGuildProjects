/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchwork;

/**
 *
 * @author Alex
 */
public class MatchWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" The word Cart should before Horse alphabetically: " +comesBefore("Cart", "Horse"));
        System.out.println(" Half of 42 = " + halfOf(42));
        System.out.println(" (short) Pi = " + pi());
        System.out.println(" The first letter of the word Llama is: " + firstLetter("Llama"));
        System.out.println(" 1337 x 137 = " + times1337(1337));
    }
    
    public static double pi()
    {return 3.14;}
    
    public static int times1337(int x)
    {return x * 1337;}
    
    public static double halfOf(double y)
    {return y / 2;}
    
    public static String firstLetter(String word)
    {return word.substring(0,1);}
    
    public static boolean comesBefore(String a, String b)
    {return a.compareToIgnoreCase(b) < 0;}
    
}
