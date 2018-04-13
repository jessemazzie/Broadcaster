package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

public class User {
    String username;
    String password;
    CTC ctc;
    Vector<String> friendsList;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    User(DataInputStream dis) throws IOException {
        this.username = dis.readUTF();
        this.password = dis.readUTF();
    }

    void broadcastTo(String messageToBroadcast) {
//        serverConnection.
    }

    void store(DataOutputStream dos) throws IOException {
        dos.writeUTF(username);
        dos.writeUTF(password);
    }
}
