package com.raymundo.ui;

import com.raymundo.domain.GameResult;
import com.raymundo.domain.PlayerOption;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;

import static com.raymundo.ui.Messages.COMPUTER_SELECTION;
import static com.raymundo.ui.Messages.DRAW_MESSAGE;
import static com.raymundo.ui.Messages.LOST_MESSAGE;
import static com.raymundo.ui.Messages.PLAYER_SELECTION;
import static com.raymundo.ui.Messages.TOTALS;
import static com.raymundo.ui.Messages.WON_MESSAGE;

public class Display {

    private final PrintStream print;

    public Display(PrintStream print) {
        this.print = print;
    }

    public void message(String message) {
        print.println(message);
    }

    public void showResults(Map<String, GameResult> results) {
        long rounds = results != null ? results.values().stream().count() : 0;
        if (rounds > 0) {
            Collection<GameResult> values = results.values();
            long wins = values.stream().filter(gameResult -> gameResult.equals(GameResult.WON)).count();
            long losses = values.stream().filter(gameResult -> gameResult.equals(GameResult.LOST)).count();
            long draws = values.stream().filter(gameResult -> gameResult.equals(GameResult.DRAW)).count();
            message(String.format(TOTALS, rounds, wins, losses, draws));
        } else {
            message(String.format(TOTALS, 0, 0, 0, 0));
        }
    }

    public void showResult(PlayerOption playerOption, PlayerOption computerOption, GameResult gameResult) {
        message(String.format(PLAYER_SELECTION, playerOption.getEmoji()));
        message(String.format(COMPUTER_SELECTION, computerOption.getEmoji()));
        switch (gameResult) {
            case DRAW:
                message(String.format(DRAW_MESSAGE,
                        playerOption.getEmoji(),
                        gameResult.getEmoji()));
                break;
            case WON:
                message(String.format(WON_MESSAGE,
                        playerOption.getEmoji(),
                        computerOption.getEmoji(),
                        gameResult.getEmoji()));
                break;
            default:
                message(String.format(LOST_MESSAGE,
                        computerOption.getEmoji(),
                        playerOption.getEmoji(),
                        gameResult.getEmoji()));
                break;

        }
    }
}
