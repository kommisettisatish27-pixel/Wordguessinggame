package com.wordgame.exception;

/** Thrown when the player enters an invalid guess. */
public class InvalidGuessException extends Exception {
    public InvalidGuessException(String message) {
        super(message);
    }
}
