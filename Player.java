package com.wordgame.model;

/** Abstract base class for all players. */
public abstract class Player {
    protected String name;
    protected int totalScore;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
    }

    public abstract String getTitle();

    public void addScore(int points) { totalScore += points; }
    public String getName()          { return name; }
    public int getTotalScore()       { return totalScore; }
}
