/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitsbasket;

/**
 *
 * @author Alex
 */
public class FruitsBasket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        int appleCounter = 0;
        int orangeCounter = 0;
        
        for(int i = 0; i< fruit.length; i++)
        {
            if(fruit[i].equals("Apple"))
            {appleCounter++;}
            else if(fruit[i].equals("Orange"))
            {orangeCounter++;}
            
            
        }
        
        int aIndex = 0;
        int oIndex = 0;
        String[] apples = new String[appleCounter];
        String[] oranges = new String[orangeCounter];
        
        for(int i = 0; i < fruit.length; i++)
        {
            if(fruit[i].equals("Apple"))
            {
                apples[aIndex] = fruit[i];
                aIndex++;
            }
            else if(fruit[i].equals("Orange"))
            {
                oranges[oIndex] = fruit[i];
                oIndex++;
            }
        }
        
        System.out.println("Total# of Fruit in Basket: " + fruit.length);
        System.out.println("Number of Apples: " + apples.length);
        System.out.println("Number of Oranges: " + oranges.length);
        
    }
    
    
    
}
