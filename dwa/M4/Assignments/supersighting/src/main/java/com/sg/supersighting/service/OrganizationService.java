/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dtos.Organization;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface OrganizationService {

    public Organization create();

    public List<Organization> readAll();

    public Organization readByID();

    public void update();

    public void delete();
}
