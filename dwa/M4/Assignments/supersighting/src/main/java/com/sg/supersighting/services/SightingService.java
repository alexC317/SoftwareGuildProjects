/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.dtos.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SightingService {

    public Sighting create(Sighting sighting);

    public List<Sighting> readAll();

    public Sighting readByID(int sightingID);

    public List<Sighting> readSightingsByDate(LocalDate date);

    public void update(Sighting sighting);

    public void delete(int sightingID);
}
