package response;

import java.io.IOException;

/**
 * Created by Jakob on 2016-02-24. If a requested response isn't supported by the
 * server we should return the following response.
 */
public class R415UNSUPPORTEDMEDIATYPE extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 415 UNSUPPORTED MEDIATYPE";
    public static final String bodyStr = "<h1>415 the media type requested is not supported</h1>";

    public R415UNSUPPORTEDMEDIATYPE(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
