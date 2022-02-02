package com.raymundo.domain;

import static com.raymundo.ui.Messages.PAPER_EMOJI;
import static com.raymundo.ui.Messages.ROCK_EMOJI;
import static com.raymundo.ui.Messages.SCISSORS_EMOJI;

public enum PlayerOption {
    ROCK(0, ROCK_EMOJI),
    PAPER(1, PAPER_EMOJI),
    SCISSORS(2, SCISSORS_EMOJI);

    private final int value;
    private final String emoji;

    PlayerOption(int value, String emoji) {
        this.value = value;
        this.emoji = emoji;
    }

    public static PlayerOption fromInteger(int option) {
        switch (option) {
            case 0:
                return ROCK;
            case 1:
                return PAPER;
            case 2:
                return SCISSORS;
            default:
                return null;
        }
    }

    public int getValue() {
        return value;
    }

    public String getEmoji() {
        return emoji;
    }
}
