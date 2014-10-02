package com.belagroup.sc.service;

import com.belagroup.sc.dto.GameDto;
import com.belagroup.sc.model.Game;

import java.util.List;


/**
 * Service used to process all game related operations.
 *
 * @author aodubela
 */
public interface GameService {

    /**
     * Searches repository for game object with
     * given id and returns it.
     *
     * @param id of game to find
     * @return game object
     */
    public Game findGameById(Long id);


    /**
     * Returns all games in repository.
     * @return list of game objects
     */
    public List<Game> findAll();


    /**
     * Rmoves a game object from repository with the
     * given id.
     *
     * @param id of game to remove
     */
    public void deleteGameById(Long id);


    /**
     * Creates a new game with the repository
     * based on the dto object passed to the method.
     * If successful the id of the newly created game is
     * returned
     *
     * @param gameDto game object data to persist to repository
     * @return id of game object created
     */
    public Long createGame(GameDto gameDto);

}
