package Client;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    public static void main(String[] args) {
        new Client();
    }

    Client() {
        JPanel containerPanel;
        Container cp;
        cp = getContentPane();
        //TODO: Construct CTS
        containerPanel = new JPanel(new GridLayout(5, 10));



        cp.add(containerPanel);
        setupMainFrame();
    }


    void setupMainFrame() {
        Toolkit tk;
        Dimension d;

        tk = Toolkit.getDefaultToolkit();
        d = tk.getScreenSize();
        setSize(d.width/4, d.height/4);
        setLocation(d.width/4, d.height/4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Broadcast receiver.");

        setVisible(true);
    }
}
