package com.raymundo;

import com.raymundo.games.Game;
import com.raymundo.games.impl.RSPGame;
import com.raymundo.service.impl.BasicGameService;
import com.raymundo.ui.Display;
import com.raymundo.ui.PrintStreamFactory;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Game game = new RSPGame(new BasicGameService(),
                new Display(PrintStreamFactory.getPrintStream()),
                new Scanner(System.in));
        game.start();
    }
}
