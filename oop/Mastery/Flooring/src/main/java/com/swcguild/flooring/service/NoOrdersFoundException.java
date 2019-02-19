/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.service;

/**
 *
 * @author Alex
 */
public class NoOrdersFoundException extends Exception {

    public NoOrdersFoundException(String message) {
        super(message);
    }

    public NoOrdersFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
