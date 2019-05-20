/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import com.sg.supersighting.dao.PowerDAO;
import com.sg.supersighting.dto.Power;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerDAO powerDAO;

    @Override
    public Power create(Power power) {
        return powerDAO.create(power);
    }

    @Override
    public List<Power> readAll() {
        return powerDAO.readAll();
    }

    @Override
    public Power readByID(int powerID) {
        return powerDAO.readByID(powerID);
    }

    @Override
    public void update(Power power) {
        powerDAO.update(power);
    }

    @Override
    public void delete(int powerID) {
        powerDAO.delete(powerID);
    }

}
