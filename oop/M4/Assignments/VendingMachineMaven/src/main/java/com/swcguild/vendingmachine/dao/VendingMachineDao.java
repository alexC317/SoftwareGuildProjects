/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.dao;

import com.swcguild.vendingmachine.dto.VendingMachineItem;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface VendingMachineDao {

    /**
     * Creates a new item to place into memory.
     *
     * @param item The item to be saved into memory.
     * @throws VendingMachinePersistenceException
     */
    public void create(VendingMachineItem item) throws VendingMachinePersistenceException;

    /**
     * Returns a list of all VendingMachineItems saved in the DAO.
     *
     * @return A list of type VendingMachineItem/
     */
    public List<VendingMachineItem> readAll();

    /**
     * Returns an object saved in the HashMap, referenced by its id.
     *
     * @param itemId
     * @return
     */
    public VendingMachineItem readByID(int itemId);

    /**
     * Updates an item using the VendingMachineItem passed into it as reference.
     *
     * @param itemId
     * @param item
     * @throws VendingMachinePersistenceException
     */
    public void update(int itemId, VendingMachineItem item) throws VendingMachinePersistenceException;

}
