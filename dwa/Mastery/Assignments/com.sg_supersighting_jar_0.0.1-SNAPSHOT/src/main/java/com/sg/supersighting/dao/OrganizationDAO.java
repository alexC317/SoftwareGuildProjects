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
    public Organization addNewOrganization(Organization organization);

    //Read All
    public List<Organization> getAllOrganizations();

    //Read By ID
    public Organization getOrganizationByID(int organizationID);

    //Update
    public Boolean updateOrganization(Organization organization);

    //Delete
    public Boolean deleteOrganization(int organizationID);
    
    //Returns a List of Organizations that a Super belongs to
    public List<Organization> getOrganizationsBySuper(int superID);

}
