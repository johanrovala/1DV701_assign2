import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

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
        outPut.println("HTTP/1.1 200 OK");
        outPut.println("Content-Type: text/html");
        outPut.println("\r\n");
        outPut.println("<p> Hello world </p>");
        outPut.flush();
    }
}
