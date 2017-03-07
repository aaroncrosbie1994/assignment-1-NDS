import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 28/02/2017 ******************
 * Subject: ***********************
 *********************************/

public class Frame extends JFrame implements ActionListener {


    JPanel backPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel messagePanel = new JPanel();
    JPanel userPanel = new JPanel();

    JLabel inputLabel = new JLabel();
    JLabel userText = new JLabel();
    JTextArea inputArea = new JTextArea();
    JTextArea displayArea = new JTextArea();
    JButton submit = new JButton("Submit");
    JButton enter = new JButton("Enter");

    MessageHandler msgh = new MessageHandler("aaron");

    Frame() {
        super("Facebook Messanger...");
        getContentPane().add(backPanel);
        backPanel.setLayout(new BorderLayout());
        backPanel.add("Center", mainPanel);
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.add(displayArea);
        mainPanel.add(inputArea);
        mainPanel.add(enter);

        enter.addActionListener(this);
//        setMessageHandler();
//        panel.add(new JLabel("Welcome please enter your username"));
//
//        String username = inputArea.getText();
//
//        msgh = new MessageHandler(username);
//
//        String message = inputArea.getText();
//        msgh.passMessage(message);
//
//        panel.add(displayArea);
//        panel.add(inputArea);
//        add(panel);
//        add(messagePanel);
//        add(userPanel);
//
//        panel.setVisible(true);
//
//        messagePanel.setVisible(false);
//        userPanel.setVisible(false);
        setSize(400, 400);
        setLocation(400, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == enter){
            String message = inputArea.getText();
            msgh.passMessage(message);
        }
//
//        if(e.getAction=="Submit"){
//            userText.setText(username);
//        }

    }

//    public void setRecievedMessage(String message){
//        String temp = displayArea.getText();
//        temp = temp + message;
//        displayArea.setText(temp);
//    }

//    private void setMessageHandler(){
//        msgh = new MessageHandler("aaron");
//    }

    public static void main(String [] args){
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
