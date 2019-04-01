/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.services;

import com.swcguild.guessthenumber.TestApplicationConfiguration;
import com.swcguild.guessthenumber.daos.GameDAO;
import com.swcguild.guessthenumber.daos.RoundDAO;
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
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Alex
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameServiceJDBCImplTest {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private RoundDAO roundDAO;

    @Autowired
    private GameService gameService;

    public GameServiceJDBCImplTest() {
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
            gameDAO.delete(game.getID());
        }

        List<Round> rounds = roundDAO.readAll();
        for (Round round : rounds) {
            roundDAO.delete(round.getID());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of beginGame and getGameByID methods, of class GameServiceJDBCImpl.
     */
    @Test
    public void testBeginGameGetGameByID() {
        Game game = gameService.beginGame();
        Game fromService = gameService.getGameByID(game.getID());

        assertEquals(game, fromService);
        assertFalse(fromService.getIsFinished());
    }

    /**
     * Test of checkGuess method when there is a complete match, of class
     * GameServiceJDBCImpl.
     */
    @Test
    public void testCheckGuessTotalSuccess() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);
        gameDAO.create(game);

        Round round = gameService.checkGuess("1234", game.getID());
        assertEquals("e:4:p:0", round.getResult());
        assertTrue(gameDAO.readByID(game.getID()).getIsFinished());
    }

    /**
     * Test of checkGuess method when there are partial matches, of class
     * GameServiceJDBCImpl.
     */
    @Test
    public void testCheckGuessPartialSuccess() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);
        gameDAO.create(game);

        Round round = gameService.checkGuess("0001", game.getID());
        assertEquals("e:0:p:1", round.getResult());
        assertFalse(gameDAO.readByID(game.getID()).getIsFinished());
    }

    /**
     * Test of checkGuess method when there are no games, of class
     * GameServiceJDBCImpl.
     */
    @Test
    public void testCheckGuessNoGames() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);

        Round round = gameService.checkGuess("0001", game.getID());
        assertNull(round);
    }

    /**
     * Test of checkGuess method when there are no games, of class
     * GameServiceJDBCImpl.
     */
    @Test
    public void testCheckGuessBadInput() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);

        Round round = gameService.checkGuess("12345", game.getID());
        assertNull(round);
    }

    /**
     * Test of getAllGames method, of class GameServiceJDBCImpl.
     */
    @Test
    public void testGetAllGames() {
        gameService.beginGame();
        gameService.beginGame();
        gameService.beginGame();

        List<Game> games = gameService.getAllGames();
        assertEquals(3, games.size());
    }

    /**
     * Test of getAllGames method when there are no Games, of class
     * GameServiceJDBCImpl.
     */
    @Test
    public void testGetAllGamesNoGames() {
        List<Game> games = gameService.getAllGames();
        assertEquals(0, games.size());
    }

    /**
     * Test of getGameByID method, of class GameServiceJDBCImpl.
     */
    @Test
    public void testGetGameByIDNoGames() {
        Game game = new Game();
        game.setID(1);
        game.setAnswer("1234");
        game.setIsFinished(false);

        Game fromService = gameService.getGameByID(game.getID());

        assertNull(fromService);
    }

    /**
     * Test of getAllRoundsByGameID method, of class GameServiceJDBCImpl.
     */
    @Test
    public void testGetAllRoundsByGameID() {
        Game game = gameService.beginGame();

        Round round = gameService.checkGuess("1234", game.getID());
        Round round2 = gameService.checkGuess("4567", game.getID());

        List<Round> rounds = gameService.getAllRoundsByGameID(game.getID());

        assertEquals(2, rounds.size());
        assertTrue(rounds.contains(round));
        assertTrue(rounds.contains(round2));

    }

    /**
     * Test of getAllRoundsByGameID method with no Games, of class
     * GameServiceJDBCImpl.
     */
    @Test
    public void testGetAllRoundsByGameIDNoGames() {
        Game game = new Game();
        game.setID(1);
        game.setAnswer("1234");
        game.setIsFinished(false);

        Round round = gameService.checkGuess("1234", game.getID());
        Round round2 = gameService.checkGuess("4567", game.getID());

        List<Round> rounds = gameService.getAllRoundsByGameID(game.getID());

        assertEquals(0, rounds.size());
        assertFalse(rounds.contains(round));
        assertFalse(rounds.contains(round2));

    }

}
