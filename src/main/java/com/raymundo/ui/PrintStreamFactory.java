package com.raymundo.ui;

import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamFactory {

    public static PrintStream getPrintStream() {
        return new PrintStream(System.out, true, UTF_8);
    }
}
