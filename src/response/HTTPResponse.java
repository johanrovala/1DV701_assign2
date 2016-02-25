package response;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Jakob on 2016-02-18.
 * Abstract super class for all HTTP responses. Very simple in structure,
 * simply consists of an http header and an http body.
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

    /**
     * The method that's mainly used. It returns a two dimensional byte array
     * with the first byte array containing the header and the second the body.
     * @return two dimensional byte array containing header and body.
     */
    public byte[][] getBytes()
    {
        byte[][] out = {header.toBytes(), body.getBody()};
        return out;
    }
}
