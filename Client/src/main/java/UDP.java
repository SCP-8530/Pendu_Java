import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP {
    public static void main(){
        int port = 1234;

        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            while (true) {
                // Créer une mémoire tampon où mettre le message reçu
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

                // Recevoir un maximum de 1024 octets
                datagramSocket.receive(datagramPacket);

                // Afficher le message
                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("Datagramme reçu : " + message);

                //fermer la boucle
                if (message.equals("END")) break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
