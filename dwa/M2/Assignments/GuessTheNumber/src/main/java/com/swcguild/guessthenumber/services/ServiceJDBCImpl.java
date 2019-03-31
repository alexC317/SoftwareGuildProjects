/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.services;

import com.swcguild.guessthenumber.daos.GameDAO;
import com.swcguild.guessthenumber.daos.RoundDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceJDBCImpl implements Service {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private RoundDAO roundDAO;

    @Override
    public String generateRandomNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkGuess(String guess) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
