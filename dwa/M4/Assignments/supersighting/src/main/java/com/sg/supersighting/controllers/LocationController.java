/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.daos.LocationDAO;
import com.sg.supersighting.dtos.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alex
 */
@Controller
public class LocationController {

    @Autowired
    LocationDAO locationDAO;

    @PostMapping("addLocation")
    public String addLocation(String locationName, String locationDescription, String locationAddress,
            String locationLongitude, String locationLatitude) {
        Location location = new Location();
        location.setLocationName(locationName);
        location.setLocationDescription(locationDescription);
        location.setLocationAddress(locationAddress);
        location.setLocationLatitude(locationLatitude);
        location.setLocationLongitude(locationLongitude);
        locationDAO.addNewLocation(location);
        return "redirect:/Locations";
    }

    @GetMapping("Locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationDAO.getAllLocations();
        model.addAttribute("locations", locations);
        return "Locations";
    }

    @GetMapping("editLocation")
    public String editLocation(Integer locationID, Model model) {
        Location location = locationDAO.getLocationByID(locationID);
        model.addAttribute("location", location);
        return "editLocation";
    }

    @PostMapping("editLocation")
    public String performEditLocation(Location location) {
        locationDAO.updateLocation(location);
        return "redirect:/Locations";
    }

    @GetMapping("deleteLocation")
    public String deleteLocation(Integer locationID) {
        locationDAO.deleteLocation(locationID);
        return "redirect:/Locations";
    }

}
