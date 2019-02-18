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

    public List<Order> displayOrders(LocalDate date) throws FlooringPersistenceException;

    public Order getOrder(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException;

    public void addOrder(Order newOrder) throws FlooringPersistenceException, OrderValidationException;

    public Order editOrder(LocalDate date, int orderNum);

    public void removeOrder(LocalDate date, int orderNum);

    public void saveCurrentWork();
}
