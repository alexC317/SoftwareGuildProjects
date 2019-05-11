/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.dtos.Sighting;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SightingService {

    public Sighting create();

    public List<Sighting> readAll();

    public Sighting readByID();

    public void update();

    public void delete();
}
