package response;

import java.io.IOException;

/**
 * Created by Jakob on 2016-02-25.
 */
public class R405METHODNOTALLOWED extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 405 METHOD NOT ALLOWED";
    public static final String bodyStr = "<h1>405 This server doesn't allow this method" +
            " in its current implementation.</h1>";

    public R405METHODNOTALLOWED(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
