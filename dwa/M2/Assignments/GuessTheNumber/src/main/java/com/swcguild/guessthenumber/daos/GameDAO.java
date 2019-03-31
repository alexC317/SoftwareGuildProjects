/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.daos;

import com.swcguild.guessthenumber.dtos.Game;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface GameDAO {

    public Game create(Game game);

    public List<Game> readAll();

    public Game readByID(int id);

    public boolean update(Game game);

    public boolean delete(int id);

}
