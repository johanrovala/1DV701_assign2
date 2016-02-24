package response;

import java.io.IOException;

/**
 * Created by Steve on 2016-02-24.
 */
public class R402PAYMENTREQUIRED extends HTTPResponse
{
    public static final String STATUS = "HTTP/1.1 402 PAYMENT REQUIRED";
    public static final String bodyStr = "<h1>402 this secret page requires payment, " +
            "to receive this beautiful content, please swish 10000 sek to 0722023423</h1>";

    public R402PAYMENTREQUIRED(boolean keep_alive) throws IOException
    {
        super(STATUS, CONTENT_TYPE.HTML, bodyStr, keep_alive);
    }
}
