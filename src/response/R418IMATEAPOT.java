package response;

import java.io.IOException;

/**
 * Created by Steve on 2016-02-24.
 */
public class R418IMATEAPOT extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 418 I'M A TEAPOT";
    public static final String bodyStr = "<h1>418 I'm a teapot</h1>";

    public R418IMATEAPOT(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
