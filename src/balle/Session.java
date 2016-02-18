package balle;

import request.Request;
import request.RequestParser;
import request.RequestValidator;

import java.io.*;
import java.net.Socket;

/**
 * Created by johanrovala on 15/02/16.
 */
public class Session extends Thread{

    Client client;
    private RequestParser requestParser;
    private RequestValidator requestValidator;

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
        // System.out.println(req);

        System.out.println("Method type " +requestParser.getMethodType());
        System.out.println("Path " + requestParser.getPath());
        System.out.println("Options " +requestParser.getOptions());

        Request request = requestParser.getRequest();

        RequestValidator requestValidator = new RequestValidator(request);
        HTTPResponse response = requestValidator.getResponse();
        response.writeToClient(this.client);


        /*HTTPResponse httpResponse = new HTTPResponse("200 OK", CONTENT_TYPE.PNG, 20 ) {};
        try {
            client.write(httpResponse, httpRequest.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        // File file = new File("src"+httpRequest.getPath());
       /* try {
            dataInputStream.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String req1 = new String(buf);
        httpRequest = new request.RequestParser(req1);
        System.out.println("Path " + httpRequest.getPath());*/
       // File file = new File("src/main.html/index.main.html");
       // System.out.println("runs");



      //  outPut.println("HTTP/1.1 200 OK");
      //  outPut.println("Content-Type: text/main.html");
      //  outPut.println("\r\n");
      //  outPut.println("<p> Hello world </p>");
/*
        try {
            outPut.println(readFile(file.getAbsolutePath(), Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
       // outPut.flush();
       // outPut.close();

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
