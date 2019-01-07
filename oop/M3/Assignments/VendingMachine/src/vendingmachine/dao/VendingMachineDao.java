/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import vendingmachine.dto.VendingMachineItem;

/**
 *
 * @author Alex
 */
public interface VendingMachineDao {
    
    /**
     *
     * @param item
     */
    public void create(VendingMachineItem item) throws VendingMachinePersistenceException;
    
    
    /**
     *
     * @return
     */
    public List<VendingMachineItem> readAll();

    /**
     *
     * @param itemId
     * @return
     */
    public VendingMachineItem readByID(int itemId);

    /**
     *
     * @param itemId
     * @param item
     * @throws VendingMachinePersistenceException
     */
    public void update(int itemId, VendingMachineItem item) throws VendingMachinePersistenceException;
}
