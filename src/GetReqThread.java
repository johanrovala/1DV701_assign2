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

    public GetReqThread(Socket s) throws IOException {
        client = s;
        outPut = new PrintWriter(client.getOutputStream());
    }

    @Override
    public void run() {

        File file = new File("src/html/index.html");
        System.out.println("runs");
        outPut.println("HTTP/1.1 200 OK");
        outPut.println("Content-Type: text/html");
        outPut.println("\r\n");
        outPut.println("<p> Hello world </p>");
        
        try {
            outPut.println(readFile(file.getAbsolutePath(), Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        outPut.flush();
        outPut.close();

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
