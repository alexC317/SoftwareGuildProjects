/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.dtos.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoundDAOJDBCImpl implements RoundDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_ROUND = "INSERT INTO rounds VALUES(gameID, guess, result)";
    private final String SELECT_ALL_ROUNDS = "SELECT roundID, gameID, guess, result FROM rounds";
    private final String SELECT_ROUND_BY_ID = "SELECT gameID, answer, isFinished FROM games WHERE gameID = ?";
    private final String DELETE_ROUND = "DELETE FROM rounds WHERE roundID = ?";

    @Override
    public Round create(Round round) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Round> readAll() {
        return jdbc.query(SELECT_ALL_ROUNDS, new RoundMapper());
    }

    @Override
    public Round readByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setId(rs.getInt("roundID"));
            round.setGameID(rs.getInt("gameID"));
            round.setGuess(rs.getString("guess"));
            round.setResult(rs.getString("result"));

            return round;
        }

    }

}
