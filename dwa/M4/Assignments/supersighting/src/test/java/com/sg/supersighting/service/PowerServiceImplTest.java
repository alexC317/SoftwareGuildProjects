/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.daos.PowerDAO;
import com.sg.supersighting.dtos.Power;
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
public class PowerServiceImplTest {

    @Autowired
    PowerDAO powerDAO;

    public PowerServiceImplTest() {
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
    public void testCreateAndReadByID() {
        Power power = new Power();
        power.setPowerName("Flight");
        power.setPowerDescription("Able to fly.");
        powerDAO.addNewPower(power);

        Power fromDAO = powerDAO.getPowerByID(power.getPowerID());
        assertEquals(fromDAO, power);
        
    }

}
