import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 28/02/2017 ******************
 * Subject: ***********************
 *********************************/

public class Frame extends JFrame implements ActionListener{


    JPanel panel = new JPanel();
    JPanel messagePanel = new JPanel();
    JPanel userPanel = new JPanel();

    JLabel inputLabel = new JLabel();
    JLabel userText = new JLabel();
    JTextArea inputArea = new JTextArea();
    JTextArea displayArea = new JTextArea();

    JButton submit = new JButton("Submit");
    JButton enter = new JButton("Enter");

    Frame(){

        panel.add(new JLabel("Welcome please enter your username"));

        String username = inputArea.getText();

        UDPClient client = new UDPClient();
        client.setClient(username);

        String message = inputArea.getText();
        client.getMessage(message);

        panel.add(displayArea);
        panel.add(inputArea);
        add(panel);
        add(messagePanel);
        add(userPanel);

        panel.setVisible(true);

        messagePanel.setVisible(false);
        userPanel.setVisible(false);
        setSize(400, 400);
        setLocation(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//
//        if(e.getAction=="Submit"){
//            userText.setText(username);
//        }

    }

    public void setRecievedMessage(String message){
        String temp = displayArea.getText();
        temp = temp + message;
        displayArea.setText(temp);
    }
}
