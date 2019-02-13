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
public class TaxDAOTest {

    private TaxDAO taxDAO;

    public TaxDAOTest() throws Exception {
        taxDAO = new TaxDAOFileImpl();
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
     * Test of readAll method, of class TaxDAO.
     */
    @Test
    public void testReadAll() {
        assertEquals(4, taxDAO.readAll().size());
    }

    /**
     * Test of readById method, of class TaxDAO.
     */
    @Test
    public void testReadById() {
        assertNotNull(taxDAO.readById("OH"));
        assertEquals(new BigDecimal("6.25"), taxDAO.readById("OH").getTaxRate());

        assertNotNull(taxDAO.readById("PA"));
        assertEquals(new BigDecimal("6.75"), taxDAO.readById("PA").getTaxRate());

        assertNotNull(taxDAO.readById("MI"));
        assertEquals(new BigDecimal("5.75"), taxDAO.readById("MI").getTaxRate());

        assertNotNull(taxDAO.readById("IN"));
        assertEquals(new BigDecimal("6.00"), taxDAO.readById("IN").getTaxRate());
        
        assertNull(taxDAO.readById("NY"));
    }

}
