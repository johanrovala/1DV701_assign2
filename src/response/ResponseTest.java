package response;

import java.io.IOException;

/**
 * Created by Steve on 2016-02-18.
 */
public class ResponseTest
{
    public static void main(String[] args) throws IOException
    {
        R200OK ok = new R200OK("**Some htlm text**", CONTENT_TYPE.HTML, true);

    }
}
