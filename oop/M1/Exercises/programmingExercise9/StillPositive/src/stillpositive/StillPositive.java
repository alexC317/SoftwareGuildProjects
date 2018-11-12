/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stillpositive;

/**
 *
 * @author Alex
 */
public class StillPositive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = {389, -447, 26, -485, 715, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259,
            -500, 278, -219, 799, -311};
        
        for(int i = 0; i < 20; i++){
            if(numbers[i] > 0)
            {System.out.print(numbers[i] + " ");}
        }
    }
}
