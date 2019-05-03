/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Super;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SuperDAO {

    //Create
    public Super addNewSuper(Super s);

    //Read All
    public List<Super> getAllSupers();

    //Read By ID
    public Super getSuperByID(int superID);

    //Update
    public Boolean updateSuper(Super s);

    //Delete
    public Boolean deleteSuper(int superID);

    //Returns a List of Supers for a particular Organization
    public List<Super> getAllSuperByOrganization(int organizationID);

    //Returns a List of Supers spotted in a specific Location
    public List<Super> getSightingsByLocation(int locationID);

}
