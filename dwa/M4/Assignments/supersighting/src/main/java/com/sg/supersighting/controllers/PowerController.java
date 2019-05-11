/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controllers;

import com.sg.supersighting.daos.PowerDAO;
import com.sg.supersighting.dtos.Power;
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
public class PowerController {

    @Autowired
    PowerDAO powerDAO;

    @PostMapping("addPower")
    public String addPower(String powerName, String powerDescription) {
        Power power = new Power();
        power.setPowerName(powerName);
        power.setPowerDescription(powerDescription);
        powerDAO.addNewPower(power);
        return "redirect:/Powers";
    }

    @GetMapping("Powers")
    public String displayPowers(Model model) {
        List<Power> powers = powerDAO.getAllPowers();
        model.addAttribute("powers", powers);
        return "Powers";
    }

    @GetMapping("editPower")
    public String editPower(Integer powerID, Model model) {
        Power power = powerDAO.getPowerByID(powerID);
        model.addAttribute("power", power);
        return "editPower";
    }

    @PostMapping("editPower")
    public String performEditPower(Power power) {
        powerDAO.updatePower(power);
        return "redirect:/Powers";
    }

    @GetMapping("deletePower")
    public String deletePower(Integer powerID) {
        powerDAO.deletePower(powerID);
        return "redirect:/Powers";
    }

}
