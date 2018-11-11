/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barelycontrolledchaos;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class BarelyControlledChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String color = randomColor(); //call color method here
        String animal = randomAnimal(); //call animal method here
        String colorAgain = randomColor(); ///call color method again here
        int weight = randomNum(5, 200); //call number method with a range between 5 - 200
        int distance = randomNum(10, 20); //call number method with a range between 10 - 20
        int number = randomNum(10000, 20000); //call number method with a range between 10000 - 20000
        int time = randomNum(2, 6); //call number method with a range between 2 - 6
        
        System.out.println("Once, when I was very small...");
        
        System.out.println("I was chased by a " + color + ", " + weight + "lb miniature " + animal + " for over " + distance + " miles!!");
        
        System.out.println("I had to hide in a field of over " + number + " " + colorAgain + " poppies for nearly " + time + " hours until it left me alone!");
        
        System.out.println("\nIt was QUITE the experience, " + "let me tell you!");
    }
    
    public static String randomColor()
    {
        Random r = new Random();
        int choice = r.nextInt(6)+1;
        
        if(choice == 1)
        {return "red";}
        else if(choice == 2)
        {return "blue";}
        else if(choice == 3)
        {return "yellow";}
        else if(choice == 4)
        {return "pink";}
        else if(choice == 5)
        {return "black";}
        else if(choice == 6)
        {return "green";}
        
        return "white";
    }
    
    public static String randomAnimal()
    {
        Random r = new Random();
        int choice = r.nextInt(6)+1;
        
        if(choice == 1)
        {return "tyrannosaurus rex";}
        else if(choice == 2)
        {return "triceratops";}
        else if(choice == 3)
        {return "saber-toothed tiger";}
        else if(choice == 4)
        {return "pterodactyl";}
        else if(choice == 5)
        {return "mastodon";}
        else if(choice == 6)
        {return "dragon";}
        
        return "tiger";
    }
    
    public static int randomNum(int startNum, int endNum)
    {
        Random r = new Random();
        int range = endNum - startNum;
        return (r.nextInt(range)+startNum);
        
    }
    
}
