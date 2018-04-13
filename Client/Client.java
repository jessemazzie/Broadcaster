package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Client();
    }

    Client() {
        DefaultListModel<String> messageList;
        JList messageJList;
        JPanel containerPanel;
        JPanel loginRegisterPanel;
        JTextField usernameField;
        JPasswordField passwordField;
        JButton registerButton;
        JButton loginButton;
        Container cp;

        cp = getContentPane();
        //TODO: Construct CTS

        usernameField = new JTextField();
        usernameField.setSize(25, 1);

        passwordField = new JPasswordField();
        passwordField.setSize(25, 1);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setActionCommand("LOGIN");

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        registerButton.setActionCommand("REGISTER");

        loginRegisterPanel = new JPanel(new GridLayout(3, 2, 3, 5));
        loginRegisterPanel.setVisible(true);

        loginRegisterPanel.add(new JLabel("Username: "));
        loginRegisterPanel.add(usernameField);

        loginRegisterPanel.add(new JLabel("Password: "));
        loginRegisterPanel.add(passwordField);

        loginRegisterPanel.add(loginButton);
        loginRegisterPanel.add(registerButton);


        messageList = new DefaultListModel<String>();
        messageJList = new JList(messageList);

        containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(messageJList, BorderLayout.CENTER);
        containerPanel.setVisible(false);
        for(int i = 0; i < 20; i++)
            messageList.addElement("Test");

        cp.add(loginRegisterPanel);
        //cp.add(containerPanel);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
