package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pendu_Visual {
    private ArrayList<String> list = new ArrayList<String>();

    public Pendu_Visual() {
        //0 vie
        list.add("    ============\n" +
                "    || //    |\n" +
                "    ||//     |\n" +
                "    ||/      |\n" +
                "    ||       O\n" +
                "    ||      /|\\\n" +
                "    ||       |\n" +
                "    ||      / \\\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");

        //1 vie
        list.add("    ============\n" +
                "    || //    |\n" +
                "    ||//     |\n" +
                "    ||/      |\n" +
                "    ||       O\n" +
                "    ||      /|\\\n" +
                "    ||       |\n" +
                "    ||      / \n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");

        //2 vie
        list.add("    ============\n" +
                "    || //    |\n" +
                "    ||//     |\n" +
                "    ||/      |\n" +
                "    ||       O\n" +
                "    ||      /|\\\n" +
                "    ||       |\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");

        //3 vie
        list.add("    ============\n" +
                "    || //    |\n" +
                "    ||//     |\n" +
                "    ||/      |\n" +
                "    ||       O\n" +
                "    ||      /|\n" +
                "    ||       |\n" +
                "    ||\\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");

        //4 vie
        list.add("    ============\n" +
                "    || //    |\n" +
                "    ||//     |\n" +
                "    ||/      |\n" +
                "    ||       O\n" +
                "    ||       |\n" +
                "    ||       |\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");

        //5 vie
        list.add("    ============\n" +
                "    || //    |\n" +
                "    ||//     |\n" +
                "    ||/      |\n" +
                "    ||       O\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");
        //6 vie
        list.add("    ============\n" +
                "    || //\n" +
                "    ||//\n" +
                "    ||/\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n" +
                "    ||\n==========");
    }

    /**
     * Recupere l'affichage correspondant a la vie du joueur
     * */
    public String Affiche(int vie) {
        return list.get(vie);
    }
}
