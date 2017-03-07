import java.io.*;
import java.net.*;
import java.util.*;

public class ServerService {

    private ArrayList<ClientThread> clients;
    private int port;
    private boolean chatLive;

    public ServerService(int port) {
        this.port = port;
    }

    class ClientThread extends Thread{
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream out;

        int id;
        String username;
        ChatHandler ch;

        ClientThread(Socket socket){
            this.socket = socket;

            try{
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());

                username = (String) in.readObject();
                System.out.println("User connected: " + username);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        public void displayMessage(String message){

            System.out.println(message);

            for(int i=0; i<clients.size(); i++) {
                clients.get(i);
                System.out.println(message);
            }
        }

        private boolean checkClient(String message){
            if(!socket.isConnected()){
                removeClient();
                return false;
            }
            try {
                out.writeObject(message);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        private void removeClient(){
            try{
                if(out != null){
                    out.close();
                }
            }
            catch(Exception e) {}
            try {
                if(in != null){
                    in.close();
                }
            }
            catch(Exception e) {};
            try {
                if(socket != null){
                    socket.close();
                }
            }
            catch (Exception e) {}
        }

        public void run(){
            chatLive = true;
            while(chatLive){
                try{
                    ch = (ChatHandler) in.readObject();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }

                String message = ch.getMessage();

            }
        }

    }
}

