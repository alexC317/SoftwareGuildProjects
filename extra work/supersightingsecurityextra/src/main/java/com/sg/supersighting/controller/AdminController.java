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
import java.util.List;
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

    @GetMapping("/editUser")
    public String editUserDisplay(Model model, Integer userID, Integer error) {
        User user = users.readByID(userID);
        List roleList = roles.readAll();

        model.addAttribute("user", user);
        model.addAttribute("roles", roleList);

        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "Passwords did not match, password was not updated.");
            }
        }

        return "editUser";
    }

    @PostMapping(value = "/editUser")
    public String editUserAction(String[] roleIdList, Boolean enabled, Integer userID) {
        User user = users.readByID(userID);
        if (enabled != null) {
            user.setEnabled(enabled);
        } else {
            user.setEnabled(false);
        }

        Set<Role> roleList = new HashSet<>();
        for (String roleId : roleIdList) {
            Role role = roles.readByID(Integer.parseInt(roleId));
            roleList.add(role);
        }
        user.setRoles(roleList);
        users.update(user);

        return "redirect:/admin";
    }

    @PostMapping("editPassword")
    public String editPassword(Integer userID, String password, String confirmPassword) {
        User user = users.readByID(userID);

        if (password.equals(confirmPassword)) {
            user.setPassword(encoder.encode(password));
            users.update(user);
            return "redirect:/admin";
        } else {
            return "redirect:/editUser?userID=" + userID + "&error=1";
        }
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Integer userID) {
        users.delete(userID);
        return "redirect:/admin";
    }
}
