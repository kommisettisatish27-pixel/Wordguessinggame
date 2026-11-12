package com.wordgame.service;

import com.wordgame.exception.InvalidGuessException;
import com.wordgame.model.Word;

import java.util.HashSet;
import java.util.Set;

/** Logic of a single round of the game. */
public class GameRound implements Scoring {
    private static final int MAX_ATTEMPTS = 6;

    private final Word word;
    private final char[] display;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int attemptsLeft = MAX_ATTEMPTS;

    public GameRound(Word word) {
        this.word = word;
        this.display = new char[word.length()];
        for (int i = 0; i < display.length; i++) {
            display[i] = '_';
        }
    }

    /** Validates the input and applies the guess. */
    public void processGuess(String input) throws InvalidGuessException {
        input = input.trim().toLowerCase();

        if (input.isEmpty()) {
            throw new InvalidGuessException("Input cannot be empty.");
        }
        if (!input.matches("[a-z]+")) {
            throw new InvalidGuessException("Use alphabets only.");
        }

        if (input.length() == 1) {
            guessLetter(input.charAt(0));
        } else if (input.length() == word.length()) {
            guessWholeWord(input);
        } else {
            throw new InvalidGuessException(
                "Enter one letter or the full word (" + word.length() + " letters).");
        }
    }

    private void guessLetter(char ch) throws InvalidGuessException {
        if (guessedLetters.contains(ch)) {
            throw new InvalidGuessException("You already tried '" + ch + "'.");
        }
        guessedLetters.add(ch);

        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.getText().charAt(i) == ch) {
                display[i] = ch;
                found = true;
            }
        }

        if (found) {
            System.out.println("Good guess!");
        } else {
            attemptsLeft--;
            System.out.println("Wrong guess!");
        }
    }

    private void guessWholeWord(String guess) {
        if (guess.equals(word.getText())) {
            for (int i = 0; i < display.length; i++) {
                display[i] = word.getText().charAt(i);
            }
        } else {
            attemptsLeft--;
            System.out.println("That is not the word!");
        }
    }

    public boolean isWon()  { return new String(display).equals(word.getText()); }
    public boolean isLost() { return attemptsLeft <= 0; }
    public boolean isOver() { return isWon() || isLost(); }

    public void showStatus() {
        StringBuilder sb = new StringBuilder();
        for (char c : display) {
            sb.append(c).append(' ');
        }
        System.out.println("\nWord     : " + sb.toString().trim());
        System.out.println("Hint     : " + word.getHint());
        System.out.println("Tried    : " + guessedLetters);
        System.out.println("Attempts : " + attemptsLeft);
    }

    public Word getWord()        { return word; }
    public int getAttemptsLeft() { return attemptsLeft; }

    @Override
    public int calculateScore(int attemptsLeft, int wordLength) {
        return (attemptsLeft * 10) + wordLength;
    }
}
