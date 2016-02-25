package main_package;

import request.Request;
import request.RequestParser;
import request.RequestValidator;
import response.HTTPResponse;

import java.io.*;
import java.net.Socket;

/**
 * Created by johanrovala on 15/02/16.
 *
 * This class represents a client running on the server.
 * With each new client another instance of this class is created.
 */
public class Session extends Thread{

    Client client;
    boolean canViewPreCon;      //If this is set a user can view the five times page
    private RequestParser requestParser;

    public Session(Socket s, boolean preConMet) throws IOException
    {
        canViewPreCon = preConMet;
        client = new Client(s);
    }

    @Override
    public void run()
    {

        try { requestParser = new RequestParser(client.getInputFromSockStream());}
        catch (IOException e) {e.printStackTrace();}


        Request request = requestParser.getRequest();
        System.out.println("\n\nThe request object: \n" + request.toString() + "\n\n");

        RequestValidator requestValidator = new RequestValidator(request);
        HTTPResponse response;
        try
        {
            response = requestValidator.getResponse(canViewPreCon);
            client.sendResponseToClient(response);
        }
        catch (IOException e)
        {
            System.out.println("Probably browser try to access logo but");
        }

        try  {  client.close(); }
        catch (IOException e) {e.printStackTrace();}
    }
}
