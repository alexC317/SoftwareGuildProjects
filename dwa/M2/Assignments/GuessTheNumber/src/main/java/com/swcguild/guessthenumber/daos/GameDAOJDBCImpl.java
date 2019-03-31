/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.dtos.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GameDAOJDBCImpl implements GameDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_GAME = "INSERT INTO games(answer, isFinished) VALUES (?, false)";
    private final String SELECT_ALL_GAMES = "SELECT gameID, answer, isFinished FROM games";
    private final String SELECT_GAME_BY_ID = "SELECT gameID, answer, isFinished FROM games WHERE gameID = ?";
    private final String UPDATE_GAME = "UPDATE games SET isFinished WHERE gameID = ?";
    private final String DELETE_ROUND_BY_GAME = "DELETE FROM rounds WHERE gameID = ?";
    private final String DELETE_GAME = "DELETE FROM games WHERE gameID = ?";

    @Override
    public Game create(Game game) {
        jdbc.update(INSERT_GAME, game.getAnswer());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setId(newID);

        return game;
    }

    @Override
    public List<Game> readAll() {
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game readByID(int id) {
        return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), id);
    }

    @Override
    public boolean update(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        jdbc.update(DELETE_ROUND_BY_GAME, id);
        
        return jdbc.update(DELETE_GAME, id) > 0;
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setId(rs.getInt("gameID"));
            game.setAnswer(rs.getString("answer"));
            game.setIsFinished(rs.getBoolean("isFinished"));

            return game;
        }

    }

}
