package response;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Jakob on 2016-02-18.
 * This is the http header for http responses. Currently we limit
 * the responses to status line, general headers and entity headers.
 */
public class HTTPHeader
{
    private String statusLine;
    private String generalHeaders;
    private String entityHeaders;

    public HTTPHeader(String status, boolean keep_alive_in, HTTPBody body)
    {
        statusLine = status + "\n";
        generalHeaders = setupGeneralHeader(keep_alive_in);
        entityHeaders = "Content-Type: " + body.getType().toString();
        entityHeaders += "\nContent-Length: " + body.noBytes() + "\n";
    }

    public byte[] toBytes() {return toString().getBytes();}

    public String toString() {return statusLine + generalHeaders + entityHeaders + "\n";}


    private String setupGeneralHeader(boolean keep_alive)
    {
        String out = "Date: " + getDate();
        out += "\nConnection: ";
        if (keep_alive) {out += "keep-alive\n";}
        else {out += "close\n";}
        return out;
    }

    public String getDate()
    {
        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
        return sdf.format(cal.getTime());
    }
}
