import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 17/02/2017 ******************
 * Subject: ***********************
 *********************************/

class UDPServer extends Thread
{
//    public static void main(String [] args) throws IOException {
//
//        DatagramSocket datagramSocket = new DatagramSocket(80);
//
//        while (true) {
//            byte[] buffer = new byte[255];
//            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//            datagramSocket.receive(packet);
//
//            String message = new String(packet.getData(), packet.getOffset(), packet.getLength());
//
////            displayMessage(message);
//            byte[] bufferN = message.getBytes();
//            InetAddress receiverAddress = InetAddress.getLocalHost();
//
////            DatagramPacket packet1 = new DatagramPacket(
////                    bufferN, bufferN.length, receiverAddress, 70);
////
////            datagramSocket.send(packet1);
//        }
//    }
//
////    public static void displayMessage(String message){
////        MessageHandler msgH = new MessageHandler();
////        msgH.sendMessage(message);
////    }
    public static void main(String [] args) throws IOException{
        DatagramSocket dgs = new DatagramSocket(80);

        while(true){
            byte [] buffer = new byte[255];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            dgs.receive(packet);
            String message = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);

            sendToClients(message, dgs);
        }
    }

    public static void sendToClients(String message, DatagramSocket dgs) throws IOException{
        System.out.println(message);
        //System.out.println(client);
//        byte [] buffer = message.getBytes();
//        InetAddress recieverAdd = InetAddress.getLocalHost();
//        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, recieverAdd, 70);
//        dgs.send(packet);
    }
}
