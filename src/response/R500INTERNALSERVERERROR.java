package response;

import java.io.IOException;

/**
 * Created by johanrovala on 19/02/16.
 * General response if none of our earlier responses are created.
 */
public class R500INTERNALSERVERERROR extends HTTPResponse{
    public static final String STATUS = "HTTP/1.1 500 INTERNAL SERVER ERROR";
    public static final String bodyStr = "<h1>500 Something went wrong</h1>";

    public R500INTERNALSERVERERROR(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
