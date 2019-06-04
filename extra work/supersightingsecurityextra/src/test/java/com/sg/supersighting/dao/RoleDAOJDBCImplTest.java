/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Role;
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
public class RoleDAOJDBCImplTest {

    @Autowired
    public RoleDAO roleDAO;

    public RoleDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Role> roles = roleDAO.readAll();
        for (Role role : roles) {
            roleDAO.delete((role.getRoleID()));
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateAndReadByID() {
        Role role = new Role();
        role.setRole("test");
        roleDAO.create(role);

        Role fromDAO = roleDAO.readByID(role.getRoleID());
        assertEquals(fromDAO, role);

    }

    @Test
    public void testReadAll() {
        Role role1 = new Role();
        role1.setRole("test1");
        roleDAO.create(role1);

        Role role2 = new Role();
        role2.setRole("test2");
        roleDAO.create(role2);

        List<Role> fromDAO = roleDAO.readAll();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(role1));
        assertTrue(fromDAO.contains(role2));

    }

    @Test
    public void testReadByRole() {
        Role role = new Role();
        role.setRole("test");
        roleDAO.create(role);

        Role fromDAO = roleDAO.readByRole("test");
        assertEquals(fromDAO, role);
    }

    @Test
    public void testUpdate() {
        Role role = new Role();
        role.setRole("test");
        roleDAO.create(role);

        Role fromDAO = roleDAO.readByID(role.getRoleID());
        assertEquals(fromDAO, role);

        role.setRole("test 2");
        roleDAO.update(role);
        assertNotEquals(fromDAO, role);

        fromDAO = roleDAO.readByID(role.getRoleID());
        assertEquals(fromDAO, role);

    }

    @Test
    public void testDelete() {
        Role role1 = new Role();
        role1.setRole("test1");
        roleDAO.create(role1);

        Role role2 = new Role();
        role2.setRole("test2");
        roleDAO.create(role2);

        List<Role> fromDAO = roleDAO.readAll();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(role1));
        assertTrue(fromDAO.contains(role2));

        roleDAO.delete(role1.getRoleID());
        fromDAO = roleDAO.readAll();

        assertEquals(1, fromDAO.size());
        assertFalse(fromDAO.contains(role1));
        assertTrue(fromDAO.contains(role2));

    }

}
