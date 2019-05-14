/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.services;

import com.sg.supersighting.daos.PowerDAO;
import com.sg.supersighting.dtos.Power;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerDAO powerDAO;

    @Override
    public Power create(Power power) {
        return powerDAO.addNewPower(power);
    }

    @Override
    public List<Power> readAll() {
        return powerDAO.getAllPowers();
    }

    @Override
    public Power readByID(int powerID) {
        return powerDAO.getPowerByID(powerID);
    }

    @Override
    public void update(Power power) {
        powerDAO.updatePower(power);
    }

    @Override
    public void delete(int powerID) {
        powerDAO.deletePower(powerID);
    }

}
