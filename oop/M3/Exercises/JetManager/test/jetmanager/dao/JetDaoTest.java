/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.dao;

import java.time.LocalDate;
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

    private JetDao dao = new JetDaoFileImpl();

    public JetDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Jet> jetList = dao.readAll();
        for (Jet jet : jetList) {
            dao.delete(jet.getId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class JetDao.
     */
    @Test
    public void testCreateReadById() throws Exception {
        Jet jet = new Jet(1);
        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);

        Jet fromDao = dao.readById(1);
        assertEquals(jet, fromDao);
    }

    /**
     * Test of readAll method, of class JetDao.
     */
    @Test
    public void testReadAll() throws Exception {
        Jet jet = new Jet(1);
        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);

        Jet jet2 = new Jet(2);
        jet2.setModel("F-15C Eag;e");
        jet2.setPilot("Larry Foulke");
        jet2.setFuelCapacity(150);
        jet2.setCurrentFuel(100);
        jet2.setMissleCount(6);
        jet2.setDateIssued(LocalDate.now());

        dao.create(jet2);

        assertEquals(2, dao.readAll().size());
    }

    /**
     * Test of update method, of class JetDao.
     */
    @Test
    public void testUpdate() throws Exception {
        Jet jet = new Jet(1);
        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);

        jet.setModel("F-15C Eagle");
        jet.setPilot("Larry Foulke");
        jet.setFuelCapacity(150);
        jet.setCurrentFuel(100);
        jet.setMissleCount(6);

        dao.update(1, jet);

        assertNotEquals("Kei Nagase", dao.readById(1).getPilot());

    }

    /**
     * Test of delete method, of class JetDao.
     */
    @Test
    public void testDelete() throws Exception {
        Jet jet = new Jet(1);
        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);

        Jet jet2 = new Jet(2);
        jet2.setModel("F-15C Eagle");
        jet2.setPilot("Larry Foulke");
        jet2.setFuelCapacity(150);
        jet2.setCurrentFuel(100);
        jet2.setMissleCount(6);
        jet2.setDateIssued(LocalDate.now());

        dao.create(jet2);

        dao.delete(1);
        assertEquals(1, dao.readAll().size());
        assertNull(dao.readById(1));

        dao.delete(2);
        assertEquals(0, dao.readAll().size());
        assertNull(dao.readById(2));

    }

    /**
     * Test of findPilot method, of class JetDao.
     */
    @Test
    public void testFindPilot() throws Exception {
        Jet jet = new Jet(1);
        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);

        assertEquals(1, dao.findPilot("Kei Nagase").size());
    }

    /**
     * Test of getAllJetsFromLastXYears method, of class JetDao.
     */
    @Test
    public void testGetAllJetsFromLastXYears() throws Exception {
        Jet jet = new Jet(1);
        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);

        Jet jet2 = new Jet(2);
        jet2.setModel("F-15C Eagle");
        jet2.setPilot("Larry Foulke");
        jet2.setFuelCapacity(150);
        jet2.setCurrentFuel(100);
        jet2.setMissleCount(6);
        jet2.setDateIssued(LocalDate.now().minusYears(10));

        dao.create(jet2);

        assertEquals(1, dao.getAllJetsFromLastXYears(5).size());
    }

    @Test
    public void testGetAllModels() throws Exception {
        Jet jet = new Jet(1);

        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);
        
        Jet jet2 = new Jet(2);
        jet2.setModel("F-15C Eagle");
        jet2.setPilot("Larry Foulke");
        jet2.setFuelCapacity(150);
        jet2.setCurrentFuel(100);
        jet2.setMissleCount(6);
        jet2.setDateIssued(LocalDate.now().minusYears(10));

        dao.create(jet2);
        
        assertEquals(1, dao.getJetsByModel("F-14D Super Tomcat").size());
    }
    
    @Test
    public void testGetAverageAge() throws Exception {
        Jet jet = new Jet(1);

        jet.setModel("F-14D Super Tomcat");
        jet.setPilot("Kei Nagase");
        jet.setFuelCapacity(100);
        jet.setCurrentFuel(75);
        jet.setMissleCount(4);
        jet.setDateIssued(LocalDate.now());

        dao.create(jet);
        
        Jet jet2 = new Jet(2);
        jet2.setModel("F-15C Eagle");
        jet2.setPilot("Larry Foulke");
        jet2.setFuelCapacity(150);
        jet2.setCurrentFuel(100);
        jet2.setMissleCount(6);
        jet2.setDateIssued(LocalDate.now().minusYears(10));

        dao.create(jet2);
        
        assertEquals(5, dao.getAverageJetAge(), 0);
    }
}
