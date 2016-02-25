package response;

import java.io.IOException;

/**
 * Created by johanrovala on 19/02/16.
 * If Path does not exist within our directory, an instance of this class is created.
 */
public class R404NOTFOUND extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 404 NOT FOUND";
    public static final String bodyStr = "<h1>404 File not found</h1>";

    public R404NOTFOUND(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
