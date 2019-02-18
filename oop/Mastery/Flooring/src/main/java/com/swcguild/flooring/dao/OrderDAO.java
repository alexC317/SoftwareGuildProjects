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

    public void create(LocalDate orderDate, Order newOrder) throws FlooringPersistenceException;

    public List<Order> readAll(LocalDate orderDate) throws FlooringPersistenceException;

    public Order readById(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException;

    public void update(LocalDate orderDate, int orderNumber, Order updatedOrder) throws FlooringPersistenceException;

    public void delete(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException;

}
