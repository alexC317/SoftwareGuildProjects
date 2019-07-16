/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dao.LocationDAO;
import com.sg.supersighting.dao.SightingDAO;
import com.sg.supersighting.dao.PowerDAO;
import com.sg.supersighting.dao.SuperDAO;
import com.sg.supersighting.dto.Location;
import com.sg.supersighting.dto.Power;
import com.sg.supersighting.dto.Sighting;
import com.sg.supersighting.dto.Super;
import java.time.LocalDate;
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

    @Autowired
    SightingDAO sightingDAO;

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
        List<Power> powers = powerDAO.readAll();
        for (Power power : powers) {
            powerDAO.delete(power.getPowerID());
        }

        List<Super> supers = superDAO.readAll();
        for (Super s : supers) {
            superDAO.delete(s.getSuperID());
        }

        List<Location> locations = locationDAO.readAll();
        for (Location location : locations) {
            locationDAO.delete(location.getLocationID());
        }

        List<Sighting> sightings = sightingDAO.readAll();
        for (Sighting sighting : sightings) {
            sightingDAO.delete(sighting.getSightingID());
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
        locationDAO.create(location);

        Location fromDAO = locationDAO.readByID(location.getLocationID());
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
        locationDAO.create(location);

        Location location2 = new Location();
        location2.setLocationName("Test location 2");
        location2.setLocationAddress("456 Sub Street");
        location2.setLocationDescription("Another location to test");
        location2.setLocationLatitude("-10");
        location2.setLocationLongitude(("+10"));
        locationDAO.create(location2);

        List<Location> fromDAO = locationDAO.readAll();
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
        locationDAO.create(location);

        Location fromDAO = locationDAO.readByID(location.getLocationID());
        assertEquals(fromDAO, location);

        location.setLocationName("Alternate test location");
        locationDAO.update(location);
        assertNotEquals(fromDAO, location);

        fromDAO = locationDAO.readByID(location.getLocationID());
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
        locationDAO.create(location);

        Location location2 = new Location();
        location2.setLocationName("Test location 2");
        location2.setLocationAddress("456 Sub Street");
        location2.setLocationDescription("Another location to test");
        location2.setLocationLatitude("-10");
        location2.setLocationLongitude(("+10"));
        locationDAO.create(location2);

        List<Location> fromDAO = locationDAO.readAll();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(location));
        assertTrue(fromDAO.contains(location2));

        locationDAO.delete(location.getLocationID());
        fromDAO = locationDAO.readAll();
        assertEquals(1, fromDAO.size());
        assertTrue(fromDAO.contains(location2));
        assertFalse(fromDAO.contains(location));

    }

    /**
     * Test of readBySuperID method, of class LocationDAOJDBCImpl.
     */
    @Test
    public void testGetSightingsBySuper() {
        Super superman = new Super();
        superman.setSuperName("Superman");
        superman.setSuperDescription("The Last Son of Krypton");
        superDAO.create(superman);

        Location hallOfJustice = new Location();
        hallOfJustice.setLocationName("The Hall of Justice");
        hallOfJustice.setLocationDescription("Justice League HQ");
        hallOfJustice.setLocationAddress("123 Main Street");
        hallOfJustice.setLocationLatitude("00");
        hallOfJustice.setLocationLongitude("00");

        Location dailyPlanet = new Location();
        dailyPlanet.setLocationName("The Daily Planet");
        dailyPlanet.setLocationDescription("Metropolis' Premier Newspaper");
        dailyPlanet.setLocationAddress("465 Main Street");
        dailyPlanet.setLocationLatitude("+01");
        dailyPlanet.setLocationLongitude("+01");

        Location fortressOfSolitude = new Location();
        fortressOfSolitude.setLocationName("The Fortress of Solitude");
        fortressOfSolitude.setLocationDescription("Superman's Home Base");
        fortressOfSolitude.setLocationAddress("Somewhere in Antartica");
        fortressOfSolitude.setLocationLatitude("-90");
        fortressOfSolitude.setLocationLongitude("-90");

        locationDAO.create(hallOfJustice);
        locationDAO.create(dailyPlanet);
        locationDAO.create(fortressOfSolitude);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.now());
        sighting.setSightingLocation(hallOfJustice);
        sighting.setSightingSuper(superman);

        Sighting sighting2 = new Sighting();
        sighting2.setSightingDate(LocalDate.now());
        sighting2.setSightingLocation(dailyPlanet);
        sighting2.setSightingSuper(superman);

        Sighting sighting3 = new Sighting();
        sighting3.setSightingDate(LocalDate.now());
        sighting3.setSightingLocation(fortressOfSolitude);
        sighting3.setSightingSuper(superman);

        sightingDAO.create(sighting);
        sightingDAO.create(sighting2);
        sightingDAO.create(sighting3);

        List<Location> locations = locationDAO.readBySuperID(superman.getSuperID());
        assertEquals(3, locations.size());
        assertTrue(locations.contains(hallOfJustice));
        assertTrue(locations.contains(dailyPlanet));
        assertTrue(locations.contains(fortressOfSolitude));
    }

}
