package com.wordgame.model;

/** A real person playing the game. */
public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name.isEmpty() ? "Guest" : name);
    }

    @Override
    public String getTitle() {
        return "Player";
    }
}
