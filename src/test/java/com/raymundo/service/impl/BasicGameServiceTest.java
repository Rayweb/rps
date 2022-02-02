package com.raymundo.service.impl;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.raymundo.domain.GameResult.DRAW;
import static com.raymundo.domain.GameResult.WON;
import static com.raymundo.domain.GameResult.LOST;
import static com.raymundo.domain.PlayerOption.PAPER;
import static com.raymundo.domain.PlayerOption.ROCK;
import static com.raymundo.domain.PlayerOption.SCISSORS;
import static org.junit.jupiter.api.Assertions.*;

class BasicGameServiceTest {

    private BasicGameService basicGameService;

    @BeforeEach
    void setUp() {
        basicGameService = new BasicGameService();
    }

    @Test
    void drawTest(){
        assertEquals(basicGameService.getGameResult(ROCK, ROCK), DRAW);
        assertEquals(basicGameService.getGameResult(PAPER, PAPER), DRAW);
        assertEquals(basicGameService.getGameResult(SCISSORS, SCISSORS), DRAW);
    }

    @Test
    void rockWinsTest(){
        assertEquals(basicGameService.getGameResult(ROCK,SCISSORS), WON);
    }

    @Test
    void rockLossesTest(){
        assertEquals(basicGameService.getGameResult(ROCK,PAPER), LOST);
    }

    @Test
    void paperWinsTest(){
        assertEquals(basicGameService.getGameResult(PAPER,ROCK), WON);
    }

    @Test
    void paperLossesTest(){
        assertEquals(basicGameService.getGameResult(PAPER,SCISSORS), LOST);
    }

    @Test
    void scissorsWinsTest(){
        assertEquals(basicGameService.getGameResult(SCISSORS,PAPER), WON);
    }

    @Test
    void scissorsLossesTest(){
        assertEquals(basicGameService.getGameResult(SCISSORS,ROCK), LOST);
    }
}