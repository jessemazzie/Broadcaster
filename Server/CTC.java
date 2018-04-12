package Server;

import Shared.Talker;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

//CTC = "Connection to client"
public class CTC implements Runnable {
    UserList users;
    Vector<User> loggedInList;
    Talker talker;

    public CTC(Socket socket, UserList userList, Vector<User> loggedInList) throws IOException {
        this.userList = userList;
        this.loggedInList = loggedInList;
        talker = new Talker(socket, ""); //TODO: Assign ID

        //Run thread here.
    }

    @Override
    public void run() {
        String cmd;
        String[] commandParts;
        User user;

        try {
            cmd = talker.receive();

            if(cmd.startsWith("REGISTER")) {
                commandParts = cmd.split(" ");
                if(commandParts.length != 3)
                    System.out.println("Invalid number of parameters passed. Registration failed.");
                else {

                }
            }
        } catch (IOException ioe) { }
    }
}
