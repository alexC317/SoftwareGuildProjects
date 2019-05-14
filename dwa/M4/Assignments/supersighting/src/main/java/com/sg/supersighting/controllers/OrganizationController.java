/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Super;
import com.sg.supersighting.services.LocationService;
import com.sg.supersighting.services.OrganizationService;
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
public class OrganizationController {

    Set<ConstraintViolation<Organization>> violations = new HashSet<>();

    @Autowired
    OrganizationService organizationService;

    @Autowired
    SuperService superService;

    @Autowired
    PowerService powerService;

    @Autowired
    LocationService locationService;

    @PostMapping("addOrganization")
    public String addOrganization(Organization organization, HttpServletRequest request) {
        String locationID = request.getParameter("locationID");
        String[] superIDs = request.getParameterValues("superID");

        if (locationID != null) {
            organization.setOrganizationAddress(locationService.readByID(Integer.parseInt(locationID)));
        }
        if (superIDs != null) {
            List<Super> supers = new ArrayList<>();
            for (String superID : superIDs) {
                supers.add(superService.readByID(Integer.parseInt(superID)));
            }
            organization.setSupers(supers);
        }
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(organization);
        if (violations.isEmpty()) {
            organizationService.create(organization);
        }
        return "redirect:/Organizations";
    }

    @GetMapping("Organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationService.readAll();
        List<Location> locations = locationService.readAll();
        List<Super> supers = superService.readAll();
        model.addAttribute("organizations", organizations);
        model.addAttribute("locations", locations);
        model.addAttribute("supers", supers);
        model.addAttribute("errors", violations);
        return "Organizations";
    }

    @GetMapping("detailOrganization")
    public String detailOrganization(Integer organizationID, Model model) {
        Organization organization = organizationService.readByID(organizationID);
        Location location = locationService.readByID(organization.getOrganizationAddress().getLocationID());
        List<Super> supers = superService.readSupersByOrganization(organizationID);
        model.addAttribute("organization", organization);
        model.addAttribute("location", location);
        model.addAttribute("supers", supers);
        return "detailOrganization";
    }

    @GetMapping("editOrganization")
    public String editOrganization(Integer organizationID, Model model) {
        Organization organization = organizationService.readByID(organizationID);
        Location existingLocation = organization.getOrganizationAddress();
        List<Location> locations = locationService.readAll();
        List<Super> supers = superService.readAll();
        List<Super> existingSupers = superService.readSupersByLocation(organizationID);
        model.addAttribute("organization", organization);
        model.addAttribute("existingLocation", existingLocation);
        model.addAttribute("existingSupers", existingSupers);
        model.addAttribute("locations", locations);
        model.addAttribute("supers", supers);

        for (Super s : supers) {
            System.out.println(s.getSuperName() + ": " + existingSupers.contains(s));
        }
        return "editOrganization";
    }

    @PostMapping("editOrganization")
    public String performEditOrganization(@Valid Organization organization, BindingResult result, HttpServletRequest request, Model model) {
        String locationID = request.getParameter("locationID");
        String[] superIDs = request.getParameterValues("superID");
        organization.setOrganizationAddress(locationService.readByID(Integer.parseInt(locationID)));

        if (superIDs != null) {
            List<Super> supers = new ArrayList<>();
            for (String superID : superIDs) {
                supers.add(superService.readByID(Integer.parseInt(superID)));
            }
            organization.setSupers(supers);
        }
        if (result.hasErrors()) {
            model.addAttribute("organization", organization);
            model.addAttribute("locations", locationService.readAll());
            model.addAttribute("supers", superService.readAll());
            return "editOrganization";
        }
        organizationService.update(organization);
        return "redirect:/Organizations";
    }

    @GetMapping("deleteOrganization")
    public String deleteOrganization(Integer organizationID) {
        organizationService.delete(organizationID);
        return "redirect:/Organizations";
    }
}
