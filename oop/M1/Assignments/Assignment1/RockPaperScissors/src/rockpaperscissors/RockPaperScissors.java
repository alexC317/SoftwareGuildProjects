/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variable declaration
        int numOfRounds;      //sets the max number of rounds to play, based on user input
        int userChoice = 0;   //takes in user input to determine Rock, Paper or Scissors
        int compChoice;       //holds the value of the computer's choice 
        int ties = 0;         //tracks how many rounds ended in a tie
        int userWin = 0;      //tracks how many rounds the user won
        int compWin = 0;      //tracks how many times the computer won
        int currentRound = 0; //Since we are going to play a minimum of at least one round, it's safe to initialize

        String userName;      //saves the user's name
        String result;        //saves the result of a round
        String continueGame;  //saves if the user wants to continue or not

        boolean keepPlaying = true;    //will determine if the game is over or not
        boolean validChoice = false;   //flag to determine if the user input for their choice is valid
        boolean exitChoice = false;    //flag to determine if the user input to keep playing is valid

        //Special objects declation
        Scanner input = new Scanner(System.in); //will take in user input
        Random decider = new Random();          //will randomly decide a number from 1 to 3 for the computer

        //Explains the rules to the user
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Here are the rules: ");
        System.out.println("-You'll give me your name, and how many rounds you want to play.");
        System.out.println("-Once that's settled, you'll input a number every round to make your play.");
        System.out.println("-The computer will make its choice, and I'll tell you what the result is.");
        System.out.print("Ready to play? I'll need your name: ");

        userName = input.nextLine();
        System.out.println("Gotcha. Nice to meet you, " + userName + "!");
        
        /*
            Loops the whole process of:
            -Prompting the user for how many rounds to play
            -Playing the game for how many rounds they input
            -Displaying the results of the game
            -Asking them if they want to play again
        */
        do {
            System.out.print("Now, how many rounds should we play? Please pick a number from 1 to 10: ");

            //If the user did not enter an int, this will display an error message and quit the program
            if (!input.hasNextInt()) {
                System.out.println("Umm, sorry, but that's not a valid number. Bye!");
                return;
            }

            numOfRounds = input.nextInt();
            input.nextLine(); //This clears the input stream so it doesn't mess with future inputs

            //Displays if the number entered was within the range of 1 to 10
            //If invalid, quit the program
            //If valid, continue the program
            if (numOfRounds < 1 || numOfRounds > 10) {
                System.out.println("Umm, sorry, but that's not a valid number. Bye!");
                return;
            } else {
                System.out.println("Perfect, we'll play for " + numOfRounds + " rounds.");
            }

            //Runs the game, looping until all the rounds have been played
            do {
                //This loop is to ensure a user will only ever enter a 1, 2 or 3
                while (!validChoice) {
                    System.out.print("Please enter your input (1 for Rock, 2 for Paper, 3 for Scissors): ");

                    //Evaluates if the user input is an int
                    if (!input.hasNextInt()) {
                        System.out.println("***Not a number, please try again***");
                        input.nextLine();
                    } else {
                        userChoice = input.nextInt();
                        input.nextLine();

                        //Checks to see if the user input is a 1, 2 or 3
                        if (userChoice == 1 || userChoice == 2 || userChoice == 3) {
                            validChoice = true;
                        } else {
                            System.out.println("***Please enter a valid number - either 1, 2, or 3***");
                        }
                    }
                }

                //Randomly determines what the computer will play
                compChoice = decider.nextInt(3) + 1;

                //Determines who the winner is
                result = roundWinner(userChoice, compChoice);

                //Displays the winner based off of the result
                switch (result) {
                    case "tie":
                        System.out.println("Tie round!");
                        ties++;
                        break;
                    case "computer":
                        System.out.println("The computer wins!");
                        compWin++;
                        break;
                    case "user":
                        System.out.println("You win!");
                        userWin++;
                        break;
                    default:
                        break;
                }

                //Updates the current round count and resets validChoice to false
                currentRound++;
                validChoice = false;
            } while (currentRound < numOfRounds);
            
            //Displays the number of ties, computer wins and user wins
            System.out.println("Ties: " + ties);
            System.out.println("Computer wins: " + compWin);
            System.out.println("User wins: " + userWin);
            
            //Displays the winner
            if (userWin > compWin) {
                System.out.println("Congrats, " + userName + ", you've won the game!");
            } else if (compWin > userWin) {
                System.out.println("It seems like the computer won. End of Line.");
            } else {
                System.out.println("Tie game!");
            }

            //Asks the user if they want to continue and validates their input
            do {
                System.out.print("Do you want to play again (y/n)? ");
                continueGame = input.nextLine();

                switch (continueGame) {
                    case "y":
                        System.out.println("Let's play again!");
                        keepPlaying = true;
                        exitChoice = true;
                        currentRound = 0;
                        ties = 0;
                        userWin = 0;
                        compWin = 0;
                        break;
                    case "n":
                        System.out.println("Thanks for playing, " + userName + "!");
                        keepPlaying = false;
                        exitChoice = true;
                        break;
                    default:
                        System.out.println("*** Please type out only y or n ***");
                        exitChoice = false;
                }
            } while (exitChoice == false);

        } while (keepPlaying);

    } //End of main
    
    
    //Method to determine the winner, given the user and computer choices
    public static String roundWinner(int userChoice, int compChoice) {
        if (userChoice == 1 && compChoice == 1) {
            return "tie";
        } else if (userChoice == 1 && compChoice == 2) {
            return "computer";
        } else if (userChoice == 1 && compChoice == 3) {
            return "user";
        } else if (userChoice == 2 && compChoice == 1) {
            return "user";
        } else if (userChoice == 2 && compChoice == 2) {
            return "tie";
        } else if (userChoice == 2 && compChoice == 3) {
            return "computer";
        } else if (userChoice == 3 && compChoice == 1) {
            return "computer";
        } else if (userChoice == 3 && compChoice == 2) {
            return "user";
        } else if (userChoice == 3 && compChoice == 3) {
            return "tie";
        }

        return "";
    }
}
