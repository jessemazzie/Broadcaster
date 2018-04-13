package Server;

import Shared.Talker;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

//CTC = "Connection to client"
public class CTC implements Runnable {
    UserList userList;
    Server server;
    Vector<User> loggedInList;
    Talker talker;

    public CTC(Socket socket, Server server) throws IOException {
//        this.userList = userList;
//        this.loggedInList = loggedInList;
        this.server = server;
        talker = new Talker(socket, ""); //TODO: Assign ID

        //Run thread here.
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
                        userList.addUser(user);
                    }
                } else if(cmd.startsWith("LOGIN")) {
                    commandParts = cmd.split(" ");
                    if (commandParts.length != 3)
                        System.out.println("Invalid number of parameters passed. Login failed.");
                    else {
                        user = new User(commandParts[1], commandParts[2]);
                        user.ctc = this;
                        userList.addUser(user);
                    }
                } else if(cmd.startsWith("BROADCAST")) {
                    server.broadcast(cmd.substring(9));
                }
            } catch (IOException ioe) {}
        }
    }
}
