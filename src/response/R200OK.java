package response;

/**
 * Created by Jakob on 2016-02-16.
 * Creates an 200 OK response
 */
public class R200OK extends HTTPResponse
{
    public R200OK(String messageBody, CONTENT_TYPE type)
    {
        super("200 OK", type, messageBody.getBytes().length, messageBody);
    }
}
