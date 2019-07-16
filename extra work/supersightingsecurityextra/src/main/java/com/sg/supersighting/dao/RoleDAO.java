/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Role;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface RoleDAO {

    //Create
    public Role create(Role role);

    //Read All
    public List<Role> readAll();

    //Read By ID
    public Role readByID(int roleID);

    //Read By Role
    public Role readByRole(String role);

    //Update
    public boolean update(Role role);

    //Delete
    public boolean delete(int roleID);

}
