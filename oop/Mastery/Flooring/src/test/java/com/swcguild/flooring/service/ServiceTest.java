/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.service;

import com.swcguild.flooring.dao.FlooringPersistenceException;
import com.swcguild.flooring.dao.OrderDAO;
import com.swcguild.flooring.dao.OrderDAOProdFileImpl;
import com.swcguild.flooring.dao.ProductDAO;
import com.swcguild.flooring.dao.ProductDAOFileImpl;
import com.swcguild.flooring.dao.TaxDAO;
import com.swcguild.flooring.dao.TaxDAOFileImpl;
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
 * @author Alex
 */
public class ServiceTest {

    private Service service;

    public ServiceTest() throws Exception {
        TaxDAO taxDAO = new TaxDAOFileImpl();
        ProductDAO productDAO = new ProductDAOFileImpl();
        OrderDAO orderDAO = new OrderDAOProdFileImpl();

        service = new ServiceImpl(taxDAO, productDAO, orderDAO);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws FlooringPersistenceException {
        List<Order> orderList = service.displayOrders(LocalDate.now());
        for (Order currentOrder : orderList) {
            service.removeOrder(LocalDate.now(), currentOrder.getOrderNumber());
        }
    }

    /**
     * Test of displayOrders method, of class Service.
     */
    @Test
    public void testDisplayOrders() throws Exception {
        LocalDate testDate = LocalDate.parse("2018-01-01");
        List<Order> order = service.displayOrders(testDate);

        assertEquals(1, order.size());
        assertEquals(1, order.get(0).getOrderNumber());
    }

    /**
     * Test of addOrder method, of class Service.
     */
    @Test
    public void testAddOrder() throws FlooringPersistenceException, OrderValidationException {
        Order newOrder = new Order(0);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        //newOrder.setTaxRate(new BigDecimal("6.75"));
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
//        newOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
//        newOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
//        newOrder.setMaterialCost(new BigDecimal("515.00"));
//        newOrder.setLaborCost(new BigDecimal("475.00"));
//        newOrder.setTax(new BigDecimal("66.83"));
//        newOrder.setTotal(new BigDecimal("1056.83"));

        Order newOrder2 = new Order(0);
        newOrder2.setCustomerName("Hawkins");
        newOrder2.setStateName("OH");
        newOrder2.setProductType("Tile");
        newOrder2.setArea(new BigDecimal("100.00"));

        service.addOrder(newOrder);
        Order fromService = service.getOrder(LocalDate.now(), 1);

        assertEquals(fromService, newOrder);
        assertEquals(1, fromService.getOrderNumber());
        assertEquals(new BigDecimal("6.75"), fromService.getTaxRate());
        assertEquals(new BigDecimal("5.15"), fromService.getCostPerSquareFoot());
        assertEquals(new BigDecimal("4.75"), fromService.getLaborCostPerSquareFoot());
        assertEquals(new BigDecimal("515.00"), fromService.getMaterialCost());
        assertEquals(new BigDecimal("475.00"), fromService.getLaborCost());
        assertEquals(new BigDecimal("66.83"), fromService.getTax());
        assertEquals(new BigDecimal("1056.83"), fromService.getTotal());

    }

    /**
     * Test of addOrder method throwing an Exception, of class Service.
     */
    @Test
    public void testAddOrderWithExceptionThrown() throws FlooringPersistenceException, OrderValidationException {
        Order newOrder = new Order(0);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("NY");
        newOrder.setProductType("Metal");
        newOrder.setArea(new BigDecimal("100.00"));

        try {
            service.addOrder(newOrder);
            fail("Expected OrderValidationException not thrown.");
        } catch (OrderValidationException e) {
            return;
        }
    }

    /**
     * Test of editOrder method, of class Service.
     */
    @Test
    public void testEditOrder() throws FlooringPersistenceException, OrderValidationException {
        Order newOrder = new Order(0);
        newOrder.setCustomerName("Cepeda");
        newOrder.setStateName("PA");
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));

        service.addOrder(newOrder);

        Order updatedOrder = service.getOrder(LocalDate.now(), 1);
        updatedOrder.setCustomerName("Porras");
        updatedOrder.setStateName("OH");
        updatedOrder.setProductType("Tile");

        service.editOrder(LocalDate.now(), 1, updatedOrder);

        Order fromService = service.getOrder(LocalDate.now(), 1);
        assertEquals(1, fromService.getOrderNumber());
        assertEquals("OH", fromService.getStateName());
        assertEquals("Tile", fromService.getProductType());
        assertEquals(new BigDecimal("100.00"), fromService.getArea());
        assertEquals(new BigDecimal("812.81"), fromService.getTotal());
    }

    /**
     * Test of removeOrder method, of class Service.
     */
    @Test
    public void testRemoveOrder() throws FlooringPersistenceException, OrderValidationException {
        Order newOrder = new Order(0);
        newOrder.setCustomerName("Ryder");
        newOrder.setStateName("PA");
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));
        service.addOrder(newOrder);

        Order newOrder2 = new Order(0);
        newOrder2.setCustomerName("Hawkins");
        newOrder2.setStateName("OH");
        newOrder2.setProductType("Tile");
        newOrder2.setArea(new BigDecimal("100.00"));
        service.addOrder(newOrder2);
        assertEquals(2, service.displayOrders(LocalDate.now()).size());

        service.removeOrder(LocalDate.now(), 1);
        assertEquals(1, service.displayOrders(LocalDate.now()).size());
    }

    /**
     * Test of saveCurrentWork method, of class Service.
     */
    @Test
    public void testSaveCurrentWork() throws FlooringPersistenceException, OrderValidationException {
        Order newOrder = new Order(0);
        newOrder.setCustomerName("Ryder");
        newOrder.setStateName("PA");
        newOrder.setProductType("Wood");
        newOrder.setArea(new BigDecimal("100.00"));

        service.addOrder(newOrder);
        service.saveCurrentWork();

        assertEquals(newOrder, service.getOrder(LocalDate.now(), 1));
        service.removeOrder(LocalDate.now(), 1);
        service.saveCurrentWork();

        assertNull(service.getOrder(LocalDate.now(), 1));
    }

}
