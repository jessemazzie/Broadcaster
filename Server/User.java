package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

public class User {
    String username;
    String password;
    Vector<String> friendsList;
    CTC serverConnection;

    User(DataInputStream dis) {

    }

    void store(DataOutputStream dos) throws IOException {
        dos.writeChars(username);
        dos.writeChars(password);
    }
}
