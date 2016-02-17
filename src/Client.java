import java.io.*;
import java.net.Socket;

/**
 * Created by johanrovala on 17/02/16.
 */
public class Client {

    private Socket client;
    private OutputStream clientOutPut;
    private byte[] buf;

    public Client(Socket socket){
        this.client = socket;
        buf = new byte[100];
    }

    public void close() throws IOException {
        this.client.close();
    }

    public String 

    public void write(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        clientOutPut = client.getOutputStream();

        while(fileInputStream.read(buf) != -1){
            clientOutPut.write(buf);
        }

        fileInputStream.close();
    }
}
