/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

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
public class SuperDAOJDBCImplTest {

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    SuperDAO superDAO;

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
        List<Power> powers = powerDAO.getAllPowers();
        for (Power power : powers) {
            powerDAO.deletePower(power.getPowerID());
        }

        List<Super> supers = superDAO.getAllSupers();
        for (Super s : supers) {
            superDAO.deleteSuper(s.getSuperID());
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
        powerDAO.addNewPower(power);
        
        powers.add(power);
        
        s.setSuperPowers(powers);
        superDAO.addNewSuper(s);
        
        Super fromDAO = superDAO.getSuperByID(s.getSuperID());
        assertEquals(fromDAO, s);
        assertTrue(fromDAO.getSuperPowers().contains(power));
    }

//    /**
//     * Test of getAllSuperByOrganization method, of class SuperDAOJDBCImpl.
//     */
//    @Test
//    public void testGetAllSuperByOrganization() {
//    }
//
//    /**
//     * Test of getSightingsByLocation method, of class SuperDAOJDBCImpl.
//     */
//    @Test
//    public void testGetSightingsByLocation() {
//    }

}
