/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

/**
 *
 * @author Alex
 */
public interface VendingMachineAuditDao {

    /**
     *
     * @param entry
     * @throws VendingMachinePersistenceException
     */
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
}
