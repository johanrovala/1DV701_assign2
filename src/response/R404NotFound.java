package response;

/**
 * Created by Steve on 2016-02-16.
 */
public class R404NotFound extends HTTPResponse
{
    public R404NotFound(String messageBody, CONTENT_TYPE type)
    {
        super("404 Forbidden", type, messageBody.getBytes().length, messageBody);
    }
}
