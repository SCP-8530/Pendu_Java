package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

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
                    socketOut.println("Debut de la partie");
                    socketOut.println("Fin de la partie");
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