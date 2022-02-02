package com.raymundo.service.impl;

import com.raymundo.domain.GameResult;
import com.raymundo.domain.PlayerOption;
import com.raymundo.service.GameService;

import java.util.concurrent.ThreadLocalRandom;

import static com.raymundo.domain.GameResult.DRAW;
import static com.raymundo.domain.GameResult.LOST;
import static com.raymundo.domain.GameResult.WON;

public class BasicGameService implements GameService {

    @Override
    public GameResult getGameResult(PlayerOption playerOneOption, PlayerOption playerTwoOption) {
        if (playerOneOption.getValue() == playerTwoOption.getValue()) {
            return DRAW;
        }

        if (Math.floorMod(playerOneOption.getValue() - playerTwoOption.getValue(), 3) == 1) {
            return WON;
        } else {
            return LOST;
        }
    }

    @Override
    public PlayerOption getComputerOption() {
        int randomOption = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        return PlayerOption.fromInteger(randomOption);
    }
}
