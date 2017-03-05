import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 17/02/2017 ******************
 * Subject: ***********************
 *********************************/

class UDPServer
{
    public static void main(String [] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(80);
        Scanner input = new Scanner(System.in);

        while (true) {
            byte[] buffer = new byte[10];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            datagramSocket.receive(packet);

            System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));

            System.out.print("Server message: ");
            String message = input.nextLine();
            System.out.println(message);

            byte[] bufferN = message.getBytes();
            InetAddress receiverAddress = InetAddress.getLocalHost();

            DatagramPacket packet1 = new DatagramPacket(
                    bufferN, bufferN.length, receiverAddress, 70);

            datagramSocket.send(packet1);
        }

    }
}
