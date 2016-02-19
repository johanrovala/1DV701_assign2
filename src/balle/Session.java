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
    private RequestValidator requestValidator;
    private OutputStream outputStream;

    public Session(Socket s) throws IOException {
        client = new Client(s);
    }

    @Override
    public void run() {



        try {
            requestParser = new RequestParser();
            requestParser.setRequestLine(client.getRequestFromClient());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Method type " +requestParser.getMethodType());
        System.out.println("Path " + requestParser.getPath());
        System.out.println("Options " +requestParser.getOptions());

        Request request = requestParser.getRequest();

        RequestValidator requestValidator = new RequestValidator(request);
        HTTPResponse response;
        try {
            response = requestValidator.getResponse();
            client.sendResponseToClient(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
