/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Role;
import com.sg.supersighting.dto.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class UserDAOJDBCImplTest {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    public UserDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<User> users = userDAO.readAll();
        for (User user : users) {
            userDAO.delete(user.getUserID());
        }

        List<Role> roles = roleDAO.readAll();
        for (Role role : roles) {
            roleDAO.delete(role.getRoleID());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateAndReadByID() {
        Set<Role> roles = new HashSet();
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setRoles(roles);
        user.setEnabled(true);
        userDAO.create(user);

        User fromDAO = userDAO.readByID(user.getUserID());
        assertEquals(fromDAO, user);

    }

    @Test
    public void testReadAll() {
        Set<Role> roles1 = new HashSet();
        User user1 = new User();
        user1.setUsername("test 1");
        user1.setPassword("password");
        user1.setRoles(roles1);
        user1.setEnabled(true);
        userDAO.create(user1);

        Set<Role> roles2 = new HashSet();
        User user2 = new User();
        user2.setUsername("test 2");
        user2.setPassword("p@ssw0rd");
        user2.setRoles(roles2);
        user2.setEnabled(false);
        userDAO.create(user2);

        List<User> fromDAO = userDAO.readAll();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(user1));
        assertTrue(fromDAO.contains(user2));

    }

    @Test
    public void testReadByUsername() {
        Role role = new Role();
        role.setRole("test role");
        roleDAO.create(role);
        Set<Role> roles1 = new HashSet();
        roles1.add(role);

        User user1 = new User();
        user1.setUsername("test 1");
        user1.setPassword("password");
        user1.setRoles(roles1);
        user1.setEnabled(true);
        userDAO.create(user1);

        User fromDAO = userDAO.readByUsername(user1.getUsername());
        assertEquals(fromDAO, user1);

    }

    @Test
    public void testUpdate() {
        Set<Role> roles = new HashSet();
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setRoles(roles);
        user.setEnabled(true);
        userDAO.create(user);

        User fromDAO = userDAO.readByID(user.getUserID());
        assertEquals(fromDAO, user);

        user.setUsername("test name");
        user.setEnabled(false);
        assertNotEquals(fromDAO, user);
        userDAO.update(user);

        fromDAO = userDAO.readByID(user.getUserID());
        assertEquals(fromDAO, user);

    }

    @Test
    public void testDelete() {
        Set<Role> roles1 = new HashSet();
        User user1 = new User();
        user1.setUsername("test 1");
        user1.setPassword("password");
        user1.setRoles(roles1);
        user1.setEnabled(true);
        userDAO.create(user1);

        Set<Role> roles2 = new HashSet();
        User user2 = new User();
        user2.setUsername("test 2");
        user2.setPassword("p@ssw0rd");
        user2.setRoles(roles2);
        user2.setEnabled(false);
        userDAO.create(user2);

        List<User> fromDAO = userDAO.readAll();
        assertEquals(2, fromDAO.size());
        assertTrue(fromDAO.contains(user1));
        assertTrue(fromDAO.contains(user2));

        userDAO.delete(user1.getUserID());
        fromDAO = userDAO.readAll();
        assertEquals(1, fromDAO.size());
        assertFalse(fromDAO.contains(user1));
        assertTrue(fromDAO.contains(user2));

    }

}
