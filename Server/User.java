package Server;

import Client.CTC;

import java.util.Vector;

public class User {
    String username;
    String password;
    Vector<String> friendsList;
    CTC serverConnection;
}
