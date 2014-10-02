package com.belagroup.sc.service;

import com.belagroup.sc.dto.GameDto;
import com.belagroup.sc.model.Game;
import com.belagroup.sc.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameDto gmMock;

    @Mock
    GameRepository grMock;

    @Mock
    Game gameMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        gameService = new GameServiceImpl();

        //assign to test subject
        gameService.setGameRepository(grMock);
    }

    @Test
    public void testCreateGame() throws Exception {

        Long gameId = new Long("1");
        Date eventDate = new Date();
        String username = "tester";

        //create stubs
        when(gmMock.getGameDate()).thenReturn(eventDate);
        when(gmMock.getName()).thenReturn(username);
        when(grMock.saveAndFlush(any(Game.class))).thenReturn(gameMock);

        gameService.createGame(gmMock);

        verify(gmMock).getGameDate();
        verify(gmMock).getName();
        verify(grMock).saveAndFlush(any(Game.class));
    }
}
