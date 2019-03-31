/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.TestApplicationConfiguration;
import com.swcguild.guessthenumber.dtos.Game;
import com.swcguild.guessthenumber.dtos.Round;
import java.time.LocalDateTime;
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
public class RoundDAOJDBCImplTest {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private RoundDAO roundDAO;

    public RoundDAOJDBCImplTest() {

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
            roundDAO.delete((round.getID()));
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testCreateReadByID() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);
        gameDAO.create(game);

        Round round = new Round();
        round.setGame(game);
        round.setGuess("1234");
        round.setGuessTime(LocalDateTime.now().withNano(0));
        round.setResult("e:4:p:0");
        roundDAO.create(round);

        Round fromDAO = roundDAO.readByID(round.getID());

        assertEquals(round, fromDAO);
    }

    /**
     * Test of readAll method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testReadAll() {
        Game game = new Game();
        game.setAnswer(("1234"));
        game.setIsFinished(false);
        gameDAO.create(game);

        Round round = new Round();
        round.setGame(game);
        round.setGuess("1234");
        round.setGuessTime(LocalDateTime.now().withNano(0));
        round.setResult("e:4:p:0");
        roundDAO.create(round);

        Round round2 = new Round();
        round2.setGame(game);
        round2.setGuess("5678");
        round2.setGuessTime(LocalDateTime.now().withNano(0));
        round2.setResult("e:0:p:0");
        roundDAO.create(round2);

        List<Round> rounds = roundDAO.readAll();

        assertEquals(2, rounds.size());
        assertTrue(rounds.contains(round));
        assertTrue(rounds.contains(round2));
    }

    /**
     * Test of readByGameID method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testReadByGameID() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);
        gameDAO.create(game);

        Round round = new Round();
        round.setGame(game);
        round.setGuess("1234");
        round.setGuessTime(LocalDateTime.now().withNano(0));
        round.setResult("e:4:p:0");
        roundDAO.create(round);

        Round round2 = new Round();
        round2.setGame(game);
        round2.setGuess("5678");
        round2.setGuessTime(LocalDateTime.now().withNano(0));
        round2.setResult("e:0:p:0");
        roundDAO.create(round2);

        List<Round> roundsGame1 = roundDAO.readByGameID(game.getID());
        assertEquals(2, roundsGame1.size());
        assertTrue(roundsGame1.contains(round));
        assertTrue(roundsGame1.contains(round2));

        Game game2 = new Game();
        game2.setAnswer("0317");
        game2.setIsFinished(false);
        gameDAO.create(game2);

        Round round3 = new Round();
        round3.setGame(game2);
        round3.setGuess("1317");
        round3.setGuessTime(LocalDateTime.now().withNano(0));
        round3.setResult("e:3:p:1");
        roundDAO.create(round3);

        List<Round> roundsGame2 = roundDAO.readByGameID(game2.getID());
        assertEquals(1, roundsGame2.size());
        assertTrue(roundsGame2.contains(round3));

    }

    /**
     * Test of delete method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testDelete() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setIsFinished(false);
        gameDAO.create(game);

        Round round = new Round();
        round.setGame(game);
        round.setGuess("1234");
        round.setGuessTime(LocalDateTime.now().withNano(0));
        round.setResult("e:4:p:0");
        roundDAO.create(round);

        roundDAO.delete(round.getID());

        Round fromDAO = roundDAO.readByID(round.getID());

        assertNull(fromDAO);
    }

}
