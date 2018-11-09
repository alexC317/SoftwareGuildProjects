/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minizork;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class MiniZork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");
        
        String action = userInput.nextLine();
        
        if(action.equals("open the mailbox")){
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();
            
            if(action.equals("look inside")){
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();
                
                if(action.equals("keep looking")){
                    System.out.println("Turns out, hanging around dark places isn't a good idea.");
                    System.out.println("You have been eaten by a grue.");
                }
                else if(action.equals("run away")){
                    System.out.println("You run away screaming across the fields - very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice");
                }
            }
            else if(action.equals("stick your hand in")){
                System.out.println("Thinking it wouldn't be a bad idea to boldly explore,");
                System.out.println("you stick your hand in. Something feels...warm though.");
                System.out.print("Pull out or keep feeling? ");
                action = userInput.nextLine();
                
                if(action.equals("pull out")){
                    System.out.println("Using your better judgement, you remove your hand from the box.");
                    System.out.println("...right before flashing teeth remove your hand from you.");
                    System.out.println("You thank you lucky stars and you NOPE right out of there.");
                }
                else if(action.equals("keep feeling")){
                    System.out.println("Curious, you rummage around the mailbox's content.");
                    System.out.println("Your hand feels weird though...like it's lighter?");
                    System.out.println("Removing your hand from the mailbox, you find...no hand at all.");
                    System.out.println("Just a bloody stump where it used to be.");
                }
            }
        }
        else if(action.equals("go to the house")){
            System.out.println("You pry open the boards sealing off the house and enter.");
            System.out.println("The smell is musty, and it looks abandoned.");
            System.out.print("Where will you go? Upstairs or the living room? ");
            action = userInput.nextLine();
            
            if(action.equals("upstairs")){
                System.out.println("You climb the creaky stairs, slowly hoping the house is truly abandoned.");
                System.out.println("You enter the only room upstairs and see a slightly open chest, glowing from within.");
                System.out.print("Will you open it or leave it be? ");
                action = userInput.nextLine();
                
                if(action.equals("open the chest")){
                    System.out.println("You approach the chest, drawn by the glowing contents, maybe it's something valuable?");
                    System.out.println("Unfortunately, not everything that glitters is gold.");
                    System.out.println("A mimic pretending to be a chest attacks you! Might not want to be so greedy next time...");
                }
                else if(action.equals("leave it be")){
                    System.out.println("Finding the situation suspicious, you back away from the chest.");
                    System.out.println("You hear the chest utter a disappointed growl.");
                    System.out.println("WAIT WHAT?! You bolt out of the house like your life depended on it.");
                    System.out.println("Which it did. You live to explore another day!");
                }
            }
            else if(action.equals("living room")){
                System.out.println("You enter the living room, spotting a dusty piano, the only thing you can interact with.");
                System.out.println("The whole vibe of the room is...unsettling.");
                System.out.print("Do you play the piano or back away? ");
                action = userInput.nextLine();
                
                if(action.equals("play the piano")){
                    System.out.println("You clear the dust, pull up the bench and start to play.");
                    System.out.println("The notes come naturally to you, and you feel a warm breeze in the room.");
                    System.out.println("Suddenly, the unsettling feeling is gone, pleased with your performance.");
                }
                else if (action.equals("back away")) {
                    System.out.println("The room begins to shake!");
                    System.out.println("Angered by the lack of a performance, the house turns on you.");
                    System.out.println("You run for the door, but the hallways");
                    System.out.println("seems to stretch");
                    System.out.println("a l w a y s");
                }
            }
        }
    }
    
}
