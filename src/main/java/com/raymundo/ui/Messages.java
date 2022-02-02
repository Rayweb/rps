package com.raymundo.ui;

public final class Messages {

    public static final int DEFAULT_ROUNDS = 5;

    public static final String SMILING_EMOJI = "\uD83D\uDE00";
    public static final String ROCK_EMOJI = "\uD83E\uDD1C";
    public static final String SCISSORS_EMOJI = "✌️️";
    public static final String PAPER_EMOJI = "\uD83D\uDD90️️";
    public static final String WON_EMOJI = "✅️️";
    public static final String LOST_EMOJI = "⛔";
    public static final String TIE_EMOJI = "⚠️";

    public static final String DEFAULT_ROUNDS_MESSAGE = "I think %s is a bit too much, let's play %s rounds and see who wins.";
    public static final String SELECT_ROUNDS = "Enter the number of rounds to play :";
    public static final String WELCOME_MESSAGE = "Lets play Rock " + ROCK_EMOJI +
            ",Paper " + PAPER_EMOJI +
            " Scissors " + SCISSORS_EMOJI + "!";
    public static final String SELECT_OPTION = "Select  : \n" +
            " 0 for rock " + ROCK_EMOJI + "\n" +
            " 1 for paper " + PAPER_EMOJI + " \n" +
            " 2 for scissors" + SCISSORS_EMOJI + " \n" +
            " or type q to quit";
    public static final String ROUNDS_TO_PLAY_MESSAGE = "OK, we are playing %d rounds " + SMILING_EMOJI;
    public static final String PLAYER_SELECTION = "You selected : %s";
    public static final String COMPUTER_SELECTION = "I selected : %s";
    public static final String ROUNDS_LEFT = "We have (%s) Rounds left!";
    public static final String GOODBYE_MESSAGE = "Thanks for playing!";
    public static final String DRAW_MESSAGE = "Result : We both picked %s. It's a draw! %s";
    public static final String WON_MESSAGE = "Result : %s beats %s. You won %s";
    public static final String LOST_MESSAGE = "Result : %s beats %s. You lost %s";
    public static final String INVALID_ROUNDS = "That's an invalid number, so we are playing the default number of rounds %d";
    public static final String TOTALS = "Total games played %d,  You won %d and lost %d and tied %d";

    private Messages() {
    }

}
