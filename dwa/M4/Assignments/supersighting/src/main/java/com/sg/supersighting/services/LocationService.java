/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.dtos.Location;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface LocationService {

    public Location create(Location location);

    public List<Location> readAll();

    public Location readByID(int locationID);
    
    public List<Location> readLocationsBySuper(int superID);

    public void update(Location location);

    public void delete(int locationID);
}
