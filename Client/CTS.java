package Client;

import Client.Client;

///CTS = "Connection to server"
public class CTS implements Runnable {
    Client client;

    public CTS(Client client) {
        this.client = client;
    }

    @Override
    public void run() {

    }
}
