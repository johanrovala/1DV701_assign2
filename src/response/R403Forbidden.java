package response;

/**
 * Created by Jakob on 2016-02-16.
 * Creates a forbidden 403 response
 */
public class R403Forbidden extends HTTPResponse
{
    public R403Forbidden(String messageBody, CONTENT_TYPE type)
    {
        super("403 Forbidden", type, messageBody.getBytes().length, messageBody);
    }
}
