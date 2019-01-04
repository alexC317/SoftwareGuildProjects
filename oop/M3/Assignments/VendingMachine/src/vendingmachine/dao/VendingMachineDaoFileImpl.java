/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.dto.VendingMachineItem;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<Integer, VendingMachineItem> items = new HashMap<>();

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    // LOAD THE FILE INTO MEMORY IN THE CONSTRUCTOR
    @Override
    public List<VendingMachineItem> readAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public VendingMachineItem readByID(int itemId) {
        if (items.containsKey(itemId)) {
            return items.get(itemId);
        } else {
            return null;
        }
    }

    @Override
    public void update(int itemId, VendingMachineItem item) {
        if (items.containsKey(itemId)) {
            if (items.get(itemId).getItemName().equals(item.getItemName())) {
            } else {
                items.get(itemId).setItemName(item.getItemName());
            }

            if (items.get(itemId).getItemCount() == item.getItemCount()) {
            } else {
                items.get(itemId).setItemCount(item.getItemCount());
            }

            if (items.get(itemId).getItemPrice().equals(item.getItemPrice())) {
            } else {
                items.get(itemId).setItemPrice(item.getItemPrice());
            }
        }
    }

    private void loadInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void writeInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
