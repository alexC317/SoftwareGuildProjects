/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.service;

import com.swcguild.vendingmachine.dao.VendingMachinePersistenceException;
import com.swcguild.vendingmachine.dto.Change;
import com.swcguild.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface VendingMachineServiceLayer {

    /**
     * Adds a new item to the Vending Machine. Should only be accessible through
     * the secret menu.
     *
     * @param item
     * @throws vendingmachine.service.VendingMachineDuplicateIDException
     * @throws vendingmachine.dao.VendingMachinePersistenceException
     * @throws vendingmachine.service.VendingMachineDataValidationException
     */
    public void addNewItem(VendingMachineItem item) throws
            VendingMachineDuplicateIDException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException;

    /**
     * Get a list of all items from the Dao layer.
     *
     * @return A list of items that do not have an inventory of 0.
     */
    public List<VendingMachineItem> getAvailableItems();

    /**
     * Takes the balance retrieved from the Controller and stores it in a
     * variable.
     *
     * @param balance The balance retrieved from the Controller.
     */
    public void setBalance(BigDecimal balance);

    /**
     * Takes the balance stored in the Service Layer and returns it to the
     * caller.
     *
     * @return The balance stored in the Service Layer.
     */
    public BigDecimal getBalance();

    /**
     * Do all the necessary functions related to vending an item.
     *
     * @param itemId
     * @return The change being returned back to the user.
     * @throws vendingmachine.service.InsufficientFundsException
     * @throws vendingmachine.dao.VendingMachinePersistenceException
     * @throws vendingmachine.service.ItemOutOfStockException
     */
    public Change vend(int itemId) throws InsufficientFundsException, VendingMachinePersistenceException, ItemOutOfStockException;

    /**
     * Calculates how much of each denomination the User is getting back and
     * returns the amount to the Controller.
     *
     * @param change The difference between the balance and the cost of the
     * item.
     * @return A Change object containing how much of each denomination the user
     * is getting back.
     */
    public Change calculateChange(BigDecimal change);

    /**
     *
     * @param itemId
     * @param resupplyAmount
     * @throws VendingMachinePersistenceException
     * @throws VendingMachineItemOverCapacityException
     */
    public void restock(int itemId, int resupplyAmount) throws VendingMachinePersistenceException, VendingMachineItemOverCapacityException;

}
