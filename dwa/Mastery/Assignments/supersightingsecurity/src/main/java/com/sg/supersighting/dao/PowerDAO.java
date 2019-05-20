/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Power;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface PowerDAO {

    //Create
    public Power addNewPower(Power power);

    //Read All
    public List<Power> getAllPowers();

    //Read By ID
    public Power getPowerByID(int powerID);

    //Update
    public Boolean updatePower(Power power);

    //Delete
    public Boolean deletePower(int powerID);

}
