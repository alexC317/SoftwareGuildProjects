/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dao;

import java.util.List;
import jetmanager.dto.Jet;
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
public class JetDaoTest {
    
    public JetDaoTest() {
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
     * Test of create method, of class JetDao.
     */
    @Test
    public void testCreate() throws Exception {
    }

    /**
     * Test of readAll method, of class JetDao.
     */
    @Test
    public void testReadAll() {
    }

    /**
     * Test of readById method, of class JetDao.
     */
    @Test
    public void testReadById() {
    }

    /**
     * Test of update method, of class JetDao.
     */
    @Test
    public void testUpdate() throws Exception {
    }

    /**
     * Test of delete method, of class JetDao.
     */
    @Test
    public void testDelete() throws Exception {
    }

    /**
     * Test of findPilot method, of class JetDao.
     */
    @Test
    public void testFindPilot() {
    }

    /**
     * Test of initialLoad method, of class JetDao.
     */
    @Test
    public void testInitialLoad() throws Exception {
    }

    /**
     * Test of exitProgram method, of class JetDao.
     */
    @Test
    public void testExitProgram() throws Exception {
    }

    public class JetDaoImpl implements JetDao {

        public Jet create(Jet jet) throws JetDaoException {
            return null;
        }

        public List<Jet> readAll() {
            return null;
        }

        public Jet readById(int id) {
            return null;
        }

        public void update(int id, Jet jet) throws JetDaoException {
        }

        public void delete(int id) throws JetDaoException {
        }

        public List<Jet> findPilot(String name) {
            return null;
        }

        public void initialLoad() throws JetDaoException {
        }

        public void exitProgram() throws JetDaoException {
        }
    }
    
}
