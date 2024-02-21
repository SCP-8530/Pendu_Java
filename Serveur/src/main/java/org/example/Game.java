package org.example;

public class Game {
    private String hidden_word = "";

    public Game(String word) {
        //genere un mot cacher
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                hidden_word = hidden_word + "_";
            } else {
                hidden_word = hidden_word + " ";
            }
        }
    }
    
}
