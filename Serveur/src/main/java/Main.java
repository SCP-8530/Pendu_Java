import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        ServerSocket serverSocket;
        Socket clientSocket;
        InetAddress inetAddress = InetAddress.getByName("224.214.26.78");
        int port = 1234;


        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            //lire le port
            serverSocket = new ServerSocket(8080);

            //connexion
            clientSocket = serverSocket.accept();
            System.out.printf("DEBUG: Connexion d'un client: %s\n", clientSocket.getInetAddress().getHostAddress());

            //Flux entre et sorti
            PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //message de bienvenue
            socketOut.println("Bienvenue sur le pendu des noms des personnage de Genshin Impact.");

            //commencer une parti?
            while (true) {
                socketOut.println("Voulez vous jouez une parti? [Y or N]");
                socketOut.println("INPUT");
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

                        //affiche les charateres tester sauf si il y a aucun character tester
                        if (!list_char_tester.isEmpty()) {
                            socketOut.println(penduVisual.Lettre_test(list_char_tester));
                        }

                        //demande un caracter
                        while (true) {
                            socketOut.println("Qu'elle lettre voulez vous essayer? ");
                            socketOut.println("INPUT");
                            String character_choice = socketIn.readLine();
                            System.out.println("DEBUG: Charactere recu: " + character_choice);

                            //validiter
                            if (list_char_tester.contains(character_choice)) {
                                socketOut.println("Vous avez deja essayer cette lettre :)");
                            } else if (character_choice.matches("^[a-z]{1}|[A-Z]{1}$")) {
                                //mettre la lettre en minuscule
                                character_choice = character_choice.toLowerCase();

                                //ajout du character dans les tentatives
                                list_char_tester.add(character_choice);

                                //test du charactere
                                if(!game.Test_Char(character_choice,word.getMots_choisie())) {
                                    Life--; //Le caractere est faut donc on retire une vie
                                }

                                //finir la boucle car on a eu un caractere valide a tester
                                break;
                            } else {
                                socketOut.println("Vous ne pouvez mettre qu'une seul lettre et pas un caractere special.");
                            }
                        }

                        //Voir si le jeu est terminer
                        if (Life == 0) { //Parti perdu
                            socketOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            socketOut.println(penduVisual.Affiche(0));
                            socketOut.println("Malheureusement vous avez perdu. Le mot etait :" + word.getMots_choisie());

                            break;
                        }
                        if (Objects.equals(word.getMots_choisie(), game.getHidden_word())) { //Parti gagner
                            socketOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            socketOut.println("Vous avez bien deviner que le mot etait: " + word.getMots_choisie());

                            break;
                        }

                        //afficher le mot actuelle
                        socketOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nMot : " + game.getHidden_word());

                    }
                }
                //fermer le client et le serveur
                else if (choice.matches("^N|n|No|no|Non|non|NEIN_NEIN_NEIN_NEIN$")) {
                    socketOut.println("END");
                    break;
                }
                //recommencer la boucle
                else {
                    socketOut.println("Reponse non valide. ");
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