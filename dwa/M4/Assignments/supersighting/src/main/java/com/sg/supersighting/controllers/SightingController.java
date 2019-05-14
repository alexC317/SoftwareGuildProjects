/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Sighting;
import com.sg.supersighting.dtos.Super;
import com.sg.supersighting.services.LocationService;
import com.sg.supersighting.services.SightingService;
import com.sg.supersighting.services.SuperService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
public class SightingController {

    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();

    @Autowired
    SightingService sightingService;

    @Autowired
    SuperService superService;

    @Autowired
    LocationService locationService;

    @GetMapping("/")
    public String displayRecentSightings(Model model) {
        List<Sighting> sightings = sightingService.readAll();
        if (sightings.size() > 10) {
            List<Sighting> displaySightings = sightings.subList(sightings.size() - 10, sightings.size());
            model.addAttribute("sightings", displaySightings);
        } else {
            model.addAttribute("sightings", sightings);
        }

        return "index";
    }

    @PostMapping("addSighting")
    public String addSighting(Sighting sighting, HttpServletRequest request) {
        String superID = request.getParameter("superID");
        String locationID = request.getParameter("locationID");
        sighting.setSightingSuper(superService.readByID(Integer.parseInt(superID)));
        sighting.setSightingLocation(locationService.readByID(Integer.parseInt(locationID)));
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);
        if (violations.isEmpty()) {
            sightingService.create(sighting);
        }
        return "redirect:/Sightings";
    }

    @GetMapping("Sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingService.readAll();
        List<Super> supers = superService.readAll();
        List<Location> locations = locationService.readAll();
        model.addAttribute("sightings", sightings);
        model.addAttribute("supers", supers);
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        return "Sightings";
    }

    @GetMapping("editSighting")
    public String editSighting(Integer sightingID, Model model) {
        Sighting sighting = sightingService.readByID(sightingID);
        Super existingSuper = sighting.getSightingSuper();
        Location existingLocation = sighting.getSightingLocation();
        List<Super> supers = superService.readAll();
        List<Location> locations = locationService.readAll();
        model.addAttribute("sighting", sighting);
        model.addAttribute("existingSuper", existingSuper);
        model.addAttribute("existingLocation", existingLocation);
        model.addAttribute("supers", supers);
        model.addAttribute("locations", locations);
        return "editSighting";
    }

    @PostMapping("editSighting")
    public String performEditSighting(@Valid Sighting sighting, BindingResult result, HttpServletRequest request, Model model) {
        String sightingID = request.getParameter("sightingID");
        String superID = request.getParameter("superID");
        String locationID = request.getParameter("locationID");
        sighting.setSightingID(Integer.parseInt(sightingID));
        sighting.setSightingSuper(superService.readByID(Integer.parseInt(superID)));
        sighting.setSightingLocation(locationService.readByID(Integer.parseInt(locationID)));
        if (result.hasErrors()) {
            model.addAttribute("sighting", sighting);
            model.addAttribute("existingSuper", sighting.getSightingSuper());
            model.addAttribute("existingLocation", sighting.getSightingLocation());
            model.addAttribute("supers", superService.readAll());
            model.addAttribute("locations", locationService.readAll());
            return "editSighting";
        }
        sightingService.update(sighting);
        return "redirect:/Sightings";
    }

    @GetMapping("deleteSighting")
    public String deleteSighting(Integer sightingID) {
        sightingService.delete(sightingID);
        return "redirect:/Sightings";
    }
}
