/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.daos.SuperDAO;
import com.sg.supersighting.dtos.Super;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    SuperDAO superDAO;

    @Override
    public Super create(Super s) {
        return superDAO.addNewSuper(s);
    }

    @Override
    public List<Super> readAll() {
        return superDAO.getAllSupers();
    }

    @Override
    public Super readByID(int superID) {
        return superDAO.getSuperByID(superID);
    }

    @Override
    public List<Super> readSupersByOrganization(int organizationID) {
        return superDAO.getAllSupersByOrganization(organizationID);
    }

    @Override
    public List<Super> readSupersByLocation(int locationID) {
        return superDAO.getSupersByLocation(locationID);
    }

    @Override
    public void update(Super s) {
        superDAO.updateSuper(s);
    }

    @Override
    public void delete(int superID) {
        superDAO.deleteSuper(superID);
    }

}
