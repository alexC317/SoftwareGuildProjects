/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Power;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional
    public Power addNewPower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Power> getAllPowers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Power getPowerByID(int powerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void updatePower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void deletePower(int powerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static final class powerMapper implements RowMapper<Power> {

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
