package balle;

import java.io.IOException;
import java.net.InetSocketAddress;
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
        System.out.println(serverSocket.getLocalSocketAddress());

        while (true)
        {
            Socket socket = serverSocket.accept();
            new Session(socket).start();
        }
    }
}
