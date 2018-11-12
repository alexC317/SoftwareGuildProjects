/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitsalad;

/**
 *
 * @author Alex
 */
public class FruitSalad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad = new String[12];
        
        
        int berries = 0;
        int apples = 0;
        int oranges = 0;
        int other = 0;
        int j = 0;
        
        for(int i = 0; i < fruit.length; i++){
            if(fruit[i].contains("berry")){
                fruitSalad[j] = fruit[i];
                berries++;
                j++;
            }
            else if(fruit[i].contains("Apple") && apples != 3){                
                fruitSalad[j] = fruit[i];
                apples++;
                j++;
            }
            else if(fruit[i].contains("Orange") && oranges != 2){
                fruitSalad[j] = fruit[i];
                oranges++;
                j++;
            }
            else if(fruit[i].contains("Fruit")){
                fruitSalad[j] = fruit[i];
                other++;
                j++;
            }
        }
        for(int z = 0; z < fruitSalad.length; z++)
        {System.out.println(fruitSalad[z] + " ");}
        
        System.out.println("Fruit Salad Stats");
        System.out.println("I have: ");
        System.out.println(berries + " berries,");
        System.out.println(apples + " apples,");
        System.out.println(oranges + " oranges,");
        System.out.println(other + " other fruits.");
    }
    
}
