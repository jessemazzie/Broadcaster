package Server;

import java.util.Enumeration;
import java.util.Hashtable;

public class UserList extends Hashtable<String, User> {
    Enumeration<User> users; //What's the point of this?

    void store() {
        while(users.hasMoreElements()) {
            users.nextElement(); //TODO: Call store
        }
    }
}
