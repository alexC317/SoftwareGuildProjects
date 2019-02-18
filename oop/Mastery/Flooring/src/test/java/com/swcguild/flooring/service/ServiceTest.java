/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.service;

import com.swcguild.flooring.dao.OrderDAO;
import com.swcguild.flooring.dao.OrderDAOProdFileImpl;
import com.swcguild.flooring.dao.ProductDAO;
import com.swcguild.flooring.dao.ProductDAOFileImpl;
import com.swcguild.flooring.dao.TaxDAO;
import com.swcguild.flooring.dao.TaxDAOFileImpl;
import com.swcguild.flooring.dto.Order;
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
    public void tearDown() {
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
    public void testAddOrder() {
    }

    /**
     * Test of editOrder method, of class Service.
     */
    @Test
    public void testEditOrder() {
    }

    /**
     * Test of removeOrder method, of class Service.
     */
    @Test
    public void testRemoveOrder() {
    }

    /**
     * Test of saveCurrentWork method, of class Service.
     */
    @Test
    public void testSaveCurrentWork() {
    }

}
