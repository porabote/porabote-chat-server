package client;

import java.io.IOException;

public class Client extends AbstractClient {

    private int userId;
    private String userName;

    public Client(int userId, String userName) throws IOException {
        this.userId = userId;
        this.userName = userName;

        this.connect();
    }

    public void onOpen() throws IOException {
        onOpen();
    }



}
