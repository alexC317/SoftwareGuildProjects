/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Organization;
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
    public Super getSuperByID(int ID);

    //Update
    public void updateSuper(Super s);

    //Delete
    public void deleteSuper(int ID);

    //Returns a List of Organizations that a Super belongs to
    public List<Organization> getAffiliatedOrganizations(int ID);

}
