package com.belagroup.sc.service;

import com.belagroup.sc.dto.GameDto;
import com.belagroup.sc.model.Game;
import com.belagroup.sc.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation of game service interface.
 *
 * @author aodubela
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameServiceImpl() {
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findGameById(Long id) {
        return gameRepository.findOne(id);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public void deleteGameById(Long id) {
        gameRepository.delete(id);
    }

    public Long createGame(GameDto gameDto) {

        Game game = new Game();
        game.setName(gameDto.getName());
        game.setGameDate(gameDto.getGameDate());

        gameRepository.saveAndFlush(game);
        return game.getId();
    }
}
