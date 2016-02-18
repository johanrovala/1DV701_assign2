package response;


import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Steve on 2016-02-18.
 */
public abstract class HTTPResponse
{
    private HTTPHeader header;
    private HTTPBody body;

    public HTTPResponse(String status, CONTENT_TYPE contentType, String messBody, boolean keep_alive) throws IOException
    {
        body = new HTTPBody(messBody, contentType);
        header = new HTTPHeader(status, keep_alive, body);
    }

    public HTTPResponse(String status, CONTENT_TYPE contentType, Path pathToFile, boolean keep_alive) throws IOException
    {
        body = new HTTPBody(pathToFile, contentType);
        header = new HTTPHeader(status, keep_alive, body);
    }

    public String toString()
    {
        String out = header.toString();
        out += body.toString();
        return out;
    }
}
