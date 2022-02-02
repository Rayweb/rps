package com.raymundo.ui;

import com.raymundo.domain.GameResult;
import com.raymundo.domain.PlayerOption;;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;


import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {

    private Display display;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUp() {
        display = new Display(new PrintStream(outContent));
        System.setOut(new PrintStream(outContent,true, UTF_8));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);

    }

    @Test
    void displayMessageTest() {
        display.message("Test");
        assertEquals("Test\n", outContent.toString());
    }

    @Test
    void displayShowResultsTest(){
        display.showResults(Map.of("0-0", GameResult.DRAW));
        assertEquals("Total games played 1,  You won 0 and lost 0 and tied 1\n", outContent.toString());
    }

    @Test
    void displayShowResultsEmptyRoundsTest(){
        display.showResults(Map.of());
        assertEquals("Total games played 0,  You won 0 and lost 0 and tied 0\n", outContent.toString());
    }

    @Test
    void displayShowResultDrawTest() {
        display.showResult(PlayerOption.ROCK, PlayerOption.ROCK, GameResult.DRAW);
        assertEquals("You selected : 🤜\nI selected : 🤜\nResult : We both picked 🤜. It's a draw! ⚠️\n" , outContent.toString());
    }

    @Test
    void displayShowResultWonTest() {
        display.showResult(PlayerOption.ROCK, PlayerOption.SCISSORS, GameResult.WON);
        assertEquals("You selected : \uD83E\uDD1C\n" +
                "I selected : ✌️️\n" +
                "Result : \uD83E\uDD1C beats ✌️️. You won ✅️️\n" , outContent.toString());
    }

    @Test
    void displayShowResultLostTest() {
        display.showResult(PlayerOption.ROCK, PlayerOption.PAPER, GameResult.LOST);
        assertEquals("You selected : \uD83E\uDD1C\n" +
                "I selected : \uD83D\uDD90️️\n" +
                "Result : \uD83D\uDD90️️ beats \uD83E\uDD1C. You lost ⛔\n" , outContent.toString());
    }
}