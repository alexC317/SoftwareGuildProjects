/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
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
public class AddressBookDaoTest {

    private AddressBookDao dao = new AddressBookDaoMockImpl();

    public AddressBookDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Address> addresses = dao.readAll();

        for (Address address : addresses) {
            dao.delete(address.getLastName());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class AddressBookDao.
     */
    @Test
    public void testCreateAndReadByLastName() throws Exception {
        Address address = new Address("John", "Smith", "123 Main Street", "Springfield", "IL", 00001);
        dao.create(address);

        Address newAddress = dao.readByLastName(address.getLastName());
        assertEquals(address, newAddress);
    }

    /**
     * Test of readAll method, of class AddressBookDao.
     */
    @Test
    public void testReadAll() throws Exception {
        Address address = new Address("John", "Smith", "123 Main Street", "Springfield", "IL", 00001);
        Address address2 = new Address("John", "Wick", "456 Revenge Street", "New York", "NY", 00002);

        dao.create(address);
        dao.create(address2);

        assertEquals(2, dao.readAll().size());
    }

    /**
     * Test of delete method, of class AddressBookDao.
     */
    @Test
    public void testDelete() throws Exception {
        Address address = new Address("John", "Smith", "123 Main Street", "Springfield", "IL", 00001);
        dao.create(address);

        dao.delete(address.getLastName());

        assertEquals(0, dao.readAll().size());
    }

    /**
     * Test of addressCount method, of class AddressBookDao.
     */
    @Test
    public void testAddressCount() throws Exception {
        Address address = new Address("John", "Smith", "123 Main Street", "Springfield", "IL", 00001);
        Address address2 = new Address("John", "Wick", "456 Revenge Street", "New York", "NY", 00002);

        dao.create(address);
        dao.create(address2);

        assertEquals(2, dao.readAll().size());

    }

    /**
     * Test of editAddress method, of class AddressBookDao.
     */
    @Test
    public void testEditAddress() {
        
    }

}
