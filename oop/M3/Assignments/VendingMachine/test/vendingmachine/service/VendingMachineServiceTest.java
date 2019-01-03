/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;

/**
 *
 * @author Alex
 */
public class VendingMachineServiceTest {
    
    public VendingMachineServiceTest() {
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
     * Test of getAvailableItems method, of class VendingMachineService.
     */
    @Test
    public void testGetAvailableItems() {
    }

    /**
     * Test of setBalance method, of class VendingMachineService.
     */
    @Test
    public void testSetBalance() {
    }

    /**
     * Test of vend method, of class VendingMachineService.
     */
    @Test
    public void testVend() {
    }

    /**
     * Test of calculateChange method, of class VendingMachineService.
     */
    @Test
    public void testCalculateChange() {
    }

    public class VendingMachineServiceImpl implements VendingMachineService {

        public List<VendingMachineItem> getAvailableItems() {
            return null;
        }

        public void setBalance(BigDecimal balance) {
        }

        public void vend(int itemId) {
        }

        public Change calculateChange(BigDecimal change) {
            return null;
        }
    }
    
}
