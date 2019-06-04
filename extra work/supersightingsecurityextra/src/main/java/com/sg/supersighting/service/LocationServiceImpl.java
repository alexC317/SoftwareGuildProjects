/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.LocationDAO;
import com.sg.supersighting.dto.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationDAO locationDAO;

    @Override
    public Location create(Location location) {
        return locationDAO.create(location);
    }

    @Override
    public List<Location> readAll() {
        return locationDAO.readAll();
    }

    @Override
    public Location readByID(int locationID) {
        return locationDAO.readByID(locationID);
    }

    @Override
    public List<Location> readLocationsBySuper(int superID) {
        return locationDAO.readBySuperID(superID);
    }

    @Override
    public void update(Location location) {
        locationDAO.update(location);
    }

    @Override
    public void delete(int locationID) {
        locationDAO.delete(locationID);
    }

}
