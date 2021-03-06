/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Power;
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
public class PowerDAOJDBCImpl implements PowerDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_POWER = "INSERT INTO powers(powerName, powerDescription) VALUES (?, ?)";
    private final String SELECT_ALL_POWERS = "SELECT powerID, powerName, powerDescription FROM powers";
    private final String SELECT_POWER_BY_ID = "SELECT powerID, powerName, powerDescription FROM powers WHERE powerID = ?";
    private final String UPDATE_POWER = "UPDATE powers SET powerName = ?, powerDescription = ? WHERE powerID = ?";
    private final String DELETE_POWER = "DELETE FROM powers WHERE powerID = ?";

    private final String DELETE_FROM_SUPERPOWERS = "DELETE FROM superpowers WHERE powerID = ?";

    @Override
    @Transactional
    public Power create(Power power) {
        jdbc.update(INSERT_NEW_POWER, power.getPowerName(), power.getPowerDescription());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        power.setPowerID(newID);
        return power;
    }

    @Override
    @Transactional
    public List<Power> readAll() {
        return jdbc.query(SELECT_ALL_POWERS, new PowerMapper());
    }

    @Override
    @Transactional
    public Power readByID(int powerID) {
        try {
            return jdbc.queryForObject(SELECT_POWER_BY_ID, new PowerMapper(), powerID);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Boolean update(Power power) {
        return jdbc.update(UPDATE_POWER, power.getPowerName(), power.getPowerDescription(), power.getPowerID()) > 0;
    }

    @Override
    @Transactional
    public Boolean delete(int powerID) {
        jdbc.update(DELETE_FROM_SUPERPOWERS, powerID);
        return jdbc.update(DELETE_POWER, powerID) > 0;
    }

    public static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power power = new Power();
            power.setPowerID(rs.getInt("powerID"));
            power.setPowerName(rs.getString("powerName"));
            power.setPowerDescription(rs.getString("powerDescription"));

            return power;
        }

    }

}
