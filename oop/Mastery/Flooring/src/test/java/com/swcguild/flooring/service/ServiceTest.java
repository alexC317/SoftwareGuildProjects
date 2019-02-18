/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.service;

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
    
    public ServiceTest() {
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
    public void testDisplayOrders() {
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

    public class ServiceImpl implements Service {

        public List<Order> displayOrders(LocalDate date) {
            return null;
        }

        public void addOrder(Order newOrder) {
        }

        public Order editOrder(LocalDate date, int orderNum) {
            return null;
        }

        public void removeOrder(LocalDate date, int orderNum) {
        }

        public void saveCurrentWork() {
        }
    }
    
}
