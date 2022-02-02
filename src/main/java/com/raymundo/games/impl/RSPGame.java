package com.raymundo.games.impl;

import com.raymundo.domain.GameResult;
import com.raymundo.domain.PlayerOption;
import com.raymundo.games.Game;
import com.raymundo.service.GameService;
import com.raymundo.ui.Display;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.raymundo.ui.Messages.DEFAULT_ROUNDS;
import static com.raymundo.ui.Messages.DEFAULT_ROUNDS_MESSAGE;
import static com.raymundo.ui.Messages.GOODBYE_MESSAGE;
import static com.raymundo.ui.Messages.INVALID_ROUNDS;
import static com.raymundo.ui.Messages.ROUNDS_LEFT;
import static com.raymundo.ui.Messages.ROUNDS_TO_PLAY_MESSAGE;
import static com.raymundo.ui.Messages.SELECT_OPTION;
import static com.raymundo.ui.Messages.SELECT_ROUNDS;
import static com.raymundo.ui.Messages.WELCOME_MESSAGE;

public class RSPGame implements Game {

    private static final List<String> validInputs = List.of("0", "1", "2", "q");
    private final GameService gameService;
    private final Display display;
    private final Scanner scanner;
    private final Map<String, GameResult> results;

    public RSPGame(GameService gameService, Display display, Scanner scanner) {
        this.gameService = gameService;
        this.display = display;
        this.scanner = scanner;
        this.results = new HashMap<>();
    }

    @Override
    public void start() {
        display.message(WELCOME_MESSAGE);
        play(getRoundsToPlay());
    }

    @Override
    public void play(int roundsToPlay) {

        display.message(String.format(ROUNDS_TO_PLAY_MESSAGE, roundsToPlay));

        while (roundsToPlay > 0) {

            String userInput = getUserInput();
            if ("q".equals(userInput)) break;

            playRound(Integer.parseInt(userInput));

            roundsToPlay--;
            display.message(String.format(ROUNDS_LEFT, roundsToPlay));
        }
        end();
    }

    @Override
    public void end() {
        display.showResults(results);
        display.message(GOODBYE_MESSAGE);
    }

    private void playRound(int userInput) {
        PlayerOption playerOption = PlayerOption.fromInteger(userInput);
        PlayerOption computerOption = gameService.getComputerOption();
        GameResult gameResult = gameService.getGameResult(playerOption, computerOption);

        results.put(playerOption.getValue() + "-" + computerOption.getValue(), gameResult);
        display.showResult(playerOption, computerOption, gameResult);
    }

    private String getUserInput() {
        display.message(SELECT_OPTION);
        String userInput = scanner.next();
        while (!validInput(userInput)) {
            display.message(SELECT_OPTION);
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    private boolean validInput(String userInput) {
        return validInputs.contains(userInput);
    }

    private int getRoundsToPlay() {
        display.message(SELECT_ROUNDS);
        int roundsToPlay;
        if (scanner.hasNextInt()) {
            roundsToPlay = scanner.nextInt();
        } else {
            scanner.next();
            roundsToPlay = DEFAULT_ROUNDS;
            display.message(String.format(INVALID_ROUNDS, DEFAULT_ROUNDS));
        }
        if (roundsToPlay > 10) {
            display.message(String.format(DEFAULT_ROUNDS_MESSAGE, roundsToPlay, DEFAULT_ROUNDS));
            roundsToPlay = DEFAULT_ROUNDS;
        }
        return roundsToPlay;
    }


}
