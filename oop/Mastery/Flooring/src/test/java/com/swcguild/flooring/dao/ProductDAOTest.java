/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooring.dao;

import java.math.BigDecimal;
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
public class ProductDAOTest {

    private ProductDAO productDAO;

    public ProductDAOTest() throws Exception {
        productDAO = new ProductDAOFileImpl();
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
     * Test of readAll method, of class ProductDAO.
     */
    @Test
    public void testReadAll() {
        assertEquals(4, productDAO.readAll().size());
    }

    /**
     * Test of readById method, of class ProductDAO.
     */
    @Test
    public void testReadById() {
        assertNotNull(productDAO.readById("Carpet"));
        assertEquals(new BigDecimal("2.25"), productDAO.readById("Carpet").getCostPerSquareFoot());
        
        assertNotNull(productDAO.readById("Laminate"));
        assertNotNull(productDAO.readById("Tile"));
        assertNotNull(productDAO.readById("Wood"));
    }

}
