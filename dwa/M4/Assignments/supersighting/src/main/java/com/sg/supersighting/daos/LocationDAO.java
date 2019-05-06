/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface LocationDAO {

    //Create
    public Location addNewLocation(Location location);

    //Read All
    public List<Location> getAllLocations();

    //Read By ID
    public Location getLocationByID(int locationID);

    //Update
    public Boolean updateLocation(Location location);

    //Delete
    public Boolean deleteLocation(int locationID);

    //Returns a List of Locations that a specific Super has been spotted in
    public List<Location> getSightingsBySuper(int superID);

}
