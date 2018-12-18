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


public class VendingMachineServiceImpl implements VendingMachineService {
    BigDecimal balance;

    @Override
    public List<VendingMachineItem> getAvailableItems() {
        // Get the List of all items in the Dao
        // Parse through the list and create a new list based on what does not
        // have an inventory of 0
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBalance(BigDecimal balance) {
        //Sets the balance here from what the Controller passed along
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vend(int itemId) {
        // Search the Dao for the item specified (using its itemId)
        // Get the price of that item
        // If the balance > price, subtract 1 from the inventory of that item,
        // calculate change, and set balance to 0
        // If balance < price, throw an exception
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Change calculateChange(BigDecimal change) {
        // Take the change (in pennies), start with the biggest denominations 
        // and start calcuating how many quarters/dimes/nickels/pennies they're
        // getting back. Save all those in a Change object.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
