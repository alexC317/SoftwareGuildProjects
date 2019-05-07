/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Super;
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
public class OrganizationDAOJDBCImplTest {

    @Autowired
    OrganizationDAO organizationDAO;

    @Autowired
    SuperDAO superDAO;

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    LocationDAO locationDAO;

    public OrganizationDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Organization> organizations = organizationDAO.getAllOrganizations();
        for (Organization organzation : organizations) {
            organizationDAO.deleteOrganization(organzation.getOrganizationID());
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
    public void testAddAndGetOrganization() {
        List<Super> supers = new ArrayList<>();

        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest hero.");
        superDAO.addNewSuper(s);
        supers.add(s);

        Location location = new Location();
        location.setLocationName("Hall of Justice");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("Justice League Headquarters");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Organization org = new Organization();
        org.setOrganizationName("Justice League");
        org.setOrganizationDescription("World's Finest Heroes");
        org.setOrganizationContact("1-800-123-4567");
        org.setOrganizationAddress(location);
        org.setSupers(supers);
        organizationDAO.addNewOrganization(org);

        Organization fromDAO = organizationDAO.getOrganizationByID(org.getOrganizationID());

        assertEquals(fromDAO, org);

    }

    @Test
    public void testAddNewOrganizatonNoSuper() {
        Location location = new Location();
        location.setLocationName("Hall of Justice");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("Justice League Headquarters");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Organization org = new Organization();
        org.setOrganizationName("Justice League");
        org.setOrganizationDescription("World's Finest Heroes");
        org.setOrganizationContact("1-800-123-4567");
        org.setOrganizationAddress(location);
        organizationDAO.addNewOrganization(org);

        Organization fromDAO = organizationDAO.getOrganizationByID(org.getOrganizationID());

        assertEquals(fromDAO, org);

    }

    @Test
    public void testGetAllOrganizations() {
        Location location = new Location();
        location.setLocationName("Hall of Justice");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("Justice League Headquarters");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Organization org = new Organization();
        org.setOrganizationName("Justice League");
        org.setOrganizationDescription("World's Finest Heroes");
        org.setOrganizationContact("1-800-123-4567");
        org.setOrganizationAddress(location);
        organizationDAO.addNewOrganization(org);

        Organization org2 = new Organization();
        org2.setOrganizationName("Justice League of America");
        org2.setOrganizationDescription("America's Finest Heroes?");
        org2.setOrganizationContact("1-800-123-7890");
        org2.setOrganizationAddress(location);
        organizationDAO.addNewOrganization(org2);

        List<Organization> organizations = organizationDAO.getAllOrganizations();
        assertEquals(2, organizations.size());
        assertTrue(organizations.contains(org));
        assertTrue(organizations.contains(org2));

    }

    @Test
    public void testUpdateOrganization() {
        Location location = new Location();
        location.setLocationName("Hall of Justice");
        location.setLocationAddress("123 Main Street");
        location.setLocationDescription("Justice League Headquarters");
        location.setLocationLatitude("00");
        location.setLocationLongitude("00");
        locationDAO.addNewLocation(location);

        Organization org = new Organization();
        org.setOrganizationName("Justice League");
        org.setOrganizationDescription("World's Finest Heroes");
        org.setOrganizationContact("1-800-123-4567");
        org.setOrganizationAddress(location);
        organizationDAO.addNewOrganization(org);

        Organization fromDAO = organizationDAO.getOrganizationByID(org.getOrganizationID());
        assertEquals(fromDAO, org);

        org.setOrganizationName("The Justice League of America");
        org.setOrganizationContact("1-800-123-4567, contact@jla.com");
        organizationDAO.updateOrganization(org);

        assertNotEquals(fromDAO, org);
        
    }

    @Test
    public void testDeleteOrganization() {
        
        
    }

    /**
     * Test of getOrganizationsBySuper method, of class OrganizationDAOJDBCImpl.
     */
    @Test
    public void testGetOrganizationsBySuper() {
    }

}
