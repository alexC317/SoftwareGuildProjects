/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SightingDAO {

    //Create
    public Sighting create(Sighting sighting);

    //Read All
    public List<Sighting> readAll();

    //Read By ID
    public Sighting readByID(int sightingID);

    //Update
    public boolean update(Sighting sighting);

    //Delete
    public boolean delete(int sightingID);

    //Returns a List of Sightings for a specific Date
    public List<Sighting> readByDate(LocalDate date);

}
