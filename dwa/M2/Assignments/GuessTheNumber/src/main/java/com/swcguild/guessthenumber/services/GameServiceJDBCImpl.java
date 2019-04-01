/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.services;

import com.swcguild.guessthenumber.daos.GameDAO;
import com.swcguild.guessthenumber.daos.RoundDAO;
import com.swcguild.guessthenumber.dtos.Game;
import com.swcguild.guessthenumber.dtos.Round;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceJDBCImpl implements GameService {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private RoundDAO roundDAO;

    @Override
    public Game beginGame() {
        Game game = new Game();
        game.setAnswer(createNewNumber());
        game.setIsFinished(false);

        return gameDAO.create(game);
    }

    @Override
    public Round checkGuess(String guess, int gameID) {
        Game game = gameDAO.readByID(gameID);

        if (game == null) {
            return null;
        }

        Round round = new Round();
        round.setGame(game);
        round.setGuess(guess);
        round.setGuessTime(LocalDateTime.now());
        round.setResult(calulateResult(guess, game.getAnswer()));
        roundDAO.create(round);

        if (round.getResult().equalsIgnoreCase("e:4:p:0")) {
            game.setIsFinished(true);
            gameDAO.update(game);
        }

        return roundDAO.readByID(round.getID());
    }

    @Override
    public List<Game> getAllGames() {
        return gameDAO.readAll();
    }

    @Override
    public Game getGameByID(int id) {
        return gameDAO.readByID(id);
    }

    @Override
    public List<Round> getAllRoundsByGameID(int gameID) {
        return roundDAO.readByGameID(gameID);
    }

    private String createNewNumber() {
        String randomNumber = "";
        Random rand = new Random();
        int nextNumber;
        int indexToRemove;
        boolean keepGoing = true;
        ArrayList<Integer> numberPool = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numberPool.add(i);
        }

        for (int i = 0; i < 4; i++) {
            do {
                nextNumber = rand.nextInt(10);

                if (numberPool.contains(nextNumber)) {
                    randomNumber = randomNumber + nextNumber;
                    indexToRemove = numberPool.indexOf(nextNumber);
                    numberPool.remove(indexToRemove);
                    keepGoing = false;
                } else {
                    keepGoing = true;
                }
            } while (keepGoing);
        }

        return randomNumber;
    }

    private String calulateResult(String guess, String answer) {
        int exactMatches = 0;
        int partialMatches = 0;
        String finalResult;

        if (guess.length() != 4) {
            finalResult = "e:" + exactMatches + ":p:" + partialMatches;
            return finalResult;
        }

        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == answer.charAt(i)) {
                exactMatches++;
            } else if (answer.contains(guess.subSequence(i, i + 1))) {
                partialMatches++;
            }
        }

        finalResult = "e:" + exactMatches + ":p:" + partialMatches;
        return finalResult;
    }
}
