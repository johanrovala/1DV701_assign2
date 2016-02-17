import utilities.IOHelper;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by johanrovala on 15/02/16.
 */
public class GetReqThread extends Thread{

    Client client;
    byte[] buf = new byte[100];
    private HTTPRequest httpRequest;
    private IOHelper ioHelper;
    // datainputstream för att hämta get req?

    public GetReqThread(Socket s) throws IOException {
        client = new Client(s);
        ioHelper = new IOHelper();
    }

    @Override
    public void run() {

        try {
            dataInputStream.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String req = new String(buf);
        httpRequest = new HTTPRequest(req);
       // System.out.println(req);
        System.out.println("Method type " +httpRequest.getMethodType());
        System.out.println("Path " + httpRequest.getPath());
        System.out.println("Options " +httpRequest.getOptions());
        System.out.println(ioHelper.fileExist(httpRequest.getPath()));

       // File file = new File("src"+httpRequest.getPath());
       /* try {
            dataInputStream.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String req1 = new String(buf);
        httpRequest = new HTTPRequest(req1);
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
