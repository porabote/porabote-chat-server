package server.endpoint;

import java.io.IOException;

interface IServerEndpoint {
    public int getPort();
    public String getHost();

    public void onOpen() throws IOException;
    public void onClose() throws IOException;
    public void onMessage() throws IOException;
    public void onError(Throwable throwable);
}
