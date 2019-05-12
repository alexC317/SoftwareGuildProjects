/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.daos.OrganizationDAO;
import com.sg.supersighting.daos.PowerDAO;
import com.sg.supersighting.daos.SuperDAO;
import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Power;
import com.sg.supersighting.dtos.Super;
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
public class SuperController {

    @Autowired
    SuperDAO superDAO;

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    OrganizationDAO organizationDAO;

    @PostMapping("addSuper")
    public String addSuper() {
        return "redirect:/Supers";
    }

    @GetMapping("Supers")
    public String displaysSupers(Model model) {
        List<Super> supers = superDAO.getAllSupers();
        List<Power> powers = powerDAO.getAllPowers();
        List<Organization> organizations = organizationDAO.getAllOrganizations();
        model.addAttribute("supers", supers);
        model.addAttribute("powers", powers);
        model.addAttribute("organzations", organizations);
        return "Supers";
    }
}
