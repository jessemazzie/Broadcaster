package Server;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class UserList extends Hashtable<String, User> {
    Enumeration<User> users; //What's the point of this?

    public UserList(DataInputStream dis) {

    }

    void store() throws IOException {
        File file = new File("users.xyz");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream((file)));

        dos.writeInt(size());
        while(users.hasMoreElements())
            users.nextElement().store(dos);
    }
}
