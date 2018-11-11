/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loveme;

/**
 *
 * @author Alex
 */
public class LoveMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int petals = 34;
        
        do
        {
            if(petals%2 == 0)
            {System.out.println("It loves me NOT!");}
            else
            {System.out.println("It LOVES me!");}
            petals--;
        }while(petals > 0);
        
        
    }
    
}

//I opted to use a do-while loop to ensure that the loop will run at least once and show a message
//even if the numbers of petals change