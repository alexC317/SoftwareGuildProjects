/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.SightingDAO;
import com.sg.supersighting.dto.Sighting;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SightingServiceImpl implements SightingService {

    @Autowired
    SightingDAO sightingDAO;

    @Override
    public Sighting create(Sighting sighting) {
        return sightingDAO.addNewSighting(sighting);
    }

    @Override
    public List<Sighting> readAll() {
        return sightingDAO.getAllSightings();
    }

    @Override
    public Sighting readByID(int sightingID) {
        return sightingDAO.getSightingByID(sightingID);
    }

    @Override
    public List<Sighting> readSightingsByDate(LocalDate date) {
        return sightingDAO.getSightingsByDate(date);
    }

    @Override
    public void update(Sighting sighting) {
        sightingDAO.updateSighting(sighting);
    }

    @Override
    public void delete(int sightingID) {
        sightingDAO.deleteSighting(sightingID);
    }

}
