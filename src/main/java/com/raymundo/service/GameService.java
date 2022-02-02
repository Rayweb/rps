package com.raymundo.service;

import com.raymundo.domain.GameResult;
import com.raymundo.domain.PlayerOption;

public interface GameService {

    GameResult getGameResult(PlayerOption playerOneOption, PlayerOption playerTwoOption);

    PlayerOption getComputerOption();
}
