/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 17/02/2017 ******************
 * Subject: ***********************
 *********************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.DatagramSocket;
import java.util.Scanner;

class UDPClient
{
    static String message;

    public void main(String [] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(70);
        Frame frame = new Frame();
        while(true) {
            //Message input from Frame class by the client to be sent to the pool

            if(message != null) {
                byte[] buffer = message.getBytes();
                InetAddress receiverAddress = InetAddress.getLocalHost();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, 80);

                datagramSocket.send(packet);

                byte[] bufferN = new byte[255];
                DatagramPacket packet1 = new DatagramPacket(bufferN, bufferN.length);

                datagramSocket.receive(packet1);

                System.out.println(new String(packet1.getData(), packet1.getOffset(), packet1.getLength()));
            }
        }
    }

    public void setClient(String name){
        User user = new User(name);
    }

    public void getMessage(String message){
        this.message = message;
    }
}