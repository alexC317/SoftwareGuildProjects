/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Power;
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
public class LocationDAOJDBCImplTest {

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    SuperDAO superDAO;

    @Autowired
    LocationDAO locationDAO;

    public LocationDAOJDBCImplTest() {
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

        List<Super> supers = superDAO.getAllSupers();
        for (Super s : supers) {
            superDAO.deleteSuper(s.getSuperID());
        }

        List<Location> locations = locationDAO.getAllLocations();
        for (Location location : locations) {
            locationDAO.deleteLocation(location.getLocationID());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndGetLocation() {
        Location location = new Location();
        location.setLocationName("Test location");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("A location to test");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Location fromDAO = locationDAO.getLocationByID(location.getLocationID());
        assertEquals(fromDAO, location);

    }

    @Test
    public void testGetAllLocations() {
        Location location = new Location();
        location.setLocationName("Test location");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("A location to test");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Location location2 = new Location();
        location2.setLocationName("Test location 2");
        location2.setLocationAddress("456 Sub Street");
        location2.setLocationDescription("Another location to test");
        location2.setLocationLatitude("-10");
        location2.setLocationLongitude(("+10"));
        locationDAO.addNewLocation(location2);

        List<Location> fromDAO = locationDAO.getAllLocations();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(location));
        assertTrue(fromDAO.contains(location2));

    }

    @Test
    public void testUpdateLocation() {
        Location location = new Location();
        location.setLocationName("Test location");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("A location to test");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Location fromDAO = locationDAO.getLocationByID(location.getLocationID());
        assertEquals(fromDAO, location);

        location.setLocationName("Alternate test location");
        locationDAO.updateLocation(location);
        assertNotEquals(fromDAO, location);

        fromDAO = locationDAO.getLocationByID(location.getLocationID());
        assertEquals(fromDAO, location);

    }

    @Test
    public void testDeleteLocation() {
        Location location = new Location();
        location.setLocationName("Test location");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("A location to test");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Location location2 = new Location();
        location2.setLocationName("Test location 2");
        location2.setLocationAddress("456 Sub Street");
        location2.setLocationDescription("Another location to test");
        location2.setLocationLatitude("-10");
        location2.setLocationLongitude(("+10"));
        locationDAO.addNewLocation(location2);

        List<Location> fromDAO = locationDAO.getAllLocations();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(location));
        assertTrue(fromDAO.contains(location2));

        locationDAO.deleteLocation(location.getLocationID());
        fromDAO = locationDAO.getAllLocations();
        assertEquals(1, fromDAO.size());
        assertTrue(fromDAO.contains(location2));
        assertFalse(fromDAO.contains(location));

    }

    /**
     * Test of getSightingsBySuper method, of class LocationDAOJDBCImpl.
     */
    @Test
    public void testGetSightingsBySuper() {
    }

}
