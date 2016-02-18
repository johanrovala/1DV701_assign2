package response;

import balle.Client;

import java.io.File;

/**
 * Created by johanrovala on 17/02/16.
 */
public class Response200 extends HTTPResponse{

    private File file;


    public Response200(File file){
        this.file = file;
    }



    public void writeToClient(Client client) {
        String fileName = file.getName();
        //String parts[] = fileName.split("\\.");
        //ContentType type = ContentType.getFromFileEnding(parts[parts.length-1]);
        String response = ("HTTP/1.1 200 OK\r\n");

       // response += writeContentLengthAndEndHeadxer(file.length(), type, doContinue);
      //  client.writeHeader(response);
        client.writeFile(file);

      //  watcher.clientGotFile(file, clientThread);
    }
}
