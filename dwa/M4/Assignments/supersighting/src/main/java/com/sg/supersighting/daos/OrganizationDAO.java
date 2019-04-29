/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.daos;

import com.sg.supersighting.dtos.Organization;
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
    public void updateOrganization(Organization organization);

    //Delete
    public void deleteOrganization(int organizationID);
    
    //Returns a List of Organizations that a Super belongs to
    public List<Organization> getAffiliatedOrganizations(int superID);

}
