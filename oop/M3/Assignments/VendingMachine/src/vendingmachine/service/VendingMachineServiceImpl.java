/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;

public class VendingMachineServiceImpl implements VendingMachineService {

    private BigDecimal balance;
    private VendingMachineDao dao;

    public VendingMachineServiceImpl(VendingMachineDao dao) throws VendingMachinePersistenceException {
        this.dao = dao;
    }

    @Override
    public List<VendingMachineItem> getAvailableItems() {
        // Get the List of all items in the Dao
        // Parse through the list and create a new list based on what does not
        // have an inventory of 0
        return dao.readAll().stream()
                .filter(i -> i.getItemCount() > 0)
                .collect(Collectors.toList());

    }

    @Override
    public void setBalance(BigDecimal balance) {
        //Sets the balance here from what the Controller passed along
        this.balance = balance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Change vend(int itemId) throws InsufficientFundsException, VendingMachinePersistenceException {
        // Search the Dao for the item specified (using its itemId)
        // Get the price of that item
        // If the balance >= price, subtract 1 from the inventory of that item,
        // calculate change, and set balance to 0
        // If balance < price, throw an exception
        VendingMachineItem item = dao.readByID(itemId);
        BigDecimal price = item.getItemPrice();
        Change change;

        if (balance.compareTo(price) != -1) {
            item.setItemCount(item.getItemCount() - 1);
            dao.update(itemId, item);
            change = calculateChange(balance.subtract(price));
        } else {
            throw new InsufficientFundsException("Not enough funds.");
        }
        balance = null;

        return change;
    }

    @Override
    public Change calculateChange(BigDecimal changeToCalculate) {
        // Take the change (in pennies), start with the biggest denominations 
        // and start calcuating how many quarters/dimes/nickels/pennies they're
        // getting back. Save all those in a Change object.
        Change change = new Change();
        BigDecimal quarterValue = new BigDecimal(".25");
        BigDecimal dimeValue = new BigDecimal(".10");
        BigDecimal nickelValue = new BigDecimal(".05");
        BigDecimal pennyValue = new BigDecimal(".01");

        if (changeToCalculate.compareTo(quarterValue) != -1) {
            int quarters = changeToCalculate.divide(quarterValue, RoundingMode.FLOOR).intValue();
            change.setQuarters(quarters);
            changeToCalculate = changeToCalculate.subtract(quarterValue.multiply(new BigDecimal(quarters)));
        }

        if (changeToCalculate.compareTo(dimeValue) != -1) {
            int dimes = changeToCalculate.divide(dimeValue, RoundingMode.FLOOR).intValue();
            change.setDimes(dimes);
            changeToCalculate = changeToCalculate.subtract(dimeValue.multiply(new BigDecimal(dimes)));
        }

        if (changeToCalculate.compareTo(nickelValue) != -1) {
            int nickels = changeToCalculate.divide(nickelValue, RoundingMode.FLOOR).intValue();
            change.setNickels(nickels);
            changeToCalculate = changeToCalculate.subtract(nickelValue.multiply(new BigDecimal(nickels)));
        }

        if (changeToCalculate.compareTo(pennyValue) != -1) {
            int pennies = changeToCalculate.divide(pennyValue, RoundingMode.FLOOR).intValue();
            change.setPennies(pennies);
        }

        return change;
    }
}
