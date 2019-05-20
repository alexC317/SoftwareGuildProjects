/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.User;
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
public class UserDAOJDBCImplTest {

    @Autowired
    UserDAO userDAO;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        userDAO.create(user);

        User fromDAO = userDAO.readByID(user.getUserID());
        assertEquals(fromDAO, user);
        
    }

}
