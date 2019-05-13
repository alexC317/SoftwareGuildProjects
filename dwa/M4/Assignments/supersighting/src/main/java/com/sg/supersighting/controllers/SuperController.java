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
    SuperDAO superDAO;

    @Autowired
    PowerDAO powerDAO;

    @Autowired
    OrganizationDAO organizationDAO;

    @PostMapping("addSuper")
    public String addSuper(Super s, HttpServletRequest request) {
        String[] powerIDs = request.getParameterValues("powerID");
        if (powerIDs != null) {
            List<Power> powers = new ArrayList<>();
            for (String powerID : powerIDs) {
                powers.add(powerDAO.getPowerByID(Integer.parseInt(powerID)));
            }
            s.setSuperPowers(powers);
        }
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(s);
        if (violations.isEmpty()) {
            superDAO.addNewSuper(s);
        }
        return "redirect:/Supers";
    }

    @GetMapping("Supers")
    public String displaySupers(Model model) {
        List<Super> supers = superDAO.getAllSupers();
        List<Power> powers = powerDAO.getAllPowers();
        List<Organization> organizations = organizationDAO.getAllOrganizations();
        model.addAttribute("supers", supers);
        model.addAttribute("powers", powers);
        model.addAttribute("organzations", organizations);
        model.addAttribute("errors", violations);
        return "Supers";
    }

    @GetMapping("detailSuper")
    public String detailSuper(Integer superID, Model model) {
        Super s = superDAO.getSuperByID(superID);
        List<Organization> organizations = organizationDAO.getOrganizationsBySuper(superID);
        model.addAttribute("super", s);
        model.addAttribute("organizations", organizations);
        return "detailSuper";
    }

    @GetMapping("editSuper")
    public String editSuper(Integer superID, Model model) {
        Super s = superDAO.getSuperByID(superID);
        List<Power> powers = powerDAO.getAllPowers();
        model.addAttribute("super", s);
        model.addAttribute("powers", powers);
        return "editSuper";
    }

    @PostMapping("editSuper")
    public String performEditSuper(@Valid Super s, BindingResult result, HttpServletRequest request, Model model) {
        String[] powerIDs = request.getParameterValues("powerID");
        if (powerIDs != null) {
            List<Power> powers = new ArrayList<>();
            for (String powerID : powerIDs) {
                powers.add(powerDAO.getPowerByID(Integer.parseInt(powerID)));
            }
            s.setSuperPowers(powers);
        }
        if (result.hasErrors()) {
            model.addAttribute("powers", powerDAO.getAllPowers());
            model.addAttribute("super", s);
            return "editSuper";
        }
        superDAO.updateSuper(s);
        return "redirect:/Supers";
    }

    @GetMapping("deleteSuper")
    public String deleteSuper(Integer superID) {
        superDAO.deleteSuper(superID);
        return "redirect:/Supers";
    }
}
