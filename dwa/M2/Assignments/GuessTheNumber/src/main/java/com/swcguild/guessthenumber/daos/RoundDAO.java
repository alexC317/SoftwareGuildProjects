/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.dtos.Round;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface RoundDAO {

    public Round create(Round round);

    public List<Round> readAll();

    public Round readByID(int id);

    public List<Round> readByGameID(int id);

    public boolean delete(int id);
}
