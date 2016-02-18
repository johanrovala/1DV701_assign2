package response;

/**
 * Created by Jakob on 2016-02-16.
 */
public class R500InternalServerError extends HTTPResponse
{
    public R500InternalServerError(String messageBody, CONTENT_TYPE type)
    {
        super("500 Internal server error", type, messageBody.getBytes().length);
    }
}
