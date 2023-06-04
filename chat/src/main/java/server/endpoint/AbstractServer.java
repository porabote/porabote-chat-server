package server.endpoint;

import files.Files;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import messages.MessagesBroker;

public abstract class AbstractServer implements IServerEndpoint {
    private int port;
    private String host;
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public int getPort() {
        return this.port;
    }

    public String getHost() {
        return this.host;
    }

    public void connnect() throws IOException {

        initConfig();

        System.out.println("Server started");
        //Scanner scanner = new Scanner(System.in);

        MessagesBroker mq = new MessagesBroker();

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = server.accept();
                     BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
                ) {

                   // out.write("Hello client! Write your name : \n");
                   // out.flush();
                    String message = socketIn.readLine();

                    //System.out.println(message);
                    mq.broadcast("{}");
                    //out.write();

                    out.flush();

                }
            }

        }

    }

    private void initConfig() {
        String content = Files.read(System.getProperty("user.dir") + "/app/configs/configs.json");

        JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
        this.port = jsonObject.getAsJsonObject("chat").get("port").getAsInt();
        this.host = jsonObject.getAsJsonObject("chat").get("host").getAsString();

    }

    public void onClose()  throws IOException {
        System.out.println(this.port);
    }

    public void onMessage()  throws IOException {
        System.out.println(this.port);
    }

    public void onError(Throwable throwable) {
        System.out.println(this.port);
    }

}
