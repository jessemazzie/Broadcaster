package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MessageBox extends JFrame implements ActionListener {
    CTS cts;
    JTextField textField;
    DefaultListModel<String> messageList;

    MessageBox(CTS cts) {
        Container cp;

        JList messageJList;
        JScrollPane mainScrollPane;
        JPanel textFieldContainer;
        JButton sendBroadcastButton;

        this.cts = cts;
        cp = getContentPane();

        sendBroadcastButton = new JButton("Broadcast");
        sendBroadcastButton.setActionCommand("BROADCAST");
        sendBroadcastButton.addActionListener(this);

        messageList = new DefaultListModel<String>();
        messageJList = new JList(messageList);
        mainScrollPane = new JScrollPane(messageJList);
        textField = new JTextField();

        textFieldContainer = new JPanel(new BorderLayout());
        textFieldContainer.add(textField, BorderLayout.WEST);
        textFieldContainer.add(sendBroadcastButton, BorderLayout.EAST);

        cp.add(mainScrollPane, BorderLayout.NORTH);
        cp.add(textFieldContainer, BorderLayout.SOUTH);
        setupMainFrame();
    }

    public void addMessage(String newMessage) {
        messageList.addElement(newMessage);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();

        if(ae.getActionCommand().equals("BROADCAST")) {
            try {
                cts.send("BROADCAST " + textField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
