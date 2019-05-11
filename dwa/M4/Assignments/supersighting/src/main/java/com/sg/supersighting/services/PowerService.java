/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.dtos.Power;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface PowerService {

    //Create
    public Power create(Power power);

    //ReadAll
    public List<Power> readAll();

    //ReadByID
    public Power readByID(int powerID);

    //Update
    public void update(Power power);

    //Delete
    public void delete(int powerID);

}
