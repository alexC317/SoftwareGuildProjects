/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.daos.PowerDAOJDBCImpl.PowerMapper;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Super;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SuperDAOJDBCImpl implements SuperDAO {

    private final String INSERT_NEW_SUPER = "INSERT INTO supers(superName, superDescription) VALUES (?, ?)";
    private final String SELECT_ALL_SUPERS = "SELECT superID, superName, superDescription FROM supers";
    private final String SELECT_SUPER_BY_ID = "SELECT superID, superName, superDescription FROM supers WHERE superID = ?";
    private final String UPDATE_SUPER = "UPDATE supers SET superName = ?, superDescription = ? WHERE superID = ?";
    private final String DELETE_SUPER = "DELETE FROM supers WHERE superID = ?";

    private final String INSERT_INTO_SUPERPOWERS = "INSERT INTO superpowers(superID, powerID) VALUES(?, ?)";
    private final String SELECT_POWERS_FOR_SUPER = "SELECT p.* FROM powers p JOIN superpowers s ON s.powerID = p.powerID where s.superID = ?";
    private final String DELETE_SUPERPOWERS = "DELETE FROM superpowers WHERE superID = ?";

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    @Transactional
    public Super addNewSuper(Super s) {
        jdbc.update(INSERT_NEW_SUPER, s.getSuperName(), s.getSuperDescription());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        s.setSuperID(newID);
        addSuperpowers(s);
        return s;
    }

    @Override
    @Transactional
    public List<Super> getAllSupers() {
        List<Super> supers = jdbc.query(SELECT_ALL_SUPERS, new SuperMapper());
        for (Super s : supers) {
            s.setSuperPowers(getPowersForSuper(s.getSuperID()));
        }
        return supers;
    }

    @Override
    @Transactional
    public Super getSuperByID(int superID) {
        Super s = jdbc.queryForObject(SELECT_SUPER_BY_ID, new SuperMapper(), superID);
        s.setSuperPowers(getPowersForSuper(superID));
        return s;
    }

    @Override
    @Transactional
    public Boolean updateSuper(Super s) {
        updateSuperpowers(s);
        return jdbc.update(UPDATE_SUPER, s.getSuperName(), s.getSuperDescription(), s.getSuperID()) > 0;

    }

    @Override
    @Transactional
    public Boolean deleteSuper(int superID) {
        jdbc.update(DELETE_SUPERPOWERS, superID);
        return jdbc.update(DELETE_SUPER, superID) > 0;
    }

    @Override
    @Transactional
    public List<Super> getAllSupersByOrganization(int organizationID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Super> getSupersByLocation(int locationID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addSuperpowers(Super s) {
        for (Power power : s.getSuperPowers()) {
            jdbc.update(INSERT_INTO_SUPERPOWERS, s.getSuperID(), power.getPowerID());
        }
    }

    private List<Power> getPowersForSuper(int superID) {
        return jdbc.query(SELECT_POWERS_FOR_SUPER, new PowerMapper(), superID);
    }

    private void updateSuperpowers(Super s) {
        jdbc.update(DELETE_SUPERPOWERS, s.getSuperID());
        addSuperpowers(s);
    }

    public final static class SuperMapper implements RowMapper<Super> {

        @Override
        public Super mapRow(ResultSet rs, int i) throws SQLException {
            Super s = new Super();
            s.setSuperID(rs.getInt("superID"));
            s.setSuperName(rs.getString("superName"));
            s.setSuperDescription(rs.getString("superDescription"));

            return s;
        }

    }

}
