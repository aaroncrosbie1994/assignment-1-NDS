import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 28/02/2017 ******************
 * Subject: ***********************
 *********************************/
public class Frame implements ActionListener{


    Frame(){
        //Initializing the frame
        JFrame frame = new JFrame();

        //Getting and Setting the username
        JTextArea getUsername = new JTextArea(1, 30);
        JLabel username = new JLabel(getUsername.getText());

        //Initial message centre
        JTextArea inputArea = new JTextArea(40, 40);

        //Main Panel
        JPanel mainPanel = new JPanel(new GridLayout());

        //Submit button to send message
        JButton submit = new JButton("Submit");

        //Or just press "Enter"
        KeyStroke.getKeyStroke("Enter");

        //Calling client class
        ClientService clientService = new ClientService("", 80, "");

        //Welcome message
        mainPanel.add(new JLabel("Welcome please enter a new message"));

        //Input message from text area
        String message = inputArea.getText();
//        messageText.setText(message);

        mainPanel.add(inputArea);
        frame.add(mainPanel);
        frame.setSize(400, 400);
        frame.setLocation(400, 150);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // When client presses the button submit or enter
        // the message is sent to ChatHandler or ClientService class
        // then dispaed for all users using client
    }
}
