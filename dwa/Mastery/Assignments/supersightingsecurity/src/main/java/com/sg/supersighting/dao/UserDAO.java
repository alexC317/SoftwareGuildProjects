/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.User;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface UserDAO {

    //Create
    public User create(User user);

    //Read All
    public List<User> readAll();

    //Read By ID
    public User readByID(int userID);
    
    //Read By Username
    public User readByUsername(String username);

    //Update
    public boolean update(User user);

    //Delete
    public boolean delete(int userID);
}
