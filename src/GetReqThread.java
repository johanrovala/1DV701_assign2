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

    Socket client;
    PrintWriter outPut;
    DataInputStream dataInputStream;
    byte[] buf = new byte[100];
    CharSequence cs1 = "GET";
    private String methodRequest;
    private HTTPRequest httpRequest;
    private IOHelper ioHelper;
    // datainputstream för att hämta get req?

    public GetReqThread(Socket s) throws IOException {
        client = s;
        outPut = new PrintWriter(client.getOutputStream());
        dataInputStream = new DataInputStream(client.getInputStream());
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


    public String readFile(String path, Charset encoding) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        return new String(content, encoding);
    }
}
