/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acetip
 */
public class OrderDAOTest {

    private OrderDAO orderDAO;

    public OrderDAOTest() {
        orderDAO = new OrderDAOFileImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        LocalDate testDate = LocalDate.parse("2019-02-13");
        List<Order> orderList = orderDAO.readAll(testDate);
        for (Order order : orderList) {
            orderDAO.delete(testDate, order.getOrderNumber());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class OrderDAO.
     */
    @Test
    public void testCreateAndReadById() {
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));

        BigDecimal area = newOrder.getArea();
        BigDecimal cpsf = newOrder.getCostPerSquareFoot();
        BigDecimal lcpsf = newOrder.getLaborCostPerSquareFoot();

        BigDecimal materialCost = area.multiply(cpsf);
        BigDecimal laborCost = area.multiply(lcpsf);

        newOrder.setMaterialCost(materialCost);
        newOrder.setLaborCost(laborCost);

        BigDecimal taxPercent = newOrder.getTaxRate().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal materialTax = materialCost.multiply(taxPercent);
        BigDecimal laborTax = materialCost.multiply(taxPercent);
        BigDecimal totalTax = materialTax.add(laborTax);

        newOrder.setTax(totalTax);

        BigDecimal total = materialCost.add(laborCost.add(totalTax));

        newOrder.setTotal(total);
        LocalDate testDate = LocalDate.parse("2019-02-13");

        orderDAO.create(testDate, newOrder);

        Order fromDAO = orderDAO.readById(testDate, 1);
        assertEquals(fromDAO, newOrder);
    }

    /**
     * Test of readAll method, of class OrderDAO.
     */
    @Test
    public void testReadAll() {
    }

    /**
     * Test of readById method, of class OrderDAO.
     */
    @Test
    public void testReadById() {
    }

    /**
     * Test of update method, of class OrderDAO.
     */
    @Test
    public void testUpdate() {
    }

    /**
     * Test of delete method, of class OrderDAO.
     */
    @Test
    public void testDelete() {
    }

}
