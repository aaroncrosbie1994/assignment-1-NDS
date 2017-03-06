import java.util.*;

public class Users{

    private ArrayList<User> users = new ArrayList<User>();

    public void addUser(User user){
        users.add(user);
    }

    public String getDestination(String username) throws NullReturn{
        String ipAdd;
        for(int i=0; i<users.size(); i++){
            if(users.getUsername.equals(username)){
                ipAdd = users.getIpAddress();
            }
        }
        if(ipAdd == null){
            throw new NullReturn("ERROR 404 no IP Address found!");
            break;
        }
        return ipAdd;
    }
}