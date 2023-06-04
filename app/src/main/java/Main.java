import auth.Auth;
import client.Client;
import server.endpoint.Server;
import user.User;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        Server server = new Server();
//        server.run();

        User user = User.login();
        Client client = new Client(
                user.getId(),
                user.getName()
        );

    }

}
