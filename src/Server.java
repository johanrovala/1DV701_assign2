import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by johanrovala on 15/02/16.
 */
public class Server {

    private static ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(8080);
    }

    public static void main(String[] args) throws IOException {
        while (true){
            serverSocket.accept();
            new GetReqThread();
        }
    }
}
