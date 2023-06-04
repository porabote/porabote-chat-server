package client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import files.Files;
import messages.MessagesBroker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public abstract class AbstractClient implements IClientEndpoint {
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

    public Socket connect() throws IOException {

        initConfig();
        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        ) {

//            String nameQuestion = socketIn.readLine();
//            System.out.println(nameQuestion);
//
//            String name = systemIn.readLine();
            socketOut.write("Enter to chat" + "\n");
            socketOut.flush();

            String ageQuestion = socketIn.readLine();
            System.out.println(ageQuestion);

            String age = systemIn.readLine();
            out.write(age + "\n");
            out.flush();

            String finalResponse = socketIn.readLine();
            System.out.println(finalResponse);


        } catch (IOException e) {
            e.printStackTrace();
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
