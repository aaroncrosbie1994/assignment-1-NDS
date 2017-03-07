import java.io.IOException;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 06/03/2017 ******************
 * Subject: ***********************
 *********************************/
public class MessageHandler{

    UDPClient client;

    MessageHandler(String username){
        client = new UDPClient(username);
    }

    public void passMessage(String message){
        try {
            sendMessage(message);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) throws IOException{
        client.sendMessage(message);
    }

}
