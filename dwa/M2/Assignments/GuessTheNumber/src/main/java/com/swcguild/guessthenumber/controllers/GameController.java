/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessthenumber.controllers;

import com.swcguild.guessthenumber.dtos.Game;
import com.swcguild.guessthenumber.dtos.Round;
import com.swcguild.guessthenumber.services.GameService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alex
 */
@RestController
@RequestMapping("/api")
public class GameController {
    
    private final GameService gameService;
    
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int beginGame() {
        Game game = gameService.beginGame();
        return game.getID();
    }
    
    @PostMapping("/guess")
    public Round checkGuess(@RequestBody String guess, @RequestBody int gameID) {
        Round round = gameService.checkGuess(guess, gameID);
        return round;
    }
    
    @GetMapping("/game")
    public List<Game> getAllGames() {
        List<Game> games = gameService.getAllGames();
        for (Game game : games) {
            if (!game.getIsFinished()) {
                game.setAnswer("Still not solved!");
            }
        }
        return games;
    }
    
    @GetMapping("/game/{gameID}")
    public ResponseEntity<Game> getGameByID(@PathVariable int gameID) {
        Game game = gameService.getGameByID(gameID);
        if (game == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        
        if (!game.getIsFinished()) {
            game.setAnswer("Still not solved!");
        }
        return ResponseEntity.ok(game);
    }
    
    @GetMapping("/rounds/{gameID}")
    public List<Round> getAllRoundsByID(int gameID) {
        List<Round> rounds = gameService.getAllRoundsByGameID(gameID);
        return rounds;
    }
    
}
