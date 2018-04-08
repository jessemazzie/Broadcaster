package Server;

import Shared.Talker;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

//CTC = "Connection to client"
public class CTC implements Runnable {
    Vector<String> userList;
    Vector<String> loggedInList;
    Talker talker;

    public CTC(Socket socket, Vector<String> userList, Vector<String> loggedInList) throws IOException {
        this.userList = userList;
        this.loggedInList = loggedInList;
        talker = new Talker(socket, ""); //TODO: Assign ID

        //Run thread here.
    }

    @Override
    public void run() {
        String cmd;
    }
}
