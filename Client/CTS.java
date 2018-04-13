package Client;

import Shared.Talker;

import java.io.IOException;
import java.net.Socket;

///CTS = "Connection to server"
public class CTS implements Runnable {
    Client client;
    Talker talker;

    public CTS(Client client) throws IOException {

        this.client = client;
        talker = new Talker("127.0.0.1", 1337, "");

        new Thread(this).start();
    }

    @Override
    public void run() {
        String msg;
        try {
            while (true) {
                msg = talker.receive();
            }
        } catch(IOException ioe) {

        }
    }
}
