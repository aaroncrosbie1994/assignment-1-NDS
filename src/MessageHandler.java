import java.io.IOException;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 06/03/2017 ******************
 * Subject: ***********************
 *********************************/
public class MessageHandler extends Frame{

    UDPClient client;

    MessageHandler(String username){
        client = new UDPClient(username);
    }

    public void sendMessage(String message) throws IOException{
        client.sendMessage(message);
    }

}
