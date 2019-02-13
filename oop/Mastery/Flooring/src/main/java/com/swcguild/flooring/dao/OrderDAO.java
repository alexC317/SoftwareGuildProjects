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

    public void create(LocalDate date, Order order);

    public List<Order> readAll(LocalDate date);

    public Order readById(LocalDate date, int id);

    public void update(LocalDate date, int id);

    public void delete(LocalDate date, int id);

}
