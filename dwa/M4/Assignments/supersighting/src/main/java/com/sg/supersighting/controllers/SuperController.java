/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.daos.OrganizationDAO;
import com.sg.supersighting.daos.SightingDAO;
import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Super;
import com.sg.supersighting.services.LocationService;
import com.sg.supersighting.services.PowerService;
import com.sg.supersighting.services.SuperService;
import java.util.ArrayList;
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
public class SuperController {

    Set<ConstraintViolation<Super>> violations = new HashSet<>();

    @Autowired
    SuperService superService;

    @Autowired
    PowerService powerService;

    @Autowired
    OrganizationDAO organizationDAO;

    @Autowired
    SightingDAO sightingDAO;

    @Autowired
    LocationService locationService;

    @PostMapping("addSuper")
    public String addSuper(Super s, HttpServletRequest request) {
        String[] powerIDs = request.getParameterValues("powerID");
        if (powerIDs != null) {
            List<Power> powers = new ArrayList<>();
            for (String powerID : powerIDs) {
                powers.add(powerService.readByID(Integer.parseInt(powerID)));
            }
            s.setSuperPowers(powers);
        }
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(s);
        if (violations.isEmpty()) {
            superService.create(s);
        }
        return "redirect:/Supers";
    }

    @GetMapping("Supers")
    public String displaySupers(Model model) {
        List<Super> supers = superService.readAll();
        List<Power> powers = powerService.readAll();
        List<Organization> organizations = organizationDAO.getAllOrganizations();
        model.addAttribute("supers", supers);
        model.addAttribute("powers", powers);
        model.addAttribute("organzations", organizations);
        model.addAttribute("errors", violations);
        return "Supers";
    }

    @GetMapping("detailSuper")
    public String detailSuper(Integer superID, Model model) {
        Super s = superService.readByID(superID);
        List<Organization> organizations = organizationDAO.getOrganizationsBySuper(superID);
        List<Location> locations = locationService.readLocationsBySuper(superID);
        model.addAttribute("super", s);
        model.addAttribute("organizations", organizations);
        model.addAttribute("locations", locations);
        return "detailSuper";
    }

    @GetMapping("editSuper")
    public String editSuper(Integer superID, Model model) {
        Super s = superService.readByID(superID);
        List<Power> powers = powerService.readAll();
        model.addAttribute("super", s);
        model.addAttribute("powers", powers);
        model.addAttribute("existingPowers", s.getSuperPowers());
        return "editSuper";
    }

    @PostMapping("editSuper")
    public String performEditSuper(@Valid Super s, BindingResult result, HttpServletRequest request, Model model) {
        String[] powerIDs = request.getParameterValues("powerID");
        if (powerIDs != null) {
            List<Power> powers = new ArrayList<>();
            for (String powerID : powerIDs) {
                powers.add(powerService.readByID(Integer.parseInt(powerID)));
            }
            s.setSuperPowers(powers);
        }
        if (result.hasErrors()) {
            model.addAttribute("powers", powerService.readAll());
            model.addAttribute("super", s);
            return "editSuper";
        }
        superService.update(s);
        return "redirect:/Supers";
    }

    @GetMapping("deleteSuper")
    public String deleteSuper(Integer superID) {
        superService.delete(superID);
        return "redirect:/Supers";
    }
}
