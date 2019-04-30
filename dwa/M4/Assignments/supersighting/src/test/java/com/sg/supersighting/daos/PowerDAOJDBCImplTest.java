/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Sighting;
import com.sg.supersighting.dtos.Super;
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

//    @Autowired
//    SuperDAO superDAO;
//
//    @Autowired
//    OrganizationDAO organizationDAO;
//
//    @Autowired
//    LocationDAO locationDAO;
//
//    @Autowired
//    SightingDAO sightingDAO;
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

//        List<Super> supers = superDAO.getAllSupers();
//        for (Super s : supers) {
//            superDAO.deleteSuper(s.getSuperID());
//        }
//
//        List<Organization> organizations = organizationDAO.getAllOrganizations();
//        for (Organization organization : organizations) {
//            organizationDAO.deleteOrganization(organization.getOrganizationID());
//        }
//
//        List<Location> locations = locationDAO.getAllLocations();
//        for (Location location : locations) {
//            locationDAO.deleteLocation(location.getLocationID());
//        }
//
//        List<Sighting> sightings = sightingDAO.getAllSightings();
//        for (Sighting sighting : sightings) {
//            sightingDAO.deleteSighting(sighting.getSightingID());
//        }
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

    }
}
