/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Location;
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
public class LocationDAOJDBCImpl implements LocationDAO {

    @Autowired
    JdbcTemplate jdbc;

    private final String INSERT_NEW_LOCATION = "INSERT INTO locations(locationName, locationDescription, "
            + "locationAddress, locationLongitude, locationLatitude) VALUES (?, ?, ?, ?, ?) ";
    private final String SELECT_ALL_LOCATIONS = "SELECT locationID, locationName, locationDescription, "
            + "locationAddress, locationLongitude, locationLatitude FROM locations";
    private final String SELECT_LOCATION_BY_ID = "SELECT locationID, locationName, locationDescription, "
            + "locationAddress, locationLongitude, locationLatitude FROM locations WHERE locationID = ?";
    private final String SELECT_LOCATIONS_BY_SUPER = "SELECT DISTINCT l.locationID, l.locationName, l.locationAddress, l.locationDescription, "
            + "l.locationLatitude, l.locationLongitude FROM locations l INNER JOIN sightings s ON s.locationID = l.locationID "
            + "WHERE s.superID = ?";
    private final String UPDATE_LOCATION = "UPDATE locations SET locationName = ?, locationDescription = ?,"
            + "locationAddress = ?, locationLongitude = ?, locationLatitude = ? WHERE locationID = ?";
    private final String DELETE_LOCATION = "DELETE FROM locations WHERE locationID = ?";

    private final String DELETE_FROM_SIGHTINGS = "DELETE FROM sightings WHERE locationID = ?";

    private final String DELETE_FROM_ORGANIZATIONS = "UPDATE organizations SET locationID = NULL WHERE locationID = ?";

    @Override
    @Transactional
    public Location create(Location location) {
        jdbc.update(INSERT_NEW_LOCATION, location.getLocationName(), location.getLocationDescription(), location.getLocationAddress(),
                location.getLocationLongitude(), location.getLocationLatitude());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationID(newID);
        return location;
    }

    @Override
    @Transactional
    public List<Location> readAll() {
        return jdbc.query(SELECT_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    @Transactional
    public Location readByID(int locationID) {
        try {
            return jdbc.queryForObject(SELECT_LOCATION_BY_ID, new LocationMapper(), locationID);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Boolean update(Location location) {
        return jdbc.update(UPDATE_LOCATION, location.getLocationName(), location.getLocationDescription(),
                location.getLocationAddress(), location.getLocationLongitude(), location.getLocationLatitude(),
                location.getLocationID()) > 0;
    }

    @Override
    @Transactional
    public Boolean delete(int locationID) {
        jdbc.update(DELETE_FROM_SIGHTINGS, locationID);
        jdbc.update(DELETE_FROM_ORGANIZATIONS, locationID);
        return jdbc.update(DELETE_LOCATION, locationID) > 0;
    }

    @Override
    @Transactional
    public List<Location> readBySuperID(int superID) {
        List<Location> locations = jdbc.query(SELECT_LOCATIONS_BY_SUPER, new LocationMapper(), superID);
        return locations;
    }

    public static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setLocationID(rs.getInt("locationID"));
            location.setLocationName(rs.getString("locationName"));
            location.setLocationAddress(rs.getString("locationAddress"));
            location.setLocationDescription(rs.getString("locationDescription"));
            location.setLocationLatitude(rs.getString("locationLatitude"));
            location.setLocationLongitude(rs.getString("locationLongitude"));

            return location;
        }

    }

}
