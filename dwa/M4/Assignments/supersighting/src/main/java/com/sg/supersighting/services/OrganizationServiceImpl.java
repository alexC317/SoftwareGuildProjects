/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.daos.OrganizationDAO;
import com.sg.supersighting.dtos.Organization;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDAO organizationDAO;
    
    @Override
    public Organization create(Organization organization) {
        return organizationDAO.addNewOrganization(organization);
    }

    @Override
    public List<Organization> readAll() {
        return organizationDAO.getAllOrganizations();
    }

    @Override
    public Organization readByID(int organizationID) {
        return organizationDAO.getOrganizationByID(organizationID);
    }

    @Override
    public List<Organization> readAllBySuper(int superID) {
        return organizationDAO.getOrganizationsBySuper(superID);
    }

    @Override
    public void update(Organization organization) {
        organizationDAO.updateOrganization(organization);
    }

    @Override
    public void delete(int organizationID) {
        organizationDAO.deleteOrganization(organizationID);
    }
    
}
