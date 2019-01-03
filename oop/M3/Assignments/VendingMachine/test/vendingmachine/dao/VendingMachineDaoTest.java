/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dto.VendingMachineItem;

/**
 *
 * @author Alex
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readAll method, of class VendingMachineDao.
     */
    @Test
    public void testReadAll() {
        List<VendingMachineItem> items = dao.readAll();
        assertEquals(1, items.size());
    }

    /**
     * Test of readByID method, of class VendingMachineDao.
     */
    @Test
    public void testReadByID() {
        
    }

    /**
     * Test of update method, of class VendingMachineDao.
     */
    @Test
    public void testUpdate() {
    }

}
