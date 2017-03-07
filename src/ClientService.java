/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 17/02/2017 ******************
 * Subject: ***********************
 *********************************/
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientService {


    private String username;
    private String serverName;
    private int portNumber;

    public ObjectInputStream ois;
    public ObjectOutputStream oos;
    public Socket socket;

    Frame frame = new Frame();

    ClientService(String serverName, int portNumber, String username) {
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.username = username;
    }

    public void chatOpen() throws IOException {

        socket = new Socket(serverName, portNumber);
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
        new ThreadSafe().start();
        oos.writeObject(username);
    }

    public static void displayMessage(String text) {
        frame.showMessage(text);
    }

    public void sendMessage(ChatHandler message) {
        oos.writeObject(message);
    }


    public static void main(String[] args) throws IOException {

        int port = 80;
        ClientService newClient = new ClientService("", port, "");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(newClient.username + " ");
            String message = input.nextLine();
            displayMessage(message);
        }
    }
}
class ThreadSafe extends Thread
{
    public void run()
    {
        while(true)
        {
            String message = (String) ois.readObject();
            frame.showMessage(message);
        }
    }
}