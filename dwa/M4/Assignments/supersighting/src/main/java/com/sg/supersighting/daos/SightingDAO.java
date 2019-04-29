/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Sighting;
import com.sg.supersighting.dtos.Super;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SightingDAO {

    //Create
    public Sighting addNewSighting(Sighting sighting);

    //Read All
    public List<Sighting> getAllSightings();

    //Read By ID
    public Sighting getSightingByID(int ID);

    //Update
    public void updateSighting(Sighting sighting);

    //Delete
    public void deleteSighting(int ID);

    //Returns a List of Sightings for a specific Date
    public List<Sighting> getSightingsByDate(LocalDate date);

    //Returns a List of Locations that a specific Super has been spotted in
    public List<Location> getSightingsBySuper(Super s);

    //Returns a List of Supers spotted in a specific Location
    public List<Super> getSightingsByLocation(Location location);
}
