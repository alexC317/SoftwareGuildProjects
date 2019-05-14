/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.services.LocationService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alex
 */
@Controller
public class LocationController {

    Set<ConstraintViolation<Location>> violations = new HashSet<>();

    @Autowired
    LocationService locationService;

    @PostMapping("addLocation")
    public String addLocation(String locationName, String locationDescription, String locationAddress,
            String locationLongitude, String locationLatitude) {
        Location location = new Location();
        location.setLocationName(locationName);
        location.setLocationDescription(locationDescription);
        location.setLocationAddress(locationAddress);
        location.setLocationLatitude(locationLatitude);
        location.setLocationLongitude(locationLongitude);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(location);
        if (violations.isEmpty()) {
            locationService.create(location);
        }
        return "redirect:/Locations";
    }

    @GetMapping("Locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationService.readAll();
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        return "Locations";
    }

    @GetMapping("editLocation")
    public String editLocation(Integer locationID, Model model) {
        Location location = locationService.readByID(locationID);
        model.addAttribute("location", location);
        return "editLocation";
    }

    @PostMapping("editLocation")
    public String performEditLocation(@Valid Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "editLocation";
        }
        locationService.update(location);
        return "redirect:/Locations";
    }

    @GetMapping("deleteLocation")
    public String deleteLocation(Integer locationID) {
        locationService.delete(locationID);
        return "redirect:/Locations";
    }

}
