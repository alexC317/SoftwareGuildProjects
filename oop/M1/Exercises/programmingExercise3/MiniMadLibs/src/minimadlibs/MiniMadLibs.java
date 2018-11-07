/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimadlibs;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class MiniMadLibs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String noun;
        String adj;
        String noun2;
        String num;
        String adj2;
        String noun3, noun4, noun5;
        String verb;
        String verb2;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Let's play MAD LIBS!");
        
        System.out.print("Gimme a noun, please! ");
        noun = myScanner.nextLine();
        
        System.out.print("And now an adjective. ");
        adj = myScanner.nextLine();
        
        System.out.print("Cool, and now another noun. ");
        noun2 = myScanner.nextLine();
        
        System.out.print("Let's change it up, gimme a number. ");
        num = myScanner.nextLine();
        
        System.out.print("I'm gonna need another adjective! ");
        adj2 =  myScanner.nextLine();
        
        System.out.print("Alright, now a noun but plural. ");
        noun3 = myScanner.nextLine();
        
        System.out.print("In the words of DJ Khaled, another one. ");
        noun4 = myScanner.nextLine();
        
        System.out.print("Aaaaand another one. ");
        noun5 = myScanner.nextLine();
        
        System.out.print("Now I will need a verb. ");
        verb = myScanner.nextLine();
        
        System.out.print("Finally, the same verb but past-tense. ");
        verb2 = myScanner.nextLine();
        
        System.out.println("Let's see what we got!");
        System.out.print(noun + ": The " + adj + " Frontier. These are the voyages of the starship " + noun2 + ". ");
        System.out.print("Its " + num + "-year mission: to explore strange " + adj2 + " " + noun3 + ", to seek out " + adj2 + " " + noun4);
        System.out.print(" and "+ adj2 + " " + noun5 + ", to boldly " + verb + " where no one has " + verb2 + " before.");
        
        
    }
    
}
