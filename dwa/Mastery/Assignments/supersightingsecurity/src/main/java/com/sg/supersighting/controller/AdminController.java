/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.controller;

import com.sg.supersighting.dao.RoleDAO;
import com.sg.supersighting.dao.UserDAO;
import com.sg.supersighting.dto.Role;
import com.sg.supersighting.dto.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alex
 */
@Controller
public class AdminController {

    @Autowired
    UserDAO users;

    @Autowired
    RoleDAO roles;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/admin")
    public String displayAdminPage(Model model) {
        model.addAttribute("users", users.readAll());
        return "admin";
    }

    @PostMapping("/addUser")
    public String addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setEnabled(true);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roles.readByRole("ROLE_SIDEKICK"));
        user.setRoles(userRoles);

        users.create(user);

        return "redirect:/admin";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Integer userID) {
        users.delete(userID);
        return "redirect:/admin";
    }
}
