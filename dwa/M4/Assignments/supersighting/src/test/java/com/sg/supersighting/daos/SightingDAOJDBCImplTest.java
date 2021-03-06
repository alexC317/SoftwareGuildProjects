/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Sighting;
import com.sg.supersighting.dtos.Super;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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
public class SightingDAOJDBCImplTest {

    @Autowired
    SightingDAO sightingDAO;

    @Autowired
    LocationDAO locationDAO;

    @Autowired
    SuperDAO superDAO;

    @Autowired
    PowerDAO powerDAO;

    public SightingDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Sighting> sightings = sightingDAO.getAllSightings();
        for (Sighting sighting : sightings) {
            sightingDAO.deleteSighting(sighting.getSightingID());
        }

        List<Location> locations = locationDAO.getAllLocations();
        for (Location location : locations) {
            locationDAO.deleteLocation(location.getLocationID());
        }

        List<Super> supers = superDAO.getAllSupers();
        for (Super s : supers) {
            superDAO.deleteSuper(s.getSuperID());
        }

        List<Power> powers = powerDAO.getAllPowers();
        for (Power power : powers) {
            powerDAO.deletePower(power.getPowerID());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndGetSighting() {
        Location location = new Location();
        location.setLocationName("Test Location");
        location.setLocationDescription("A location to test");
        location.setLocationAddress("123 Main Street");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        List<Power> powers = new ArrayList<>();
        Power power = new Power();
        power.setPowerName("Test power");
        power.setPowerDescription("A power to test");
        powerDAO.addNewPower(power);
        powers.add(power);

        Super s = new Super();
        s.setSuperName("Testman");
        s.setSuperDescription("A super to test");
        s.setSuperPowers(powers);
        superDAO.addNewSuper(s);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.now());
        sighting.setSightingLocation(location);
        sighting.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting);

        Sighting fromDAO = sightingDAO.getSightingByID(sighting.getSightingID());
        assertEquals(fromDAO, sighting);

    }

    @Test
    public void testGetAllSightings() {
        Location location = new Location();
        location.setLocationName("Test Location");
        location.setLocationDescription("A location to test");
        location.setLocationAddress("123 Main Street");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        List<Power> powers = new ArrayList<>();
        Power power = new Power();
        power.setPowerName("Test power");
        power.setPowerDescription("A power to test");
        powerDAO.addNewPower(power);
        powers.add(power);

        Super s = new Super();
        s.setSuperName("Testman");
        s.setSuperDescription("A super to test");
        s.setSuperPowers(powers);
        superDAO.addNewSuper(s);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.now());
        sighting.setSightingLocation(location);
        sighting.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setSightingDate(LocalDate.parse("2019-01-01"));
        sighting2.setSightingLocation(location);
        sighting2.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting2);

        List<Sighting> sightings = sightingDAO.getAllSightings();
        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertTrue(sightings.contains(sighting2));

    }

    @Test
    public void testUpdateSighting() {
        Location location = new Location();
        location.setLocationName("Test Location");
        location.setLocationDescription("A location to test");
        location.setLocationAddress("123 Main Street");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        List<Power> powers = new ArrayList<>();
        Power power = new Power();
        power.setPowerName("Test power");
        power.setPowerDescription("A power to test");
        powerDAO.addNewPower(power);
        powers.add(power);

        Super s = new Super();
        s.setSuperName("Testman");
        s.setSuperDescription("A super to test");
        s.setSuperPowers(powers);
        superDAO.addNewSuper(s);

        Super s2 = new Super();
        s2.setSuperName("Testman Jr");
        s2.setSuperDescription("Another super to test");
        s2.setSuperPowers(powers);
        superDAO.addNewSuper(s2);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.now());
        sighting.setSightingLocation(location);
        sighting.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting);

        Sighting fromDAO = sightingDAO.getSightingByID(sighting.getSightingID());
        assertEquals(fromDAO, sighting);

        sighting.setSightingSuper(s2);
        sightingDAO.updateSighting(sighting);
        assertNotEquals(fromDAO, sighting);

        fromDAO = sightingDAO.getSightingByID(sighting.getSightingID());
        assertEquals(fromDAO, sighting);

    }

    @Test
    public void testDeleteSighting() {
        Location location = new Location();
        location.setLocationName("Test Location");
        location.setLocationDescription("A location to test");
        location.setLocationAddress("123 Main Street");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        List<Power> powers = new ArrayList<>();
        Power power = new Power();
        power.setPowerName("Test power");
        power.setPowerDescription("A power to test");
        powerDAO.addNewPower(power);
        powers.add(power);

        Super s = new Super();
        s.setSuperName("Testman");
        s.setSuperDescription("A super to test");
        s.setSuperPowers(powers);
        superDAO.addNewSuper(s);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.now());
        sighting.setSightingLocation(location);
        sighting.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setSightingDate(LocalDate.parse("2019-01-01"));
        sighting2.setSightingLocation(location);
        sighting2.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting2);

        List<Sighting> sightings = sightingDAO.getAllSightings();
        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertTrue(sightings.contains(sighting2));

        sightingDAO.deleteSighting(sighting.getSightingID());
        sightings = sightingDAO.getAllSightings();
        assertEquals(1, sightings.size());
        assertTrue(sightings.contains(sighting2));
        assertFalse(sightings.contains(sighting));

    }

    /**
     * Test of getSightingsByDate method, of class SightingDAOJDBCImpl.
     */
    @Test
    public void testGetSightingsByDate() {
        Location location = new Location();
        location.setLocationName("Test Location");
        location.setLocationDescription("A location to test");
        location.setLocationAddress("123 Main Street");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        List<Power> powers = new ArrayList<>();
        Power power = new Power();
        power.setPowerName("Test power");
        power.setPowerDescription("A power to test");
        powerDAO.addNewPower(power);
        powers.add(power);

        Super s = new Super();
        s.setSuperName("Testman");
        s.setSuperDescription("A super to test");
        s.setSuperPowers(powers);
        superDAO.addNewSuper(s);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.now());
        sighting.setSightingLocation(location);
        sighting.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setSightingDate(LocalDate.now());
        sighting2.setSightingLocation(location);
        sighting2.setSightingSuper(s);
        sightingDAO.addNewSighting(sighting2);

        List<Sighting> sightings = sightingDAO.getSightingsByDate(LocalDate.now());
        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertTrue(sightings.contains(sighting2));

    }
}
