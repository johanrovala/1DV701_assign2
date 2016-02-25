package response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jakob on 2016-02-18.
 * The body for an http response
 */
public class HTTPBody
{
    private byte[] body;
    private CONTENT_TYPE type;
    private String stringBody;

    /**
     * Constructor 1, used for hardcoded html responses mainly.
     * @param bodyIn the body of the response
     * @param typeIn the type of the content of the body
     */
    public HTTPBody(String bodyIn, CONTENT_TYPE typeIn)
    {
        stringBody = bodyIn;
        type = typeIn;
        body = bodyIn.getBytes();
    }

    /**
     * Constructor 2, used for arbitrary http response bodies. Takes
     * a path to a file and converts it into an byte array.
     * @param pathIn the path to the file
     * @param typeIn the content type of the file
     * @throws IOException
     */
    public HTTPBody(Path pathIn, CONTENT_TYPE typeIn) throws IOException
    {
        type = typeIn;
        body = Files.readAllBytes(pathIn);
    }

    public CONTENT_TYPE getType()
    {
        return type;
    }

    public int noBytes()
    {
        return body.length;
    }

    public String toString()
    {
        return stringBody;
    }

    public byte[] getBody()
    {
        return body;
    }
}
