/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.dtos.Organization;
import com.sg.supersighting.dtos.Super;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface OrganizationService {

    public Organization create(Organization organization);

    public List<Organization> readAll();

    public Organization readByID(int organizationID);

    public List<Organization> readAllBySuper(int superID);

    public void update(Organization organization);

    public void delete(int organizationID);
}
