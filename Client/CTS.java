package Client;

import Shared.Talker;

///CTS = "Connection to server"
public class CTS implements Runnable {
    Client client;
    Talker talker;

    public CTS(Client client) {
        this.client = client;
    }

    @Override
    public void run() {

    }
}
