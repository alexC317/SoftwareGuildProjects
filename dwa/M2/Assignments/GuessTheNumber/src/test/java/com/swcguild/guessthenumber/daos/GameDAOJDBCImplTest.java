/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.TestApplicationConfiguration;
import com.swcguild.guessthenumber.dtos.Game;
import com.swcguild.guessthenumber.dtos.Round;
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
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDAOJDBCImplTest {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private RoundDAO roundDAO;

    public GameDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Game> games = gameDAO.readAll();
        for (Game game : games) {
            gameDAO.delete(game.getId());
        }

        List<Round> rounds = roundDAO.readAll();
        for (Round round : rounds) {
            roundDAO.delete(round.getGameID());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class GameDAOJDBCImpl.
     */
    @Test
    public void testCreateGetGame() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);
        gameDAO.create(game);

        Game fromDAO = gameDAO.readByID(game.getId());

        assertEquals(game, fromDAO);
    }

    /**
     * Test of readAll method, of class GameDAOJDBCImpl.
     */
    @Test
    public void testReadAll() {
    }

    /**
     * Test of readByID method, of class GameDAOJDBCImpl.
     */
    @Test
    public void testReadByID() {
    }

    /**
     * Test of update method, of class GameDAOJDBCImpl.
     */
    @Test
    public void testUpdate() {
    }

    /**
     * Test of delete method, of class GameDAOJDBCImpl.
     */
    @Test
    public void testDelete() {
    }

}
