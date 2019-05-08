/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.daos.LocationDAOJDBCImpl.LocationMapper;
import com.sg.supersighting.daos.SuperDAOJDBCImpl.SuperMapper;
import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Sighting;
import com.sg.supersighting.dtos.Super;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SightingDAOJDBCImpl implements SightingDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_SIGHTING = "INSERT INTO sightings(sightingID, sightingDate, superID, locationID) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_SIGHTINGS = "SELECT sightingID, sightingDate, superID, locationID FROM sightings";

    @Override
    public Sighting addNewSighting(Sighting sighting) {
//        LocalDatePersistenceConverter temp = new LocalDatePersistenceConverter();
//        Date date = temp.convertToDatabaseColumn(sighting.getSightingDate());

        jdbc.update(INSERT_NEW_SIGHTING, sighting.getSightingID(), sighting.getSightingDate().toString(),
                sighting.getSightingSuper().getSuperID(), sighting.getSightingLocation().getLocationID());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingID(newID);
        return sighting;
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper());
    }

    @Override
    public Sighting getSightingByID(int sightingID) {
        final String SELECT_SIGHTING_BY_ID = "SELECT sightingID, sightingDate, superID, locationID FROM sightings "
                + "WHERE sightingID = ?";
        Sighting sighting = jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new SightingMapper(), sightingID);
        getSuperForSighting(sighting);
        getLocationForSighting(sighting);

        return sighting;
    }

    @Override
    public boolean updateSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSighting(int sightingID) {
        final String DELETE_SIGHTING = "DELETE FROM sightings WHERE sightingID = ?";
        return jdbc.update(DELETE_SIGHTING, sightingID) > 0;
    }

    @Override
    public List<Sighting> getSightingsByDate(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getSuperForSighting(Sighting sighting) {
        final String SELECT_SUPER_FOR_SIGHTING = "SELECT s.superID, s.superName, s.superDescription FROM supers s "
                + "INNER JOIN sightings c ON s.superID = c.superID WHERE c.sightingID = ?";
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
        final String SELECT_LOCATION_FOR_SIGHTING = "SELECT l.locationID, l.locationName, l.locationDescription, "
                + "l.locationAddress, l.locationLongitude, l.locationLatitude FROM locations l "
                + "INNER JOIN sightings s on l.locationID = s.locationID WHERE s.sightingID  = ?";
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

    @Converter(autoApply = true)
    public class LocalDatePersistenceConverter implements
            AttributeConverter<LocalDate, Date> {

        @Override
        public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
            return java.sql.Date.valueOf(entityValue);
        }

        @Override
        public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
            return databaseValue.toLocalDate();
        }
    }
}
