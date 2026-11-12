package com.wordgame.service;

/** Contract for score calculation. */
public interface Scoring {
    int calculateScore(int attemptsLeft, int wordLength);
}
