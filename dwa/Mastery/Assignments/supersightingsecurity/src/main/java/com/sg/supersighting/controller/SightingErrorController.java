/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Alex
 */
@Controller
public class SightingErrorController implements ErrorController {

    @GetMapping("/error")
    public String displayErrorPage(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        if (status != null) {
            model.addAttribute("errorCode", "Error code: " + status.toString());
            model.addAttribute("errorMessage", "Error message: " + message.toString());
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
