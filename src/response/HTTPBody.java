package response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Steve on 2016-02-18.
 */
public class HTTPBody
{
    private byte[] body;
    private CONTENT_TYPE type;
    private String stringBody;

    public HTTPBody(String bodyIn, CONTENT_TYPE typeIn)
    {
        stringBody = bodyIn;
        type = typeIn;
        body = bodyIn.getBytes();
    }

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
