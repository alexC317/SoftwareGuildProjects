/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
    private final String UPDATE_LOCATION = "UPDATE locations SET locationName = ?, locationDescription = ?,"
            + "locationAddress = ?, locationLongitude = ?, locationLatitude = ? WHERE locationID = ?";
    private final String DELETE_LOCATION = "DELETE FROM locations WHERE locationID = ?";

    @Override
    public Location addNewLocation(Location location) {
        jdbc.update(INSERT_NEW_LOCATION, location.getLocationName(), location.getLocationDescription(), location.getLocationAddress(),
                location.getLocationLongitude(), location.getLocationLatitude());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationID(newID);
        return location;
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbc.query(SELECT_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public Location getLocationByID(int locationID) {
        return jdbc.queryForObject(SELECT_LOCATION_BY_ID, new LocationMapper(), locationID);
    }

    @Override
    public Boolean updateLocation(Location location) {
        return jdbc.update(UPDATE_LOCATION, location.getLocationName(), location.getLocationDescription(),
                location.getLocationAddress(), location.getLocationLongitude(), location.getLocationLatitude(),
                location.getLocationID()) > 0;
    }

    @Override
    public Boolean deleteLocation(int locationID) {
        return jdbc.update(DELETE_LOCATION, locationID) > 0;
    }

    @Override
    public List<Location> getLocationsBySuper(int superID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
