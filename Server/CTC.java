package Server;

import Shared.Talker;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

//CTC = "Connection to client"
public class CTC implements Runnable {
    Server server;
    Talker talker;

    public CTC(Socket socket, Server server) throws IOException {
        this.server = server;
        talker = new Talker(socket, "Server"); //TODO: Assign ID
        new Thread(this).start();
    }

    @Override
    public void run() {
        String cmd;
        String[] commandParts;
        User user;
        while(true) {
            try {
                cmd = talker.receive();

                if(cmd.startsWith("REGISTER")) {
                    commandParts = cmd.split(" ");
                    if (commandParts.length != 3)
                        System.out.println("Invalid number of parameters passed. Registration failed.");
                    else {
                        user = new User(commandParts[1], commandParts[2]);
                        user.ctc = this;
                        server.addUser(user);
                    }
                } else if(cmd.startsWith("LOGIN")) {
                    commandParts = cmd.split(" ");
                    if (commandParts.length != 3)
                        System.out.println("Invalid number of parameters passed. Login failed.");
                    else {
                        user = server.getUser(commandParts[1]);//new User(commandParts[1], commandParts[2]);
                        if(user == null)
                            System.out.println("BAD_USERNAME");
                        else if(user.password != commandParts[2])
                            System.out.println("BAD_PASSWORD");
                        else
                            System.out.println("LOGGED_IN");

                        user.ctc = this;
                        server.logUserIn(user);
                    }
                } else if(cmd.startsWith("BROADCAST")) {
                    server.broadcast(cmd.substring(9));
                }
            } catch (IOException ioe) {}
        }
    }
}
