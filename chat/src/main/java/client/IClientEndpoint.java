package client;

import java.io.IOException;

interface IClientEndpoint {
    public int getPort();
    public String getHost();

    public void onOpen() throws IOException;
    public void onClose() throws IOException;
    public void onMessage() throws IOException;
    public void onError(Throwable throwable);
}
