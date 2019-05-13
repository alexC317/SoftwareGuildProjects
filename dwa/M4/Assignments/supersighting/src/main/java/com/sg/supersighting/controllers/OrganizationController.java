/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.daos.LocationDAO;
import com.sg.supersighting.daos.OrganizationDAO;
import com.sg.supersighting.daos.PowerDAO;
import com.sg.supersighting.daos.SuperDAO;
import com.sg.supersighting.dtos.Location;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Super;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class OrganizationController {

    @Autowired
    OrganizationDAO organizationDAO;

    @Autowired
    SuperDAO superDAO;

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    LocationDAO locationDAO;

    @PostMapping("addOrganization")
    public String addOrganization(Organization organization, HttpServletRequest request) {
        if (request.getParameter("locationID") != null) {
            String locationID = request.getParameter("locationID");
            organization.setOrganizationAddress(locationDAO.getLocationByID(Integer.parseInt(locationID)));
        }

        if (request.getParameterValues("superID") != null) {
            String[] superIDs = request.getParameterValues("superID");
            List<Super> supers = new ArrayList<>();
            for (String superID : superIDs) {
                supers.add(superDAO.getSuperByID(Integer.parseInt(superID)));
            }

            organization.setSupers(supers);

        }

        organizationDAO.addNewOrganization(organization);
        return "redirect:/Organizations";
    }

    @GetMapping("Organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDAO.getAllOrganizations();
        List<Location> locations = locationDAO.getAllLocations();
        List<Super> supers = superDAO.getAllSupers();
        model.addAttribute("organizations", organizations);
        model.addAttribute("locations", locations);
        model.addAttribute("supers", supers);
        return "Organizations";
    }

    @GetMapping("detailOrganization")
    public String detailOrganization(Integer organizationID, Model model) {
        Organization organization = organizationDAO.getOrganizationByID(organizationID);
        Location location = locationDAO.getLocationByID(organization.getOrganizationAddress().getLocationID());
        List<Super> supers = superDAO.getAllSupersByOrganization(organizationID);
        model.addAttribute("organization", organization);
        model.addAttribute("location", location);
        model.addAttribute("supers", supers);
        return "detailOrganization";
    }

    @GetMapping("editOrganization")
    public String editOrganization(Integer organizationID, Model model) {
        Organization organization = organizationDAO.getOrganizationByID(organizationID);
        List<Location> locations = locationDAO.getAllLocations();
        List<Super> supers = superDAO.getAllSupers();
        model.addAttribute("organization", organization);
        model.addAttribute("locations", locations);
        model.addAttribute("supers", supers);
        return "editOrganization";
    }

    @PostMapping("editOrganization")
    public String performEditOrganization(Organization organization, HttpServletRequest request) {
        String locationID = request.getParameter("locationID");
        organization.setOrganizationAddress(locationDAO.getLocationByID(Integer.parseInt(locationID)));

        if (request.getParameterValues("superID") != null) {
            String[] superIDs = request.getParameterValues("superID");
            List<Super> supers = new ArrayList<>();
            for (String superID : superIDs) {
                supers.add(superDAO.getSuperByID(Integer.parseInt(superID)));
            }

            organization.setSupers(supers);
        }

        organizationDAO.updateOrganization(organization);
        return "redirect:/Organizations";
    }

    @GetMapping("deleteOrganization")
    public String deleteOrganization(Integer organizationID) {
        organizationDAO.deleteOrganization(organizationID);
        return "redirect:/Organizations";
    }
}
