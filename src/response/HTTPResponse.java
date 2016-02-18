package response;

import balle.Client;
import com.sun.deploy.util.SessionState;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Jakob on 2016-02-16.
 * A class creating HTTP responses for HTTP 1.1
 */
public abstract class HTTPResponse
{
    private String statusLine;
    private String generalHeaders;
    //Currently no response header
    private String entityHeaders;
    private String messageBod;

    public HTTPResponse(){

    }

    /**
     * Constructor of the type of response to be send
     * @param status
     * @param contentType
     * @param contentLen
    // * @param messBody
     */
    public HTTPResponse(String status, CONTENT_TYPE contentType, int contentLen)
    {
        statusLine = "HTTP/1.1" + " " + status + "\n";
        generalHeaders = setupGeneralHeader();
        entityHeaders = "Content-Type: " + contentType.toString();
        entityHeaders += "\nContent-Length: " + contentLen;
       // messageBod = "\n" + messBody; //First new line due to http response format
    }


    public String toString() {return statusLine + generalHeaders + entityHeaders;}

    private String setupGeneralHeader()
    {
        String out = "Date: " + getDate();
        out += "\nConnection: close\n";
        return out;
    }

    public String getDate()
    {
        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
        return sdf.format(cal.getTime());
    }

    public abstract void writeToClient(Client client);
}
