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
    
    @Test
    public void testGetAllSupers(){
        Super s = new Super();
        s.setSuperName("Superman");
        s.setSuperDescription("The greatest hero.");
        List<Power> supermanPowers = new ArrayList<>();
        
        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly");
        powerDAO.addNewPower(power);
        
        supermanPowers.add(power);
        
        Super s2 = new Super();
        s2.setSuperName("Womnder Woman");
        s2.setSuperDescription("The Amazon");
        List<Power> wonderWomanPower = new ArrayList<>();
        
//        Power power2 = new Power();
//        power2.setPowerName("Photographic memory");
//        power2.setPowerDescription("Able to perfectly recall memories");
//        powerDAO.addNewPower(power2);
        
        wonderWomanPower.add(power);
        
        s.setSuperPowers(supermanPowers);
        s2.setSuperPowers(wonderWomanPower);
        
        superDAO.addNewSuper(s);
        superDAO.addNewSuper(s2);
        
        List<Super> fromDAO = superDAO.getAllSupers();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(s));
        assertTrue(fromDAO.contains(s2));
        
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
