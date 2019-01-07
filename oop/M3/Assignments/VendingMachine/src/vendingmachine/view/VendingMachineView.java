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

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    /**
     * Displays an intro message to the user.
     */
    public void introMessage() {
        io.print("Welcome! Please check our goods for sale!");
    }

    /**
     * Displays the menu items available to the user.
     *
     * @param items Takes in a list of items that are available to vend.
     */
    public void displayMenu(List<VendingMachineItem> items) {
        // Parse through the list and print out the name and price of each item.
        // Each line should start with the next number and be formatted like so:
        //  1. Sprite - $2.50
        int counter = 2;

        io.print("1. Quit vending. \n");
        for (VendingMachineItem item : items) {
            io.print(counter + ". " + item.getItemName() + " - $" + item.getItemPrice() + "\n");
            counter++;
        }

    }

    public BigDecimal getBalance() {
        // Prompt the user to enter a balance
        // Send that balance to the Controller
        return io.readBigDecimal("Please enter how much you're putting in: ");
    }

    public int getMenuChoice(List<VendingMachineItem> items) {
        // Prompt the user to enter their menu choice
        // Send that decision to the Controller
        int max = items.size();
        int choice = io.readInt("Please enter your selection: ", -2, max + 1);

        if (choice == 1) {
            return 0;
        } else if (choice == -1) {
            return -1;
        } else if (choice == -2) {
            return -2;
        } else {
            return (items.get(choice - 2).getItemId());
        }
    }

    public void displayChange(Change change) {
        // Prints out how much change the user is getting in various denominations
        io.print("Your change: \n");
        io.print("- " + change.getQuarters() + " quarters \n");
        io.print("- " + change.getDimes() + " dimes \n");
        io.print("- " + change.getNickels() + " nickels \n");
        io.print("- " + change.getPennies() + " pennies \n");
        io.print("\n");
    }

    public void displayErrorMessage(String message) {
        io.print("=== ERROR === \n");
        io.print(message + "\n");
    }

    public void displayExitMessage() {
        io.print("Thanks for shopping with us! \n");
    }

    public void displayBalance(BigDecimal balance) {
        io.print("Your balance: $" + balance.toString() + "\n");
    }

    public VendingMachineItem getNewItem() {
        int itemId = io.readInt("Please enter the item id: ");
        String itemName = io.readString("Please enter the item name: ");
        int itemCount = io.readInt("Please enter how many of this item exists: ");
        BigDecimal itemPrice = io.readBigDecimal("Please enter the price of this item: ");

        VendingMachineItem newItem = new VendingMachineItem(itemId);
        newItem.setItemName(itemName);
        newItem.setItemCount(itemCount);
        newItem.setItemPrice(itemPrice);

        return newItem;
    }
}
