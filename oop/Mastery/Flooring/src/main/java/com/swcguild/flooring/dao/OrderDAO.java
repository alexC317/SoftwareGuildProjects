/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface OrderDAO {

    /**
     * Adds a new Order to the currentOrders Map.
     *
     * @param orderDate Takes in the currentDate from the Service layer.
     * @param newOrder Takes in a new Order object from the Service layer.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public void create(LocalDate orderDate, Order newOrder) throws FlooringPersistenceException;

    /**
     * Sends a List of all Order objects from a specific date.
     *
     * @param orderDate The date to search for.
     * @return All the Orders associated with the order date.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public List<Order> readAll(LocalDate orderDate) throws FlooringPersistenceException;

    /**
     * Returns a singular Order associated with a date and order number.
     *
     * @param orderDate The date to search for.
     * @param orderNumber The order number to look for.
     * @return An Order object if it exists.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public Order readById(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException;

    /**
     * Updates an Order associated with a date and order number.
     *
     * @param orderDate The date to look for.
     * @param orderNumber The order number to look for.
     * @param updatedOrder The updated order to place.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public void update(LocalDate orderDate, int orderNumber, Order updatedOrder) throws FlooringPersistenceException;

    /**
     * ** Deletes an Order associated with a date and order number.
     *
     * @param orderDate The date to search for.
     * @param orderNumber The order number to look for.
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public void delete(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException;

    /**
     * Writes all pending creates, updates and deletes to the files.
     *
     * @throws FlooringPersistenceException - If the file cannot be written/read
     * from, then we have an Exception thrown.
     */
    public void save() throws FlooringPersistenceException;

    public List<Order> getAllExistingOrders(LocalDate orderDate) throws FlooringPersistenceException;
}
