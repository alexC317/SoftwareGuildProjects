/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dao.LocationDAOJDBCImpl.LocationMapper;
import com.sg.supersighting.dao.SuperDAOJDBCImpl.SuperMapper;
import com.sg.supersighting.dto.Location;
import com.sg.supersighting.dto.Power;
import com.sg.supersighting.dto.Sighting;
import com.sg.supersighting.dto.Super;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SightingDAOJDBCImpl implements SightingDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_SIGHTING = "INSERT INTO sightings(sightingID, sightingDate, superID, locationID) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_SIGHTINGS = "SELECT sightingID, sightingDate, superID, locationID FROM sightings";
    private final String SELECT_SIGHTING_BY_ID = "SELECT sightingID, sightingDate, superID, locationID FROM sightings "
            + "WHERE sightingID = ?";
    private final String SELECT_SIGHTINGS_BY_DATE = "SELECT sightingID, sightingDate, superID, locationID FROM sightings "
            + "WHERE sightingDate = ?";
    private final String UPDATE_SIGHTING = "UPDATE sightings SET sightingDate = ?, superID = ?, locationID = ? "
            + "WHERE sightingID = ?";
    private final String DELETE_SIGHTING = "DELETE FROM sightings WHERE sightingID = ?";

    private final String SELECT_SUPER_FOR_SIGHTING = "SELECT s.superID, s.superName, s.superDescription FROM supers s "
            + "INNER JOIN sightings c ON s.superID = c.superID WHERE c.sightingID = ?";
    private final String SELECT_LOCATION_FOR_SIGHTING = "SELECT l.locationID, l.locationName, l.locationDescription, "
            + "l.locationAddress, l.locationLongitude, l.locationLatitude FROM locations l "
            + "INNER JOIN sightings s on l.locationID = s.locationID WHERE s.sightingID  = ?";

    @Override
    @Transactional
    public Sighting create(Sighting sighting) {
        jdbc.update(INSERT_NEW_SIGHTING, sighting.getSightingID(), sighting.getSightingDate().toString(),
                sighting.getSightingSuper().getSuperID(), sighting.getSightingLocation().getLocationID());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingID(newID);
        return sighting;
    }

    @Override
    @Transactional
    public List<Sighting> readAll() {
        List<Sighting> sightings = jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper());
        for (Sighting sighting : sightings) {
            getSuperForSighting(sighting);
            getLocationForSighting(sighting);
        }
        return sightings;
    }

    @Override
    @Transactional
    public Sighting readByID(int sightingID) {
        try {
            Sighting sighting = jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new SightingMapper(), sightingID);
            getSuperForSighting(sighting);
            getLocationForSighting(sighting);
            return sighting;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean update(Sighting sighting) {
        return jdbc.update(UPDATE_SIGHTING, sighting.getSightingDate().toString(), sighting.getSightingSuper().getSuperID(),
                sighting.getSightingLocation().getLocationID(), sighting.getSightingID()) > 0;
    }

    @Override
    @Transactional
    public boolean delete(int sightingID) {
        return jdbc.update(DELETE_SIGHTING, sightingID) > 0;
    }

    @Override
    @Transactional
    public List<Sighting> readByDate(LocalDate date) {
        List<Sighting> sightings = jdbc.query(SELECT_SIGHTINGS_BY_DATE, new SightingMapper(), date.toString());
        for (Sighting sighting : sightings) {
            getSuperForSighting(sighting);
            getLocationForSighting(sighting);
        }
        return sightings;
    }

    private void getSuperForSighting(Sighting sighting) {
        Super s = jdbc.queryForObject(SELECT_SUPER_FOR_SIGHTING, new SuperMapper(), sighting.getSightingID());
        List<Power> powers = jdbc.query("SELECT p.* FROM powers p JOIN superpowers s ON s.powerID = p.powerID where s.superID = ?",
                new PowerDAOJDBCImpl.PowerMapper(), s.getSuperID());
        if (powers.isEmpty()) {
            s.setSuperPowers(null);
        } else {
            s.setSuperPowers(powers);
        }
        sighting.setSightingSuper(s);
    }

    private void getLocationForSighting(Sighting sighting) {
        Location location = jdbc.queryForObject(SELECT_LOCATION_FOR_SIGHTING, new LocationMapper(), sighting.getSightingID());
        sighting.setSightingLocation(location);
    }

    public static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setSightingID(rs.getInt("sightingID"));
            sighting.setSightingDate(rs.getDate("sightingDate").toLocalDate());
            return sighting;
        }

    }

}
