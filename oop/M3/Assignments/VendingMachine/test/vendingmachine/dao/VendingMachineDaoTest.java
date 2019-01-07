/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.math.BigDecimal;
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

    private VendingMachineDao dao = new VendingMachineDaoStubImpl();

    public VendingMachineDaoTest() {
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
     * Test of readAll method, of class VendingMachineDao.
     */
    @Test
    public void testReadAll() {
        assertEquals(2, dao.readAll().size());
    }

    /**
     * Test of readByID method, of class VendingMachineDao.
     */
    @Test
    public void testReadByID() {
        assertNotNull(dao.readByID(1));
        assertNotNull(dao.readByID(2));
        assertNull(dao.readByID(3));
    }

    /**
     * Test of update method, of class VendingMachineDao.
     * @throws VendingMachinePersistenceException
     */
    @Test
    public void testUpdate() throws VendingMachinePersistenceException {
        VendingMachineItem item = new VendingMachineItem(1);
        item.setItemName("Coca-Cola");
        item.setItemCount(2);
        item.setItemPrice(new BigDecimal("1.50"));

        dao.update(1, item);

        assertEquals(item.getItemId(), dao.readByID(1).getItemId());
        
        assertNotEquals("Sprite", dao.readByID(1).getItemName());
        assertNotEquals(1, dao.readByID(1).getItemCount());
        assertNotEquals("1.00", dao.readByID(1).getItemPrice().toString());

        assertEquals("Coca-Cola", dao.readByID(1).getItemName());
        assertEquals(2, dao.readByID(1).getItemCount());
        assertEquals("1.50", dao.readByID(1).getItemPrice().toString());
    }

}
