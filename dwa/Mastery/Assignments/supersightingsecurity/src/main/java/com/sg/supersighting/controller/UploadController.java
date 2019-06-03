/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controller;

import com.sg.supersighting.dto.Super;
import com.sg.supersighting.service.SuperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Alex
 */
@Controller
public class UploadController {

    @Autowired
    SuperService superService;

    @GetMapping("/upload")
    public String displayUploadPage(Model model) {
        List<Super> supers = superService.readAll();
        model.addAttribute("supers", supers);
        return "/upload";
    }
    
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "/upload";
    }
}
