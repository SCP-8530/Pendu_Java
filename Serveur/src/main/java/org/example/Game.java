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

    /**
     * Test un charactere voir si il est dans le mot et modifie le mot cacher si c'est necessaire
     * */
    public void Test_Char(String character, String real_word) {
        boolean caractere_modif = false;

        //parcourrir le mot cacher
        for (int i = 0; i < real_word.length(); i++) {
            //test le caractere avec celui du mot
            if (real_word.charAt(i) == character.charAt(0)) {
                //dire que tu a detecter des charactere similaires
                caractere_modif = true;

                //modifier le mot cacher
                hidden_word = modifier_char(hidden_word, character, i);
            }
        }
    }

    /**
     * Changer un charactere specifique
     * */
    public String modifier_char(String hidden_word, String new_char, int index) {
        String new_hidden_word = "";

        //boucle de generation du nouveau mot
        for (int i = 0; i < hidden_word.length(); i++) {
            //changer le caractere demander
            if (i == index) {
                new_hidden_word = new_hidden_word + new_char;
            } else { //ne pas changer le caratere
                new_hidden_word = new_hidden_word + hidden_word.charAt(i);
            }
        }

        //retour
        return new_hidden_word;
    }
}
