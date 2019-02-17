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
     * Test of create method, of class OrderDAO.
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

        BigDecimal area = newOrder.getArea().setScale(2, RoundingMode.HALF_UP);
        BigDecimal cpsf = newOrder.getCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);
        BigDecimal lcpsf = newOrder.getLaborCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);

        BigDecimal materialCost = area.multiply(cpsf).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCost = area.multiply(lcpsf).setScale(2, RoundingMode.HALF_UP);

        newOrder.setMaterialCost(materialCost);
        newOrder.setLaborCost(laborCost);

        BigDecimal taxPercent = newOrder.getTaxRate().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal materialTax = materialCost.multiply(taxPercent).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborTax = materialCost.multiply(taxPercent).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalTax = materialTax.add(laborTax).setScale(2, RoundingMode.HALF_UP);

        newOrder.setTax(totalTax);

        BigDecimal total = materialCost.add(laborCost.add(totalTax).setScale(2, RoundingMode.HALF_UP));

        newOrder.setTotal(total);
        LocalDate testDate = LocalDate.parse("2018-01-01");

        orderDAO.create(testDate, newOrder);

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

        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Porras");
        newOrder2.setStateName("OH");
        newOrder2.setTaxRate(new BigDecimal("6.25"));
        newOrder2.setProductType("Carpet");
        newOrder2.setArea(new BigDecimal("10.00"));
        newOrder2.setCostPerSquareFoot(new BigDecimal("2.25"));
        newOrder2.setLaborCostPerSquareFoot(new BigDecimal("2.10"));

        LocalDate testDate = LocalDate.parse("2018-01-01");
        orderDAO.create(testDate, newOrder);
        orderDAO.create(testDate, newOrder2);

        assertEquals(2, orderDAO.readAll(testDate).size());

    }

    /**
     * Test of readById method, of class OrderDAO.
     */
    @Test
    public void testReadById() throws Exception {
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));

        LocalDate testDate = LocalDate.parse("2018-01-01");
        orderDAO.create(testDate, newOrder);

        Order fromDAO = orderDAO.readById(testDate, 1);
        assertEquals(fromDAO, newOrder);

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
        BigDecimal area = newOrder.getArea().setScale(2, RoundingMode.HALF_UP);
        BigDecimal cpsf = newOrder.getCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);
        BigDecimal lcpsf = newOrder.getLaborCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);

        BigDecimal materialCost = area.multiply(cpsf).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCost = area.multiply(lcpsf).setScale(2, RoundingMode.HALF_UP);

        newOrder.setMaterialCost(materialCost);
        newOrder.setLaborCost(laborCost);

        BigDecimal taxPercent = newOrder.getTaxRate().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal materialTax = materialCost.multiply(taxPercent).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborTax = materialCost.multiply(taxPercent).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalTax = materialTax.add(laborTax).setScale(2, RoundingMode.HALF_UP);

        newOrder.setTax(totalTax);

        BigDecimal total = materialCost.add(laborCost.add(totalTax).setScale(2, RoundingMode.HALF_UP));

        newOrder.setTotal(total);

        LocalDate testDate = LocalDate.parse("2018-01-01");
        orderDAO.create(testDate, newOrder);

        Order updateOrder = new Order(1);
        newOrder.setCustomerName("Jacobs");
        newOrder.setProductType("Tile");

        orderDAO.update(testDate, 1, updateOrder);

        Order fromDAO = orderDAO.readById(testDate, 1);

        assertEquals(updateOrder, fromDAO);
        assertNotEquals("Cepeda", fromDAO.getCustomerName());
        assertEquals("Tile", fromDAO.getProductType());

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

        orderDAO.create(testDate, newOrder2);

        orderDAO.delete(testDate, 1);
        
        assertEquals(1, orderDAO.readAll(testDate).size());
        assertNull(orderDAO.readById(testDate, 1));
        assertNotNull(orderDAO.readById(testDate, 2));
    }

}
