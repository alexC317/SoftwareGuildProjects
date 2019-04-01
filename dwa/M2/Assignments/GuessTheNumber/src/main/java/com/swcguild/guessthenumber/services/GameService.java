/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.services;

import com.swcguild.guessthenumber.dtos.Game;
import com.swcguild.guessthenumber.dtos.Round;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface GameService {
    
    public Game beginGame();

    public Round checkGuess(String guess, int gameID);
    
    public List<Game> getAllGames();
    
    public Game getGameByID(int id);
    
    public List<Round> getAllRoundsByGameID(int gameID);
}
