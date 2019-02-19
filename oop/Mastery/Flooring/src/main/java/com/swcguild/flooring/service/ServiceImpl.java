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
import com.swcguild.flooring.dto.Product;
import com.swcguild.flooring.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class ServiceImpl implements Service {

    private TaxDAO taxDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public ServiceImpl(TaxDAO taxDAO, ProductDAO productDAO, OrderDAO orderDAO) {
        this.taxDAO = taxDAO;
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> displayOrders(LocalDate orderDate) throws FlooringPersistenceException {
        List<Order> orders = orderDAO.readAll(orderDate);
        return orders;
    }

    @Override
    public Order getOrder(LocalDate orderDate, int orderNumber) throws FlooringPersistenceException {
        return orderDAO.readById(orderDate, orderNumber);
    }

    @Override
    public void addOrder(Order newOrder) throws FlooringPersistenceException, OrderValidationException {
        validateUserInformation(newOrder);
        newOrder = completeOrderInformation(newOrder);
        orderDAO.create(LocalDate.now(), newOrder);
    }

    @Override
    public void editOrder(LocalDate date, int orderNum, Order updatedOrder) throws FlooringPersistenceException, OrderValidationException {
        Order originalOrder = getOrder(date, orderNum);
    }

    @Override
    public void removeOrder(LocalDate date, int orderNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCurrentWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validateUserInformation(Order newOrder) throws OrderValidationException {
        if (newOrder.getCustomerName() == null
                || newOrder.getCustomerName().trim().length() == 0
                || newOrder.getProductType() == null
                || newOrder.getProductType().trim().length() == 0
                || newOrder.getArea() == null
                || newOrder.getArea().equals(new BigDecimal("0.00"))
                || newOrder.getStateName() == null
                || newOrder.getStateName().trim().length() == 0) {
            throw new OrderValidationException("ERROR: All fields [Name, Product Type, Area and State Name] are required.");
        }
    }

    private Order completeOrderInformation(Order newOrder) throws OrderValidationException {
        List<Product> productList = productDAO.readAll();
        List<Tax> taxList = taxDAO.readAll();

        for (Product currentProduct : productList) {
            if (newOrder.getProductType().equals(currentProduct.getProductType())) {
                newOrder.setCostPerSquareFoot(currentProduct.getCostPerSquareFoot());
                newOrder.setLaborCostPerSquareFoot(currentProduct.getLaborCostPerSquareFoot());
            }
        }

        if (newOrder.getCostPerSquareFoot() == null || newOrder.getLaborCostPerSquareFoot() == null) {
            throw new OrderValidationException("Invalid Product Type entered.");
        }

        for (Tax currentTax : taxList) {
            if (newOrder.getStateName().equals(currentTax.getStateName())) {
                newOrder.setTaxRate(currentTax.getTaxRate());
            }
        }

        if (newOrder.getTaxRate() == null) {
            throw new OrderValidationException("Invalid State Name entered.");
        }

        BigDecimal area = newOrder.getArea().setScale(2, RoundingMode.HALF_UP);
        BigDecimal cpsf = newOrder.getCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);
        BigDecimal lcpsf = newOrder.getLaborCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);

        BigDecimal materialCost = area.multiply(cpsf).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCost = area.multiply(lcpsf).setScale(2, RoundingMode.HALF_UP);

        newOrder.setMaterialCost(materialCost);
        newOrder.setLaborCost(laborCost);

        BigDecimal subTotal = materialCost.add(laborCost);
        BigDecimal taxPercent = newOrder.getTaxRate().divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
        System.out.println(taxPercent);
        BigDecimal totalTax = taxPercent.multiply(subTotal).setScale(2, RoundingMode.HALF_UP);
        System.out.println(totalTax);
        newOrder.setTax(totalTax);

        BigDecimal total = materialCost.add(laborCost.add(totalTax).setScale(2, RoundingMode.HALF_UP));

        newOrder.setTotal(total);

        return newOrder;
    }

}