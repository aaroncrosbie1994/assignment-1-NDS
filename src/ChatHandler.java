import java.io.*;

public class ChatHandler {

    private String message;

    ChatHandler(String message){
        this.message = message;
    }

    String getMessage(){
        return this.message;
    }
}
