package response;

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

    public HTTPResponse(String status, CONTENT_TYPE contentType, int contentLen, String messBody)
    {
        statusLine = "HTTP/1.1" + " " + status + "\n";
        generalHeaders = setupGeneralHeader();
        entityHeaders = "Content-Type: " + contentType.toString();
        entityHeaders += "\nContent-Length: " + contentLen;
        messageBod = "\n" + messBody; //First new line due to http response format
    }



    public String toString() {return statusLine + generalHeaders + entityHeaders + "\n" + messageBod;}

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
}
