/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Super;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SuperDAO {

    //Create
    public Super create(Super s);

    //Read All
    public List<Super> readAll();

    //Read By ID
    public Super readByID(int superID);

    //Update
    public Boolean update(Super s);

    //Delete
    public Boolean delete(int superID);

    //Returns a List of Supers for a particular Organization
    public List<Super> readByOrganizationID(int organizationID);

    //Returns a List of Supers spotted in a specific Location
    public List<Super> readByLocationID(int locationID);

}
