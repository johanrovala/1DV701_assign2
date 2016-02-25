package response;

import java.io.IOException;

/**
 * Created by Jakob on 2016-02-24.
 * A response for payment required. The payment required is to
 * visit the instructed html page.
 */
public class R402PAYMENTREQUIRED extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 402 PAYMENT REQUIRED";
    public static final String bodyStr = "<h1>402 this secret page requires payment, " +
            "to view the this page, enter localhost:8888/html/jakobandjohanwillgetAforassignment2.html</h1>";

    public R402PAYMENTREQUIRED(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
