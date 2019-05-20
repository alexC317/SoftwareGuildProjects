/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.SuperDAO;
import com.sg.supersighting.dto.Super;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    SuperDAO superDAO;

    @Override
    public Super create(Super s) {
        return superDAO.create(s);
    }

    @Override
    public List<Super> readAll() {
        return superDAO.readAll();
    }

    @Override
    public Super readByID(int superID) {
        return superDAO.readByID(superID);
    }

    @Override
    public List<Super> readSupersByOrganization(int organizationID) {
        return superDAO.readByOrganizationID(organizationID);
    }

    @Override
    public List<Super> readSupersByLocation(int locationID) {
        return superDAO.readByLocationID(locationID);
    }

    @Override
    public void update(Super s) {
        superDAO.update(s);
    }

    @Override
    public void delete(int superID) {
        superDAO.delete(superID);
    }

}
