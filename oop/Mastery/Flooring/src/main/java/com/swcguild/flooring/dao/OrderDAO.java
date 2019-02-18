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

    public void create(LocalDate date, Order order) throws FlooringPersistenceException;

    public List<Order> readAll(LocalDate date) throws FlooringPersistenceException;

    public Order readById(LocalDate date, int id) throws FlooringPersistenceException;

    public void update(LocalDate date, int id, Order order) throws FlooringPersistenceException;

    public void delete(LocalDate date, int id) throws FlooringPersistenceException;

}
