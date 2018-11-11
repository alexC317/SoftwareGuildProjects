/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forbyfor;

/**
 *
 * @author Alex
 */
public class ForByFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            System.out.print("|");
            
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){                  
                    if(j == 1 && (i == 0 || i == 2))
                    {System.out.print("$");}
                    else if((j == 0 || j == 2) && i == 1)
                    {System.out.print("@");}
                    else if(j == 1 && i ==1)
                    {System.out.print("#");}
                    else
                    {System.out.print("*");}
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
    
}
