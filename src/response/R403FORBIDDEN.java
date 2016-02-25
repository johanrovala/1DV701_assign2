package response;

import java.io.IOException;

/**
 * Created by johanrovala on 19/02/16.
 */
public class R403FORBIDDEN extends HTTPResponse{

    public static final String STATUS = "HTTP/1.1 403 FORBIDDEN";
    public static final String bodyStr = "<h1>403 You're not allowed here</h1>";

    public R403FORBIDDEN(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
