package com.teddy.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GuessGame {

    private final ArrayList<Character> secretWord = new ArrayList<>();
    private int lifePoints;
    private final ArrayList<Character> guessWord = new ArrayList<>();
    private final Set<Character> proposedLetters = new HashSet<>();

    public GuessGame(String wordToGuess, int lifePoints) {
        this.lifePoints = lifePoints;

        for (char c : wordToGuess.toCharArray()) {
            this.secretWord.add(c);
        }

        for (int i = 0; i < this.secretWord.size(); i++) {
            this.guessWord.add('_');
        }
    }

    @Override
    public String toString() {
        return  "Mot à deviner: " + guessWord +
                "| Points de vie: " + lifePoints +
                "| Lettres proposées: " + proposedLetters;

    }

    public void guessLetter(char letter) {
        proposedLetters.add(letter);
        if (secretWord.contains(letter) && !guessWord.contains(letter)) {
            int index = 0;
            for (char c : secretWord) {
                if (c == letter) {
                    guessWord.set(index, letter);
                }
                index++;
            }
        } else {
            lifePoints--;
        }
    }

    public boolean isLost() {
        return lifePoints <= 0;
    }

    public boolean isWon() {
        return !guessWord.contains('_');
    }
}
