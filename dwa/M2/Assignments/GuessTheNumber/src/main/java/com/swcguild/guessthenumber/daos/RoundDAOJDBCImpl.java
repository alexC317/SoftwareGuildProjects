/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.daos.GameDAOJDBCImpl.GameMapper;
import com.swcguild.guessthenumber.dtos.Game;
import com.swcguild.guessthenumber.dtos.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoundDAOJDBCImpl implements RoundDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_ROUND = "INSERT INTO rounds(gameID, guess, guessTime, result) VALUES(?,?,?,?)";
    private final String SELECT_ALL_ROUNDS = "SELECT roundID, gameID, guess, guessTime, result FROM rounds";
    private final String SELECT_ROUND_BY_ID = "SELECT roundID, gameID, guess, guessTime, result FROM rounds WHERE roundID = ?";
    private final String SELECT_ROUNDS_BY_GAME_ID = "SELECT roundID, gameID, guess, guessTime, result FROM rounds WHERE gameID = ? "
            + "ORDER BY guessTime ASC";
    private final String DELETE_ROUND = "DELETE FROM rounds WHERE roundID = ?";
    private final String DELETE_ROUND_BY_GAME_ID = "DELETE FROM rounds WHERE gameID = ?";

    @Override
    @Transactional
    public Round create(Round round) {
        jdbc.update(INSERT_ROUND, round.getGame().getID(), round.getGuess(), round.getGuessTime(), round.getResult());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setID(newID);
        return round;
    }

    @Override
    @Transactional
    public List<Round> readAll() {
        List<Round> rounds = jdbc.query(SELECT_ALL_ROUNDS, new RoundMapper());
        getGamesForRounds(rounds);
        return rounds;
    }

    @Override
    @Transactional
    public Round readByID(int id) {
        try {
            Round round = jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), id);
            round.setGame(getGameForRound(round));
            return round;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Round> readByGameID(int gameID) {
        List<Round> rounds = jdbc.query(SELECT_ROUNDS_BY_GAME_ID, new RoundMapper(), gameID);
        getGamesForRounds(rounds);
        return rounds;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return jdbc.update(DELETE_ROUND, id) > 0;
    }

    private Game getGameForRound(Round round) {
        final String SELECT_GAME_FOR_ROUND = "SELECT g.* FROM games g JOIN rounds r ON g.gameID = r.gameID where r.roundID = ?";
        return jdbc.queryForObject(SELECT_GAME_FOR_ROUND, new GameMapper(), round.getID());
    }

    private void getGamesForRounds(List<Round> rounds) {
        for (Round round : rounds) {
            round.setGame(getGameForRound(round));
        }
    }

    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setID(rs.getInt("roundID"));
            round.setGuessTime(rs.getTimestamp("guessTime").toLocalDateTime());
            round.setGuess(rs.getString("guess"));
            round.setResult(rs.getString("result"));
            return round;
        }

    }

}
