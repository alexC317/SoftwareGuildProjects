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
import vendingmachine.service.VendingMachineItemOverCapacityException;
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
     * @throws InsufficientFundsException
     * @throws VendingMachinePersistenceException
     * @throws ItemOutOfStockException
     */
    public void run() throws InsufficientFundsException, VendingMachinePersistenceException, ItemOutOfStockException, VendingMachineItemOverCapacityException {
        boolean quit = false;
        int menuSelection;
        int secretMenuSelection;

        try {
            while (!quit) {
                displayMenu();
                enterBalance();
                menuSelection = getMenuChoice();

                if (menuSelection == 0) {
                    exit();
                    quit = true;
                } else if (menuSelection == -1) {
                    displaySecretMenu();
                    secretMenuSelection = getSecretMenuChoice();
                    if (secretMenuSelection == 1) {
                        addNewItem();
                    } else if (secretMenuSelection == 2) {
                        restock();
                    } else if (secretMenuSelection == 3) {
                        break;
                    }
                } else {
                    vend(menuSelection);
                }
            }
        } catch (VendingMachinePersistenceException
                | ItemOutOfStockException
                | VendingMachineDuplicateIDException
                | VendingMachineDataValidationException
                | VendingMachineItemOverCapacityException e) {
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
        view.introMessage();
    }

    /**
     * Calls a function in the View layer to display the items in the vending
     * machine.
     */
    private void displayMenu() {
        List<VendingMachineItem> items = service.getAvailableItems();
        view.displayMenu(items);
    }

    private void displaySecretMenu() {
        view.displaySecretMenu();
    }

    /**
     * Prompt the user to enter a balance to put into the machine.
     */
    private void enterBalance() {
        BigDecimal balance = view.getBalance();
        service.setBalance(balance);
    }

    /**
     * Prompts the user to enter what item they want to purchase.
     */
    private int getMenuChoice() {
        List<VendingMachineItem> items = service.getAvailableItems();
        return view.getMenuChoice(items);
    }

    private int getSecretMenuChoice() {
        return view.getSecretMenuChoice();
    }

    /**
     * Prompts the user to enter information to create a new VendingMachineItem
     * and then sends to the Service Layer.
     *
     * @throws VendingMachineDuplicateIDException
     * @throws VendingMachinePersistenceException
     * @throws VendingMachineDataValidationException
     */
    private void addNewItem() throws VendingMachineDuplicateIDException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        VendingMachineItem newItem = view.getNewItem();
        service.addNewItem(newItem);
    }

    /**
     * Resupplies an item in the Vending Machine by a particular amount.
     */
    private void restock() throws VendingMachinePersistenceException, VendingMachineItemOverCapacityException {
        List<VendingMachineItem> items = service.getAvailableItems();
        int itemId = view.getMenuChoice(items);
        int resupplyAmount = view.getResupplyAmount();
        service.restock(itemId, resupplyAmount);
    }

    /**
     * Sells the item to the user.
     *
     * @param itemId
     */
    private void vend(int itemId) throws InsufficientFundsException, VendingMachinePersistenceException, ItemOutOfStockException {
        Change change = service.vend(itemId);
        view.displayChange(change);
    }

    /**
     * Exits the program.
     */
    private void exit() {
        view.displayExitMessage();
    }

}
