/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendingMachineItem readByID(int itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int itemId, VendingMachineItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void writeInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
