/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import com.swcguild.vendingmachine.dao.VendingMachineAuditDao;
import com.swcguild.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.swcguild.vendingmachine.dao.VendingMachineDao;
import com.swcguild.vendingmachine.dto.Change;
import com.swcguild.vendingmachine.dto.VendingMachineItem;
import com.swcguild.vendingmachine.service.InsufficientFundsException;
import com.swcguild.vendingmachine.service.VendingMachineDataValidationException;
import com.swcguild.vendingmachine.service.VendingMachineDuplicateIDException;
import com.swcguild.vendingmachine.service.VendingMachineServiceLayer;
import com.swcguild.vendingmachine.service.VendingMachineServiceLayerImpl;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import vendingmachine.dao.VendingMachineDaoStubImpl;

/**
 *
 * @author Alex
 */
public class VendingMachineServiceTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceTest() throws Exception {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
        service = new VendingMachineServiceLayerImpl(dao, auditDao);
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

    @Test
    public void testAddNewItem() throws Exception {
        VendingMachineItem newItem = new VendingMachineItem(3);
        newItem.setItemName("Powerade");
        newItem.setItemCount(6);
        newItem.setItemPrice(new BigDecimal("1.50"));

        service.addNewItem(newItem);
        List<VendingMachineItem> itemList = service.getAvailableItems();

        assertNotNull(itemList.get(2));
        assertEquals("Powerade", itemList.get(2).getItemName());
    }

    @Test
    public void testAddNewItemWithDuplicateId() throws Exception {
        VendingMachineItem newItem = new VendingMachineItem(3);
        newItem.setItemName("Powerade");
        newItem.setItemCount(6);
        newItem.setItemPrice(new BigDecimal("1.50"));

        service.addNewItem(newItem);

        VendingMachineItem newItem2 = new VendingMachineItem(3);
        newItem.setItemName("Brawndo");
        newItem.setItemCount(6);
        newItem.setItemPrice(new BigDecimal("1.40"));

        try {
            service.addNewItem(newItem2);
            fail("Expected VendingMachineDuplicateIDException was not thrown.");
        } catch (VendingMachineDuplicateIDException e) {
            return;
        }
    }

    @Test
    public void testAddNewItemWithInvalidData() throws Exception {
        VendingMachineItem newItem2 = new VendingMachineItem(3);
        newItem2.setItemName("Brawndo");
        newItem2.setItemCount(6);

        try {
            service.addNewItem(newItem2);
            fail("Expected VendingMachineDataValidationException was not thrown.");
        } catch (VendingMachineDataValidationException e) {
            return;
        }
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

    @Test
    public void testRestock() throws Exception {
        List<VendingMachineItem> itemList = service.getAvailableItems();
        service.restock(1, 3);

        assertEquals(4, itemList.get(0).getItemCount());
    }
}
