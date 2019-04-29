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
public interface OrganizationDAO {

    //Create
    public Organization addNewOrganization(Organization organization);

    //Read All
    public List<Organization> getAllOrganizations();

    //Read By ID
    public Organization getOrganizationByID(int ID);

    //Update
    public void updateOrganization(Organization organization);

    //Delete
    public void deleteOrganization(int ID);
    
    //Returns a List of Supers for a particular Organization
    public List<Super> getAllMembers(int ID);

}
