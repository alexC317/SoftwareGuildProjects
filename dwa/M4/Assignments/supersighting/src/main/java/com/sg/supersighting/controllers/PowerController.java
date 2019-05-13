/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.daos.PowerDAO;
import com.sg.supersighting.dtos.Power;
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
public class PowerController {

    @Autowired
    PowerDAO powerDAO;

    Set<ConstraintViolation<Power>> violations = new HashSet<>();

    @PostMapping("addPower")
    public String addPower(String powerName, String powerDescription) {
        Power power = new Power();
        power.setPowerName(powerName);
        power.setPowerDescription(powerDescription);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(power);
        if (violations.isEmpty()) {
            powerDAO.addNewPower(power);
        }
        return "redirect:/Powers";
    }

    @GetMapping("Powers")
    public String displayPowers(Model model) {
        List<Power> powers = powerDAO.getAllPowers();
        model.addAttribute("powers", powers);
        model.addAttribute("errors", violations);
        return "Powers";
    }

    @GetMapping("editPower")
    public String editPower(Integer powerID, Model model) {
        Power power = powerDAO.getPowerByID(powerID);
        model.addAttribute("power", power);
        return "editPower";
    }

    @PostMapping("editPower")
    public String performEditPower(@Valid Power power, BindingResult result) {
        if (result.hasErrors()) {
            return "editPower";
        }
        powerDAO.updatePower(power);
        return "redirect:/Powers";
    }

    @GetMapping("deletePower")
    public String deletePower(Integer powerID) {
        powerDAO.deletePower(powerID);
        return "redirect:/Powers";
    }

}
