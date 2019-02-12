/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Order;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface OrderDAO {

    public void create(Order order);

    public List<Order> readAll();

    public Order readById(int id);

    public void update(int id);

    public void delete(int id);

}
