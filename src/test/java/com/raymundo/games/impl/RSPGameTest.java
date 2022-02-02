package com.raymundo.games.impl;

import com.raymundo.service.GameService;
import com.raymundo.ui.Display;
import com.raymundo.ui.PrintStreamFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;


class RSPGameTest {

    private RSPGame rspGame;

    @Mock
    GameService gameService;

    @Mock
    Display display;

    @Mock
    Scanner scanner;

    @BeforeEach
    void setUp() {
        rspGame = new RSPGame(gameService, display,scanner);
    }

    @Test
    void testStart() {
    }
}