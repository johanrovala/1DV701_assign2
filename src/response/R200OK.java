package response;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Jakob on 2016-02-18.
 * The mainly used response, namely 200 ok. Have two different constructors
 * corresponding to the constructor of the super class.
 */
public class R200OK extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 200 OK";

    public R200OK(String bodyStr, CONTENT_TYPE typeIn, boolean keep_alive) throws IOException
    {
        super(STATUS, typeIn, bodyStr, keep_alive);
    }

    public R200OK(Path pathToFile, CONTENT_TYPE typeIn, boolean keep_alive) throws IOException
    {
        super(STATUS, typeIn, pathToFile, keep_alive);
    }
}
