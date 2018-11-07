/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuofchampions;

/**
 *
 * @author Alex
 */
public class MenuOfChampions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String item1 = "Hang Em High Burger";
        String item2 = "Samurai-style Champloo";
        String item3 = "BIG BOWL OF RAMEN";
        
        double price1 = 10.25;
        double price2 = 12.51;
        double price3 = 15.75;
        
        System.out.println("Welcome to The Den!");
        System.out.println("Our specials today include: \n");
        
        System.out.println(item1 + "        $" + price1);
        System.out.println(item2 + "     $" + price2);
        System.out.println(item3 + "          $" + price3);
    }
    
}
