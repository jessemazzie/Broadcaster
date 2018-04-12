package Server;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class UserList extends Hashtable<String, User> {
    Enumeration<User> users; //What's the point of this?

    public UserList(DataInputStream dis) throws IOException {
        int numUsers = dis.readInt();

        for(int i = 0; i < numUsers; i++) {
            User tempUser = new User(dis);
            put(tempUser.username, tempUser);
        }
    }

    public void addUser(User user) {
        put(user.username, user);
        try {
            store();
        } catch(IOException ioe) {}
    }

    void store() throws IOException {
        File file = new File("users.xyz");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream((file)));

        dos.writeInt(size());
        while(users.hasMoreElements())
            users.nextElement().store(dos);
    }
}
