/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;

/**
 *
 * @author Alex
 */
public interface VendingMachineService {

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
     * Do all the necessary functions related to vending an item.
     *
     * @param itemId
     */
    public void vend(int itemId);

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
}
