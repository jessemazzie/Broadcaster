package Server;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends JFrame {
    final int portNumber = 1337;
    ServerSocket serverSocket;
    private UserList users;
    private Vector<User> loggedInUsers;

    Server() {
        try {
            serverSocket = new ServerSocket(portNumber);

            startAcceptingConnections();
        } catch (IOException e) {
            System.out.println("Server unable to start. Check if port " + portNumber + " is in use.");
        }
    }

    void startAcceptingConnections() {
        Socket tempSocket;

        try {
            tempSocket = serverSocket.accept();

            new CTC(tempSocket, users, loggedInUsers);

        } catch (IOException e) {}
    }
}
