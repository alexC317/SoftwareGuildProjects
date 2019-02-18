/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.service;

import com.swcguild.flooring.dao.FlooringPersistenceException;
import com.swcguild.flooring.dao.OrderDAO;
import com.swcguild.flooring.dao.ProductDAO;
import com.swcguild.flooring.dao.TaxDAO;
import com.swcguild.flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;

public class ServiceImpl implements Service {

    private TaxDAO taxDao;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public ServiceImpl(TaxDAO taxDao, ProductDAO productDAO, OrderDAO orderDAO) {
        this.taxDao = taxDao;
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> displayOrders(LocalDate orderDate) throws FlooringPersistenceException {
        List<Order> orders = orderDAO.readAll(orderDate);
        return orders;
    }

    @Override
    public void addOrder(Order newOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order editOrder(LocalDate date, int orderNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOrder(LocalDate date, int orderNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCurrentWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
