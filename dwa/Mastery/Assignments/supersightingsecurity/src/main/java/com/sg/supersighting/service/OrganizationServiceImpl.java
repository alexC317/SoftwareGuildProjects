/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.OrganizationDAO;
import com.sg.supersighting.dto.Organization;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDAO organizationDAO;
    
    @Override
    public Organization create(Organization organization) {
        return organizationDAO.create(organization);
    }

    @Override
    public List<Organization> readAll() {
        return organizationDAO.readAll();
    }

    @Override
    public Organization readByID(int organizationID) {
        return organizationDAO.readByID(organizationID);
    }

    @Override
    public List<Organization> readAllBySuper(int superID) {
        return organizationDAO.readBySuperID(superID);
    }

    @Override
    public void update(Organization organization) {
        organizationDAO.update(organization);
    }

    @Override
    public void delete(int organizationID) {
        organizationDAO.delete(organizationID);
    }
    
}
