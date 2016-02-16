package response;

/**
 * Created by Steve on 2016-02-16.
 */
public class HTTPResponseMain
{
    public static void main(String[] args)
    {
        OK200 okResponse = new OK200("Some html text", CONTENT_TYPE.HTML);
        System.out.println(okResponse.toString());
    }
}
