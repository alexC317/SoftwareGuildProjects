/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

/**
 *
 * @author Alex
 */
public class VendingMachineController {

    public VendingMachineController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Runs the program
     */
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Calls a function in the View layer to display an intro message.
     */
    private void intro() {
        // Display an intro message from the View layer
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Calls a function in the View layer to display the items in the vending
     * machine.
     */
    private void displayMenu() {
        // Fetch what items are available from the Service layer
        // Send that List to the View for it to display
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Prompt the user to enter a balance to put into the machine.
     */
    private void enterBalance() {
        // From the View layer, prompt the user to enter a balance
        // Send that balance to the Service layer
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Prompts the user to enter what item they want to purchase.
     */
    private void getMenuChoice() {
        // From the View layer, prompt the user to enter what they want to buy.
        // Controller will then make a decision from this in run()
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Sells the item to the user.
     *
     * @param itemId
     */
    private void vend(int itemId) {
        // Passes along the itemId of the user selection to the Service Layer
        // If successful, View layer should display a message that the purchase
        // went through, and a message indicating what the change is.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Exits the program.
     */
    private void exit() {
        // Exits the program
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void unknownCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
