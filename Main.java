package com.wordgame;

import com.wordgame.exception.InvalidGuessException;
import com.wordgame.model.HumanPlayer;
import com.wordgame.model.Player;
import com.wordgame.service.GameRound;
import com.wordgame.service.WordBank;

import java.util.Scanner;

/** Entry point of the Word Guessing Game. */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordBank bank = new WordBank();

        System.out.println("=================================");
        System.out.println("      WORD GUESSING GAME");
        System.out.println("=================================");
        System.out.print("Enter your name: ");
        Player player = new HumanPlayer(sc.nextLine().trim());
        System.out.println("Welcome, " + player.getName() + "! You have 6 attempts per word.");
        System.out.println("Guess one letter at a time, or the full word.");

        String again;
        do {
            GameRound round = new GameRound(bank.getRandomWord());

            while (!round.isOver()) {
                round.showStatus();
                System.out.print("Your guess: ");
                try {
                    round.processGuess(sc.nextLine());
                } catch (InvalidGuessException e) {
                    System.out.println("Invalid: " + e.getMessage());
                }
            }

            if (round.isWon()) {
                int points = round.calculateScore(round.getAttemptsLeft(),
                                                  round.getWord().length());
                player.addScore(points);
                System.out.println("\nCorrect! The word is '" + round.getWord().getText() + "'.");
                System.out.println("You earned " + points + " points.");
            } else {
                System.out.println("\nGame over! The word was '" + round.getWord().getText() + "'.");
            }

            System.out.println(player.getTitle() + " " + player.getName()
                    + " | Total score: " + player.getTotalScore());
            System.out.print("\nPlay again? (y/n): ");
            again = sc.nextLine().trim().toLowerCase();
        } while (again.equals("y"));

        System.out.println("\nThanks for playing, " + player.getName() + "!");
        System.out.println("Final score: " + player.getTotalScore());
        sc.close();
    }
}
