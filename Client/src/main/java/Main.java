import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            //Creer une connexion
            Socket socket = new Socket("localhost", 8080);

            //Recuperer les flux
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Recuperer les messages
            while (true) {
                //recuperation du message du serveur
                String message = socketIn.readLine();

                //test pour savoir l'action a faire
                if (Objects.equals(message, "INPUT")) { //Envoyer une donner au serveur
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    socketOut.printf("%s\n",input);
                } else if (Objects.equals(message, "END")) { //Fermeture de serveur
                    break;
                } else { //Envoyer les message du serveur sur la console
                    System.out.println(message);
                }
            }

            //Fermer la connexion
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}