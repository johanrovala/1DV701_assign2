package balle;

import request.Request;
import request.RequestParser;
import request.RequestValidator;
import response.HTTPResponse;

import java.io.*;
import java.net.Socket;

/**
 * Created by johanrovala on 15/02/16.
 */
public class Session extends Thread{

    Client client;
    private RequestParser requestParser;

    public Session(Socket s) throws IOException
    {
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
            response = requestValidator.getResponse();
            client.sendResponseToClient(response);
        }
        catch (IOException e)
        {
            System.out.println("Probably browser try to access logo but");
        }

        try  {  client.close();}
        catch (IOException e) {e.printStackTrace();}
    }
}
