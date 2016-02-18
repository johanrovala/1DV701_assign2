package balle;

import java.io.*;
import java.net.Socket;

/**
 * Created by johanrovala on 17/02/16.
 */
public class Client {

    private Socket client;
    private OutputStream clientOutPut;
    PrintWriter printWriter;
    private byte[] buf;

    public Client(Socket socket) throws IOException {
        this.client = socket;
        clientOutPut = client.getOutputStream();
        this.printWriter = new PrintWriter(clientOutPut);
        buf = new byte[100];
    }

    public void close() throws IOException {
        this.client.close();
    }

    public String getRequestFromClient() throws IOException {
        InputStream inputStream = client.getInputStream();
        inputStream.read(buf);
        String request = new String(buf);
        return request;
    }

    public void writeHeader(HTTPResponse response) throws IOException {

    }

    public void writeFile(File file){

    }
}
