/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

/**
 *
 * @author Alex
 */
public class VendingMachineDuplicateIDException extends Exception {

    public VendingMachineDuplicateIDException(String message) {
        super(message);
    }

    public VendingMachineDuplicateIDException(String message, Throwable cause) {
        super(message, cause);
    }

}
