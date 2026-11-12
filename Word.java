package com.wordgame.model;

/** A secret word together with its hint. */
public class Word {
    private final String text;
    private final String hint;

    public Word(String text, String hint) {
        this.text = text.toLowerCase();
        this.hint = hint;
    }

    public String getText() { return text; }
    public String getHint() { return hint; }
    public int length()     { return text.length(); }
}
