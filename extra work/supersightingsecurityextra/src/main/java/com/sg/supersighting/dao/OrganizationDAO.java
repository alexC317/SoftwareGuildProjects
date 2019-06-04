/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import com.sg.supersighting.dto.Organization;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface OrganizationDAO {

    //Create
    public Organization create(Organization organization);

    //Read All
    public List<Organization> readAll();

    //Read By ID
    public Organization readByID(int organizationID);

    //Update
    public Boolean update(Organization organization);

    //Delete
    public Boolean delete(int organizationID);
    
    //Returns a List of Organizations that a Super belongs to
    public List<Organization> readBySuperID(int superID);

}
