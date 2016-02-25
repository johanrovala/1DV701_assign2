package response;

import java.io.IOException;

/**
 * Created by Jakob on 2016-02-24.
 * To see when this is activated start the server and try to access the fiveTimes.html
 * page. After 3 times you should be able to get the following response
 */
public class R412PRECONDITIONFAILED extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 412 PRECONDITION FAILED";
    public static final String bodyStr = "<h1>412 The precondition for viewing this" +
            "page hasn't been met. </h1>";

    public R412PRECONDITIONFAILED(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
