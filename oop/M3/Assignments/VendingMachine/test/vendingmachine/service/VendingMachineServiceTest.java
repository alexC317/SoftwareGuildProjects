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
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoStubImpl;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachineItem;

/**
 *
 * @author Alex
 */
public class VendingMachineServiceTest {

    private VendingMachineService service;

    public VendingMachineServiceTest() throws Exception {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        service = new VendingMachineServiceImpl(dao);
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
        List<VendingMachineItem> itemList = service.getAvailableItems();
        assertEquals(1, itemList.size());
    }

    /**
     * Test of setBalance method, of class VendingMachineService.
     */
    @Test
    public void testSetAndGetBalance() {
        BigDecimal balance = new BigDecimal("1.00");
        service.setBalance(balance);
        assertEquals(balance.toString(), service.getBalance().toString());
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

}
