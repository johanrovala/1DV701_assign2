import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by johanrovala on 15/02/16.
 */
public class Server
{
    private static ServerSocket serverSocket;
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException
    {

        serverSocket = new ServerSocket(PORT);

        while (true)
        {
            Socket socket = serverSocket.accept();
            new GetReqThread(socket).start();
        }
    }
}
