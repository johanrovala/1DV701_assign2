package main_package;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by johanrovala on 15/02/16.
 * Main class. Waits for a client to try to connect. If successfull start a new instance of Session
 *
 */
public class Server
{
    /* Following two variables serves for the purpose of the 415 response,
    * that is that a precondition hasn't been met, this precondition is only
    * available if 5 connections has been made to the http server*/
    private static int preconCounter = 0;
    private static boolean canViewPreConPage = false;

    private static ServerSocket serverSocket;
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException
    {

        serverSocket = new ServerSocket(PORT);
        System.out.println(serverSocket.getLocalSocketAddress());

        while (true)
        {
            if (preconCounter > 5)
            {
                canViewPreConPage = true;
            }
            Socket socket = serverSocket.accept();
            new Session(socket, canViewPreConPage).start();
            System.out.println("\nNEW CONNECTION\nHas made " + preconCounter + " connections.\n");
            preconCounter++;
        }
    }
}
