/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.dtos.Super;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface SuperService {

    //Create
    public Super create(Super s);

    public List<Super> readAll();

    public Super readByID(int superID);

    public List<Super> readSupersByOrganization(int organizationID);

    public List<Super> readSupersByLocation(int locationID);

    public void update(Super s);

    public void delete(int superID);

}
