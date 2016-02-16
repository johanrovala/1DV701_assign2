package response;

/**
 * Created by Steve on 2016-02-16.
 */
public class OK200 extends HTTPResponse
{
    public OK200(String messageBody, CONTENT_TYPE type){ super("200 OK", type, messageBody.length(), messageBody);}
}
