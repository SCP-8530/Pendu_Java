import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Boucle du client
        while (true) {
            System.out.println("Choisir qu'elle type de connexion utiliser : ");
            System.out.println("1. TCP");
            System.out.println("3. UDP");
            System.out.println("2. Fermer le logiciel");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (Objects.equals(input, "1")) {
                TCP.main();
            } else if (Objects.equals(input, "2")) {
                UDP.main();
            } else if (Objects.equals(input,"3")) {
                System.out.println("Fermeture du logiciel");
                break;
            } else {
                System.out.println("Message non valide");
            }
        }




    }
}