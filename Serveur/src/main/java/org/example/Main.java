package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket clientSocket;

        try {
            //lire le port
            serverSocket = new ServerSocket(8080);

            //connexion
            clientSocket = serverSocket.accept();
            System.out.printf("DEBUG: Connexion d'un client: %s\n", clientSocket.getInetAddress().getHostAddress());

            //Flux entre et sorti
            PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //message de bienvenue
            socketOut.printf("Bienvenue sur le pendu des noms des personnage de Genshin Impact.\n");

            //commencer une parti?
            while (true) {
                socketOut.printf("Voulez vous jouez une parti? [Y or N]\n");
                String choice = socketIn.readLine();
                System.out.println("DEBUG: Choix de client: " + choice);

                //commencer une partir
                if (choice.matches("^Y|y|yes|Yes|Oui|oui$")) {
                    //Donner important a utiliser
                    Word word = new Word();
                    Game game = new Game(word.getMots_choisie());
                    Pendu_Visual penduVisual = new Pendu_Visual();
                    ArrayList<String> list_char_tester = new ArrayList<String>();
                    int Life = 6;

                    //debut game
                    socketOut.println("Voici le mot a deviner :" + game.getHidden_word());
                    while (true) {
                        //affiche le pendu celon la vie
                        socketOut.println(penduVisual.Affiche(Life));

                        //affiche les charateres tester
                        if (list_char_tester.size() > 0) {
                            socketOut.println(penduVisual.Lettre_test(list_char_tester));
                        }

                        //demande un caracter
                        while (true) {
                            socketOut.println("Qu'elle lettre voulez vous essayer? ");
                            String character_choice = socketIn.readLine();
                            System.out.println("DEBUG: Charactere recu: " + character_choice);

                            //validiter
                            if (list_char_tester.contains(character_choice)) {
                                socketOut.println("Vous avez deja essayer cette lettre :)");
                            } else if (character_choice.matches("^[a-z]{1}|[A-Z]{1}$")) {
                                //ajout du character dans les tentatives
                                list_char_tester.add(character_choice);

                                //test du charactere
                                if(game.Test_Char(character_choice,word.getMots_choisie())) {
                                    break;
                                } else { //character non valide = perte d'une vie
                                    Life--;
                                    break;
                                }

                            } else {
                                socketOut.println("Vous ne pouvez mettre qu'une seul lettre et pas un caractere special.");
                            }
                        }

                        //afficher le mot actuelle
                        socketOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nMot : " + game.getHidden_word());

                    }

                }
                //fermer le client et le serveur
                else if (choice.matches("^N|n|No|no|Non|non|NEIN_NEIN_NEIN_NEIN$")) {
                    break;
                }
                //recommencer la boucle
                else {
                    socketOut.printf("Reponse non valide. ");
                }
            }

            //fermer le serveur
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}