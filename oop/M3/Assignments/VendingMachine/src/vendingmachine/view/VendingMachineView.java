/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.view;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;

/**
 *
 * @author Alex
 */
public class VendingMachineView {

    UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    /**
     * Displays an intro message to the user.
     */
    public void introMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Displays the menu items available to the user.
     * @param items Takes in a list of items that are available to vend.
     */
    public void displayMenu(List<VendingMachineItem> items) {
        // Parse through the list and print out the name and price of each item.
        // Each line should start with the next number and be formatted like so:
        //  1. Sprite - $2.50
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public BigDecimal getBalance() {
        // Prompt the user to enter a balance
        // Send that balance to the Controller
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getMenuChoice() {
        // Prompt the user to enter their menu choice
        // Send that decision to the Controller
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void vendSuccess() {
        // Displays that the purchase went through
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void displayChange(Change change) {
        // Prints out how much change the user is getting in various denominations
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
