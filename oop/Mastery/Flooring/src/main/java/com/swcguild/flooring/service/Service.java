/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.service;

import com.swcguild.flooring.dao.FlooringPersistenceException;
import com.swcguild.flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface Service {

    /**
     * Displays all orders taken from the OrderDAO and sent to the Controller.
     *
     * @param orderDate Date associated with the orders to display.
     * @return a List of Orders associated with a date.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public List<Order> displayOrders(LocalDate orderDate) throws FlooringPersistenceException;

    /**
     * Gets an Order from the OrderDAO and sends it to the Controller.
     *
     * @param orderDate Date associated with the order to display.
     * @param orderNumber Order number associated with the order.
     * @return An Order object matching the description received.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     * @throws NoOrdersFoundException - If there is no order number for that
     * date found, then this Exception is thrown.
     */
    public Order getOrder(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException, NoOrdersFoundException;

    /**
     * Adds an Order from the Controller and sends it to the OrderDAO.
     *
     * @param newOrder The Order to be added to the OrderDAO.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     * @throws OrderValidationException - If the provided information is
     * invalid, this Exception is thrown.
     */
    public void addOrder(Order newOrder) throws FlooringPersistenceException, OrderValidationException;

    /**
     * Edits an existing Order.
     *
     * @param date The date associated with the Order to edit.
     * @param orderNum The order number of the Order to edit.
     * @param updatedOrder The updated version of the Order.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     * @throws OrderValidationException - If the provided information is
     * invalid, this Exception is thrown.
     * @throws NoOrdersFoundException - If there is no order number for that
     * date found, then this Exception is thrown.
     */
    public void editOrder(LocalDate date, int orderNum, Order updatedOrder) throws FlooringPersistenceException, OrderValidationException, NoOrdersFoundException;

    /**
     * Deletes an Order from the OrderDAO.
     *
     * @param date The date associated with the Order to edit.
     * @param orderNum The order number of the Order to edit.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public void removeOrder(LocalDate date, int orderNum) throws FlooringPersistenceException;

    /**
     * Saves pending creates, updates and deletes to the files.
     *
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public void saveCurrentWork() throws FlooringPersistenceException;
}
