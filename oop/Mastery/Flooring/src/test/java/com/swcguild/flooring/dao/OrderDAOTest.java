/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import com.swcguild.flooring.dto.Order;
import java.math.BigDecimal;
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
        orderDAO = new OrderDAOProdFileImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        LocalDate testDate = LocalDate.parse("2018-01-01");
        List<Order> orderList = orderDAO.readAll(testDate);
        for (Order order : orderList) {
            orderDAO.delete(testDate, order.getOrderNumber());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create and readById method, of class OrderDAO.
     */
    @Test
    public void testCreateAndReadById() throws Exception {
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        newOrder.setMaterialCost(new BigDecimal("515.00"));
        newOrder.setLaborCost(new BigDecimal("475"));
        newOrder.setTax(new BigDecimal("61.88"));
        newOrder.setTotal(new BigDecimal("1051.88"));

        LocalDate testDate = LocalDate.parse("2018-01-01");

        orderDAO.create(testDate, newOrder);
        //orderDAO.save();

        Order fromDAO = orderDAO.readById(testDate, 1);
        assertEquals(fromDAO, newOrder);

    }

    /**
     * Test of readAll method, of class OrderDAO.
     */
    @Test
    public void testReadAll() throws Exception {
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        newOrder.setMaterialCost(new BigDecimal("515.00"));
        newOrder.setLaborCost(new BigDecimal("475"));
        newOrder.setTax(new BigDecimal("66.83"));
        newOrder.setTotal(new BigDecimal("1056.83"));

        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Porras");
        newOrder2.setStateName("OH");
        newOrder2.setTaxRate(new BigDecimal("6.25"));
        newOrder2.setProductType("Carpet");
        newOrder2.setArea(new BigDecimal("10.00"));
        newOrder2.setCostPerSquareFoot(new BigDecimal("2.25"));
        newOrder2.setLaborCostPerSquareFoot(new BigDecimal("2.10"));
        newOrder2.setMaterialCost(new BigDecimal("22.50"));
        newOrder2.setLaborCost(new BigDecimal("21"));
        newOrder2.setTax(new BigDecimal("2.72"));
        newOrder2.setTotal(new BigDecimal("46.22"));

        LocalDate testDate = LocalDate.parse("2018-01-02");
        orderDAO.create(testDate, newOrder);
        orderDAO.create(testDate, newOrder2);
        orderDAO.save();
        
        assertEquals(2, orderDAO.readAll(testDate).size());

    }

    /**
     * Test of update method, of class OrderDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        newOrder.setMaterialCost(new BigDecimal("515.00"));
        newOrder.setLaborCost(new BigDecimal("475"));
        newOrder.setTax(new BigDecimal("66.83"));
        newOrder.setTotal(new BigDecimal("1056.83"));

        LocalDate testDate = LocalDate.parse("2018-01-01");
        orderDAO.create(testDate, newOrder);
        orderDAO.save();

        Order updateOrder = new Order(1);
        updateOrder.setCustomerName("Jacobs");
        updateOrder.setStateName("PA");
        updateOrder.setTaxRate(new BigDecimal("6.75"));
        updateOrder.setProductType("Wood");
        updateOrder.setArea(new BigDecimal("100.00"));
        updateOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        updateOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        updateOrder.setMaterialCost(new BigDecimal("515.00"));
        updateOrder.setLaborCost(new BigDecimal("475"));
        updateOrder.setTax(new BigDecimal("66.83"));
        updateOrder.setTotal(new BigDecimal("1056.83"));

        orderDAO.update(testDate, 1, updateOrder);
        orderDAO.save();

        Order fromDAO = orderDAO.readById(testDate, 1);

        assertEquals(updateOrder, fromDAO);
        assertNotEquals("Cepeda", fromDAO.getCustomerName());

    }

    /**
     * Test of delete method, of class OrderDAO.
     */
    @Test
    public void testDelete() throws Exception {
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        newOrder.setMaterialCost(new BigDecimal("515.00"));
        newOrder.setLaborCost(new BigDecimal("475"));
        newOrder.setTax(new BigDecimal("66.83"));
        newOrder.setTotal(new BigDecimal("1056.83"));

        LocalDate testDate = LocalDate.parse("2018-01-01");
        orderDAO.create(testDate, newOrder);

        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Porras");
        newOrder2.setStateName("OH");
        newOrder2.setTaxRate(new BigDecimal("6.25"));
        newOrder2.setProductType("Carpet");
        newOrder2.setArea(new BigDecimal("10.00"));
        newOrder2.setCostPerSquareFoot(new BigDecimal("2.25"));
        newOrder2.setLaborCostPerSquareFoot(new BigDecimal("2.10"));
        newOrder2.setMaterialCost(new BigDecimal("22.50"));
        newOrder2.setLaborCost(new BigDecimal("21"));
        newOrder2.setTax(new BigDecimal("2.72"));
        newOrder2.setTotal(new BigDecimal("46.22"));

        orderDAO.create(testDate, newOrder2);
        orderDAO.save();

        orderDAO.delete(testDate, 1);
        orderDAO.save();

        assertEquals(1, orderDAO.readAll(testDate).size());
        assertNull(orderDAO.readById(testDate, 1));
        assertNotNull(orderDAO.readById(testDate, 2));

    }

}
