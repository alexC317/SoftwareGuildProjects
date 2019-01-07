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
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
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
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
        service = new VendingMachineServiceImpl(dao, auditDao);
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
        assertEquals(2, itemList.size());
    }

    /**
     * Test of setBalance method, of class VendingMachineService.
     */
    @Test
    public void testSetAndGetBalance() {
        BigDecimal balance = new BigDecimal("1.00");
        service.setBalance(balance);
        assertEquals(balance, service.getBalance());
    }

    /**
     * Test of vend method, of class VendingMachineService, assuming the balance
     * is equal to the price.
     *
     * @throws Exception
     */
    @Test
    public void testVendIfNoChange() throws Exception {
        //Test to see if the inventory of the item was successfully vended
        //Test to see if there was no change given
        BigDecimal balance = new BigDecimal("1.00");
        Change change;

        service.setBalance(balance);
        change = service.vend(1);

        List<VendingMachineItem> itemList = service.getAvailableItems();
        assertEquals(0, itemList.get(1).getItemCount());

        assertEquals(0, change.getQuarters());
        assertEquals(0, change.getDimes());
        assertEquals(0, change.getNickels());
        assertEquals(0, change.getPennies());
        assertNull(service.getBalance());
    }

    /**
     * Test of vend method, of class VendingMachineService, assuming the balance
     * is more than the price.
     *
     * @throws Exception
     */
    @Test
    public void testVendIfChange() throws Exception {
        //Test to see if the inventory of the item was successfully vended
        //Test to see if there was correct change given
        BigDecimal balance = new BigDecimal("1.50");
        Change change;

        service.setBalance(balance);
        change = service.vend(1);

        List<VendingMachineItem> itemList = service.getAvailableItems();
        assertEquals(0, itemList.get(1).getItemCount());

        assertEquals(2, change.getQuarters());
        assertEquals(0, change.getDimes());
        assertEquals(0, change.getNickels());
        assertEquals(0, change.getPennies());
        assertNull(service.getBalance());

    }

    /**
     * Test of vend method of class VendingMachineService, assuming the balance
     * is less than the price.
     *
     * @throws Exception
     */
    @Test
    public void testVendIfNoEnoughBalance() throws Exception {
        //Test to see if the inventory of the item was not successfully vended
        //Test to see if there was an Exception thrown
        BigDecimal balance = new BigDecimal(".50");
        Change change;
        try {
            service.setBalance(balance);
            change = service.vend(1);
            fail("Expected InsufficientFundsException was not thrown");
        } catch (InsufficientFundsException e) {
            return;
        }

    }

    /**
     * Test of calculateChange method, of class VendingMachineService.
     */
    @Test
    public void testCalculateChange() {
        BigDecimal dollar = new BigDecimal("1.00");
        BigDecimal seventyCents = new BigDecimal(".70");
        BigDecimal fourtyTwoCents = new BigDecimal(".42");
        BigDecimal sevenCents = new BigDecimal(".07");

        Change change1 = service.calculateChange(dollar);
        Change change2 = service.calculateChange(seventyCents);
        Change change3 = service.calculateChange(fourtyTwoCents);
        Change change4 = service.calculateChange(sevenCents);

        assertEquals(4, change1.getQuarters());
        assertEquals(0, change1.getDimes());
        assertEquals(0, change1.getNickels());
        assertEquals(0, change1.getPennies());

        assertEquals(2, change2.getQuarters());
        assertEquals(2, change2.getDimes());
        assertEquals(0, change2.getNickels());
        assertEquals(0, change2.getPennies());

        assertEquals(1, change3.getQuarters());
        assertEquals(1, change3.getDimes());
        assertEquals(1, change3.getNickels());
        assertEquals(2, change3.getPennies());

        assertEquals(0, change4.getQuarters());
        assertEquals(0, change4.getDimes());
        assertEquals(1, change4.getNickels());
        assertEquals(2, change4.getPennies());
    }

}
