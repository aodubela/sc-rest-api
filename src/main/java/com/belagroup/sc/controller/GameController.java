package com.belagroup.sc.controller;

import com.belagroup.sc.dto.GameDto;
import com.belagroup.sc.dto.Response;
import com.belagroup.sc.service.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller used to process game related requests.
 * Manages CRUD operations and data request for game
 * objects.
 *
 * @author aodubela
 */
@RestController
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameServiceImpl gameServiceImpl;


    /**
     * Finds a game object that corresponds to the id
     * passed in from path variable.
     *
     * @param id game object to find
     * @return response object with status of request and corresponding data
     */
    @RequestMapping(value = "/games/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response getGame(@PathVariable Long id) {

        if(logger.isDebugEnabled()){
            logger.debug("Processing request for getGame: " + id);
        }

        Response response = new Response();
        try {
            response.setMessage(gameServiceImpl.findGameById(id));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response.setStatus(Response.FAILED);
            response.setError(e.getMessage());
        }

        return response;
    }

    /**
     * Returns all games in the repository.
     * @return
     */
    @RequestMapping(value = "/games",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response getGames() {

        if(logger.isDebugEnabled()){
            logger.debug("Processing find all games request in getGames");
        }

        Response response = new Response();
        try {
            response.setMessage(gameServiceImpl.findAll());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response.setStatus(Response.FAILED);
            response.setError(e.getMessage());
        }
        return response;
    }

    /**
     * Creates a game object in repository based on gameDto
     * data passed in on the request body.
     *
     * @param gameDto data to persist
     * @return response with id of created game
     */
    @RequestMapping(value = "/games", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Response createGame(@RequestBody @Valid GameDto gameDto) {

        if(logger.isDebugEnabled()){
            logger.debug("Processing method createGame with gameDto: " + gameDto.toString());
        }

        Response response = new Response();
        try {
            response.setMessage(gameServiceImpl.createGame(gameDto));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response.setStatus(Response.FAILED);
            response.setError(e.getMessage());
        }
        return response;
    }

    /**
     * Removes a game from repository
     * @param id of game to remove
     */
    @RequestMapping(value = "/games/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response deleteGame(@PathVariable Long id) {

        if(logger.isDebugEnabled()){
            logger.debug("Processing method deleteGame for id: " + id);
        }

        Response response = new Response();
        try {
            gameServiceImpl.deleteGameById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response.setStatus(Response.FAILED);
            response.setError(e.getMessage());
        }
        return response;
    }
}
