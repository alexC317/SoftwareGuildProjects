/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dao.PowerDAO;
import com.sg.supersighting.dto.Power;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Alex
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PowerDAOJDBCImplTest {

    @Autowired
    PowerDAO powerDAO;

    public PowerDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Power> powers = powerDAO.getAllPowers();
        for (Power power : powers) {
            powerDAO.deletePower(power.getPowerID());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndGetPower() {
        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly.");
        powerDAO.addNewPower(power);

        Power fromDAO = powerDAO.getPowerByID(power.getPowerID());
        assertEquals(fromDAO, power);

    }

    @Test
    public void testGetAllPowers() {
        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly.");
        powerDAO.addNewPower(power);

        Power power2 = new Power();
        power2.setPowerName("Telekinesis");
        power2.setPowerDescription("Able to move stuff with your mind.");
        powerDAO.addNewPower(power2);

        List<Power> powers = powerDAO.getAllPowers();
        assertEquals(2, powers.size());
        assertTrue(powers.contains(power));
        assertTrue(powers.contains(power2));

    }

    @Test
    public void testGetPowerByIDNull() {
        Power power = powerDAO.getPowerByID(0);
        assertNull(power);

    }

    @Test
    public void testUpdatePower() {
        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly.");
        powerDAO.addNewPower(power);

        Power fromDAO = powerDAO.getPowerByID(power.getPowerID());
        assertEquals(fromDAO, power);

        power.setPowerName("Ice Breath");
        power.setPowerDescription("Able to freeze with breath.");
        powerDAO.updatePower(power);
        assertNotEquals(fromDAO, power);

        fromDAO = powerDAO.getPowerByID(power.getPowerID());
        assertEquals(fromDAO, power);

    }

    @Test
    public void testDeletePower() {
        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly.");
        powerDAO.addNewPower(power);

        Power power2 = new Power();
        power2.setPowerName("Invisibility");
        power2.setPowerDescription("Able to turn invisible");
        powerDAO.addNewPower(power2);

        assertEquals(2, powerDAO.getAllPowers().size());

        powerDAO.deletePower(power.getPowerID());
        assertEquals(1, powerDAO.getAllPowers().size());

        Power fromDAO = powerDAO.getPowerByID(power.getPowerID());
        assertNull(fromDAO);

    }
}
