import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************
 * Created by Gelmis S. Bartulis ** 
 * Date: 28/02/2017 ******************
 * Subject: ***********************
 *********************************/
public class Frame implements ActionListener{


    Frame(){
        JFrame frame = new JFrame();
        JLabel inputLabel = new JLabel();
        JLabel messageText = new JLabel();
        JTextArea inputArea = new JTextArea();
        JPanel panel = new JPanel(new GridLayout());

        panel.add(new JLabel("Welcome please enter a new message"));




        String message = inputArea.getText();
        messageText.setText(message);

        panel.add(inputArea);
        panel.add(messageText);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocation(400, 150);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
