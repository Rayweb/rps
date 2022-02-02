package com.raymundo.domain;

import static com.raymundo.ui.Messages.LOST_EMOJI;
import static com.raymundo.ui.Messages.TIE_EMOJI;
import static com.raymundo.ui.Messages.WON_EMOJI;

public enum GameResult {
    DRAW(TIE_EMOJI),
    WON(WON_EMOJI),
    LOST(LOST_EMOJI);

    private final String emoji;

    GameResult(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }

}
