package com.wordgame.service;

import com.wordgame.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Stores all words and returns a random one. */
public class WordBank {
    private final List<Word> words = new ArrayList<>();
    private final Random random = new Random();

    public WordBank() {
        words.add(new Word("java", "A popular programming language"));
        words.add(new Word("class", "Blueprint of an object"));
        words.add(new Word("object", "Instance of a class"));
        words.add(new Word("inheritance", "Acquiring properties of a parent class"));
        words.add(new Word("interface", "Contains abstract methods, implemented by classes"));
        words.add(new Word("polymorphism", "One name, many forms"));
        words.add(new Word("encapsulation", "Wrapping data and methods together"));
        words.add(new Word("constructor", "Special method that initializes an object"));
        words.add(new Word("exception", "An unwanted event during program execution"));
        words.add(new Word("package", "Group of related classes"));
    }

    public Word getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}
