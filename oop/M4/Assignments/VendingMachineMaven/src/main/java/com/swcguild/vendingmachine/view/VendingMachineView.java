/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.view;

import com.swcguild.vendingmachine.dto.Change;
import com.swcguild.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;

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
        int counter = 2;

        io.print("1. Quit vending. \n");
        for (VendingMachineItem item : items) {
            io.print(counter + ". " + item.getItemName() + " - $" + item.getItemPrice() + "\n");
            counter++;
        }
    }

    public void displaySecretMenu() {
        io.print("Wow, you've found our secret menu! \n");
        io.print("Here you have the option to restock an item or add a new one to the machine. \n");
        io.print("1. Add an item. \n");
        io.print("2. Restock an item. \n");

    }

    public BigDecimal getBalance() {
        return io.readBigDecimal("Please enter how much you're putting in: ");
    }

    public int getMenuChoice(List<VendingMachineItem> items) {
        int max = items.size();
        int choice = io.readInt("Please enter your selection: ", -1, max + 1);

        if (choice == 1) {
            return 0;
        } else if (choice == -1) {
            return -1;
        } else {
            return (items.get(choice - 2).getItemId());
        }
    }

    public int getSecretMenuChoice() {
        return io.readInt("Please enter your choice: ", 1, 3);
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

    public int getResupplyAmount() {
        return io.readInt("Please enter how many you want to add: ", 1, 10);
    }

    public void displayChange(Change change) {
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

}
