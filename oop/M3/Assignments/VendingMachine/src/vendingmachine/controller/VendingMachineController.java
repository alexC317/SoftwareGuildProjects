/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.ItemOutOfStockException;
import vendingmachine.service.VendingMachineDataValidationException;
import vendingmachine.service.VendingMachineDuplicateIDException;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.VendingMachineView;

/**
 *
 * @author Alex
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineService service;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    /**
     * Runs the program
     *
     * @throws vendingmachine.service.InsufficientFundsException
     * @throws vendingmachine.dao.VendingMachinePersistenceException
     * @throws vendingmachine.service.ItemOutOfStockException
     */
    public void run() throws InsufficientFundsException, VendingMachinePersistenceException, ItemOutOfStockException {
        boolean quit = false;
        int menuSelection;

        try {
            while (!quit) {
                displayMenu();
                enterBalance();
                menuSelection = getMenuChoice();

                if (menuSelection == 0) {
                    exit();
                    quit = true;
                } else if (menuSelection == -1) {
                    addNewItem();
                } else if (menuSelection == -2) {
                    restock();
                } else {
                    vend(menuSelection);
                }
            }
        } catch (VendingMachinePersistenceException
                | ItemOutOfStockException
                | VendingMachineDuplicateIDException
                | VendingMachineDataValidationException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (InsufficientFundsException e) {
            BigDecimal balance = service.getBalance();
            view.displayErrorMessage(e.getMessage());
            view.displayBalance(balance);
        }
    }

    /**
     * Calls a function in the View layer to display an intro message.
     */
    private void intro() {
        // Display an intro message from the View layer
        view.introMessage();
    }

    /**
     * Calls a function in the View layer to display the items in the vending
     * machine.
     */
    private void displayMenu() {
        // Fetch what items are available from the Service layer
        List<VendingMachineItem> items = service.getAvailableItems();
        // Send that List to the View for it to display
        view.displayMenu(items);
    }

    /**
     * Prompt the user to enter a balance to put into the machine.
     */
    private void enterBalance() {
        // From the View layer, prompt the user to enter a balance
        // Send that balance to the Service layer
        BigDecimal balance = view.getBalance();
        service.setBalance(balance);
    }

    /**
     * Prompts the user to enter what item they want to purchase.
     */
    private int getMenuChoice() {
        // From the View layer, prompt the user to enter what they want to buy.
        // Controller will then make a decision from this in run()
        List<VendingMachineItem> items = service.getAvailableItems();
        return view.getMenuChoice(items);
    }

    private void addNewItem() throws VendingMachineDuplicateIDException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        VendingMachineItem newItem = view.getNewItem();
        service.addNewItem(newItem);
    }

    /**
     * Sells the item to the user.
     *
     * @param itemId
     */
    private void vend(int itemId) throws InsufficientFundsException, VendingMachinePersistenceException, ItemOutOfStockException {
        // Passes along the itemId of the user selection to the Service Layer
        // If successful, View layer should display a message that the purchase
        // went through, and a message indicating what the change is.
        Change change = service.vend(itemId);
        view.displayChange(change);
    }

    /**
     * Exits the program.
     */
    private void exit() {
        // Exits the program
        view.displayExitMessage();
    }

    private void restock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
