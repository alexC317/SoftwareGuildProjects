/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Location;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface LocationDAO {

    //Create
    public Location create(Location location);

    //Read All
    public List<Location> readAll();

    //Read By ID
    public Location readByID(int locationID);

    //Update
    public Boolean update(Location location);

    //Delete
    public Boolean delete(int locationID);

    //Returns a List of Locations that a specific Super has been spotted in
    public List<Location> readBySuperID(int superID);

}
