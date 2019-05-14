/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.daos.LocationDAO;
import com.sg.supersighting.dtos.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationDAO locationDAO;

    @Override
    public Location create(Location location) {
        return locationDAO.addNewLocation(location);
    }

    @Override
    public List<Location> readAll() {
        return locationDAO.getAllLocations();
    }

    @Override
    public Location readByID(int locationID) {
        return locationDAO.getLocationByID(locationID);
    }

    @Override
    public List<Location> readLocationsBySuper(int superID) {
        return locationDAO.getLocationsBySuper(superID);
    }

    @Override
    public void update(Location location) {
        locationDAO.updateLocation(location);
    }

    @Override
    public void delete(int locationID) {
        locationDAO.deleteLocation(locationID);
    }

}
