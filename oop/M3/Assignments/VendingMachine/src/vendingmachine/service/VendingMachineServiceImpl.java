/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;

public class VendingMachineServiceImpl implements VendingMachineService {

    private BigDecimal balance;
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) throws VendingMachinePersistenceException {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addNewItem(VendingMachineItem item) throws
            VendingMachineDuplicateIDException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        if (dao.readByID(item.getItemId()) != null) {
            auditDao.writeAuditEntry("ID already in use.");
            throw new VendingMachineDuplicateIDException("This ID is already in use. Please select another and try again.");
        }
        validateItem(item);
        dao.create(item);
        auditDao.writeAuditEntry(item.getItemName() + " added to the Vending Machine.");
    }

    @Override
    public List<VendingMachineItem> getAvailableItems() {
        return dao.readAll();
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Change vend(int itemId) throws InsufficientFundsException, VendingMachinePersistenceException, ItemOutOfStockException {
        VendingMachineItem item = dao.readByID(itemId);
        BigDecimal price = item.getItemPrice();
        Change change;

        if (item.getItemCount() == 0) {
            String message = "Item not in stock.";
            auditDao.writeAuditEntry(message);
            throw new ItemOutOfStockException(message);
        }
        if (balance.compareTo(price) != -1) {
            item.setItemCount(item.getItemCount() - 1);
            dao.update(itemId, item);
            change = calculateChange(balance.subtract(price));
        } else {
            String message = "Not enough funds.";
            auditDao.writeAuditEntry(message);
            throw new InsufficientFundsException(message);
        }
        balance = null;

        return change;
    }

    @Override
    public Change calculateChange(BigDecimal changeToCalculate) {
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

    private void validateItem(VendingMachineItem item) throws VendingMachineDataValidationException {
        if (item.getItemName() == null
                || item.getItemName().trim().length() == 0
                || item.getItemCount() <= 0
                || item.getItemPrice() == null
                || item.getItemPrice().compareTo(new BigDecimal("0.00")) != 1) {
            throw new VendingMachineDataValidationException("ERROR: All fields [Item Name, Item Count, Item Price] must be valid.");
        }
    }

    @Override
    public void restock(int itemId, int resupplyAmount) throws VendingMachinePersistenceException, VendingMachineItemOverCapacityException {
        VendingMachineItem item = dao.readByID(itemId);
        int currentCount = item.getItemCount();
        if (resupplyAmount + currentCount > 10) {
            throw new VendingMachineItemOverCapacityException("More than 10 of this item in the machine.");
        }
        item.setItemCount(resupplyAmount + currentCount);
        dao.update(itemId, item);
    }
}
