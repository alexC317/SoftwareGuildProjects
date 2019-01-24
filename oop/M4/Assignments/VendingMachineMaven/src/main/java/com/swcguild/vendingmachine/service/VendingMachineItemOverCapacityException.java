/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.service;

/**
 *
 * @author Alex
 */
public class VendingMachineItemOverCapacityException extends Exception {

    public VendingMachineItemOverCapacityException(String message) {
        super(message);
    }

    public VendingMachineItemOverCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

}
