package Client;

import Shared.Talker;

import java.io.IOException;
import java.net.Socket;

///CTS = "Connection to server"
public class CTS implements Runnable {
    Client client;
    Talker talker;
    MessageBox messageBox;

    public CTS(Client client) throws IOException {

        this.client = client;
        talker = new Talker("127.0.0.1", 1337, "");

        new Thread(this).start();
    }

    void send(String stringToSend) throws IOException {
        talker.send(stringToSend);
    }

    @Override
    public void run() {
        String msg;
        try {
            while (true) {
                msg = talker.receive();

                if(msg.equals("LOGGED_IN")) {
                    client.setVisible(false);
                    new MessageBox(this);
                } else if(msg.equals("BROADCAST") && messageBox != null) {
                    messageBox.addMessage(msg.substring(9));
                }
            }
        } catch(IOException ioe) {

        }
    }
}
