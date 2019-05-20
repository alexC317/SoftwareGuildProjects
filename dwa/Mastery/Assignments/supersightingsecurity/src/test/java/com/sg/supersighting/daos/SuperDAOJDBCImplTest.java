/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dao.OrganizationDAO;
import com.sg.supersighting.dao.LocationDAO;
import com.sg.supersighting.dao.SightingDAO;
import com.sg.supersighting.dao.PowerDAO;
import com.sg.supersighting.dao.SuperDAO;
import com.sg.supersighting.dto.Location;
import com.sg.supersighting.dto.Organization;
import com.sg.supersighting.dto.Power;
import com.sg.supersighting.dto.Sighting;
import com.sg.supersighting.dto.Super;
import java.time.LocalDate;
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
public class SuperDAOJDBCImplTest {

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    SuperDAO superDAO;

    @Autowired
    LocationDAO locationDAO;

    @Autowired
    OrganizationDAO organizationDAO;

    @Autowired
    SightingDAO sightingDAO;

    public SuperDAOJDBCImplTest() {
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
        List<Organization> organizations = organizationDAO.readAll();
        for (Organization organization : organizations) {
            organizationDAO.delete(organization.getOrganizationID());
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
    public void testAddAndGetSuper() {
        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest hero.");
        List<Power> powers = new ArrayList<>();

        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly.");
        powerDAO.create(power);

        powers.add(power);

        s.setSuperPowers(powers);
        superDAO.create(s);

        Super fromDAO = superDAO.readByID(s.getSuperID());
        assertEquals(fromDAO, s);
        assertTrue(fromDAO.getSuperPowers().contains(power));

    }

    @Test
    public void testAddSuperNoPowers() {
        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest hero.");
        superDAO.create(s);

        Super fromDAO = superDAO.readByID(s.getSuperID());
        assertEquals(fromDAO, s);
    }

    @Test
    public void testGetAllSupers() {
        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest hero.");
        List<Power> supermanPowers = new ArrayList<>();

        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly");
        powerDAO.create(power);

        supermanPowers.add(power);

        Super s2 = new Super();
        s2.setSuperName("Womnder Woman");
        s2.setSuperDescription("The Amazon");
        List<Power> wonderWomanPower = new ArrayList<>();

        wonderWomanPower.add(power);

        s.setSuperPowers(supermanPowers);
        s2.setSuperPowers(wonderWomanPower);

        superDAO.create(s);
        superDAO.create(s2);

        List<Super> fromDAO = superDAO.readAll();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(s));
        assertTrue(fromDAO.contains(s2));

    }

    @Test
    public void testUpdateSuper() {
        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest hero");
        List<Power> supermanPowers = new ArrayList<>();

        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly");
        powerDAO.create(power);

        supermanPowers.add(power);
        s.setSuperPowers(supermanPowers);

        superDAO.create(s);

        Super fromDAO = superDAO.readByID(s.getSuperID());
        assertEquals(fromDAO, s);

        s.setSuperDescription("The most human despite not being one");
        Power power2 = new Power();
        power2.setPowerName("Ice breath");
        power2.setPowerDescription("Able to freeze with breath");
        powerDAO.create(power2);

        supermanPowers.add(power2);
        s.setSuperPowers(supermanPowers);
        superDAO.update(s);
        assertNotEquals(fromDAO, s);

        fromDAO = superDAO.readByID(s.getSuperID());
        assertEquals(fromDAO, s);

    }

    @Test
    public void testDeleteSuper() {
        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest superhero");
        List<Power> supermanPowers = new ArrayList<>();

        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly");
        powerDAO.create(power);

        supermanPowers.add(power);
        s.setSuperPowers(supermanPowers);
        superDAO.create(s);

        Super s2 = new Super();
        s2.setSuperName("Wonder Woman");
        s2.setSuperDescription("The Amazon");
        List<Power> wonderWomanPowers = new ArrayList<>();
        wonderWomanPowers.add(power);
        s2.setSuperPowers(wonderWomanPowers);
        superDAO.create(s2);

        List<Super> supers = superDAO.readAll();
        assertEquals(2, supers.size());
        assertTrue(supers.contains(s));
        assertTrue(supers.contains(s2));

        superDAO.delete(s.getSuperID());
        supers = superDAO.readAll();
        assertEquals(1, supers.size());
        assertTrue(supers.contains(s2));
        assertFalse(supers.contains(s));
    }

    /**
     * Test of readByOrganizationID method, of class SuperDAOJDBCImpl.
     */
    @Test
    public void testGetAllSuperByOrganization() {
        Location location = new Location();
        location.setLocationName("Hall of Justice");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("Justice League Headquarters");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.create(location);

        List<Power> supermanPowers = new ArrayList<>();

        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly");
        powerDAO.create(power);

        supermanPowers.add(power);

        Super superman = new Super();
        superman.setSuperName("Superman");
        superman.setSuperDescription("The Last Son of Krypton");
        superman.setSuperPowers(supermanPowers);

        Super batman = new Super();
        batman.setSuperName("Batman");
        batman.setSuperDescription("The Dark Knight");

        Super wonderWoman = new Super();
        wonderWoman.setSuperName("Wonder Woman");
        wonderWoman.setSuperDescription("The Amazon of Themyscira");

        superDAO.create(superman);
        superDAO.create(batman);
        superDAO.create(wonderWoman);

        List<Super> supers = new ArrayList<>();
        supers.add(superman);
        supers.add(batman);
        supers.add(wonderWoman);

        Organization justiceLeague = new Organization();
        justiceLeague.setOrganizationName("The Justice League");
        justiceLeague.setOrganizationDescription("The World's Finest");
        justiceLeague.setOrganizationContact("jl@dc.com");
        justiceLeague.setSupers(supers);
        justiceLeague.setOrganizationAddress(location);
        organizationDAO.create(justiceLeague);

        List<Super> justiceLeagueRoster = superDAO.readByOrganizationID(justiceLeague.getOrganizationID());
        assertEquals(3, justiceLeagueRoster.size());
        assertTrue(justiceLeagueRoster.contains(superman));
        assertTrue(justiceLeagueRoster.contains(batman));
        assertTrue(justiceLeagueRoster.contains(wonderWoman));

    }

    /**
     * Test of readByLocationID method, of class SuperDAOJDBCImpl.
     */
    @Test
    public void testGetSightingsByLocation() {
        Location location = new Location();
        location.setLocationName("Hall of Justice");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("Justice League Headquarters");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.create(location);

        Super superman = new Super();
        superman.setSuperName("Superman");
        superman.setSuperDescription("The Last Son of Krypton");

        Super batman = new Super();
        batman.setSuperName("Batman");
        batman.setSuperDescription("The Dark Knight");

        Super wonderWoman = new Super();
        wonderWoman.setSuperName("Wonder Woman");
        wonderWoman.setSuperDescription("The Amazon of Themyscira");

        superDAO.create(superman);
        superDAO.create(batman);
        superDAO.create(wonderWoman);

        Sighting supermanSighting = new Sighting();
        supermanSighting.setSightingDate(LocalDate.now());
        supermanSighting.setSightingSuper(superman);
        supermanSighting.setSightingLocation(location);

        Sighting batmanSighting = new Sighting();
        batmanSighting.setSightingDate(LocalDate.now());
        batmanSighting.setSightingSuper(batman);
        batmanSighting.setSightingLocation(location);

        Sighting wonderWomanSighting = new Sighting();
        wonderWomanSighting.setSightingDate(LocalDate.now());
        wonderWomanSighting.setSightingSuper(wonderWoman);
        wonderWomanSighting.setSightingLocation(location);

        sightingDAO.create(supermanSighting);
        sightingDAO.create(batmanSighting);
        sightingDAO.create(wonderWomanSighting);

        List<Super> superSightings = superDAO.readByLocationID(location.getLocationID());
        assertEquals(3, superSightings.size());
        assertTrue(superSightings.contains(superman));
        assertTrue(superSightings.contains(batman));
        assertTrue(superSightings.contains(wonderWoman));

    }
}
