package response;

/**
 * Created by Jakob on 2016-02-16.
 */
public class HTTPResponseMain
{
    public static void main(String[] args)
    {
        /* A simple demonstration class to see how to use the class. When creating an
        * http response all needed is to choose which kind of response and then provide
        * the required arguments*/
        R200OK okResponse = new R200OK("Some html text", CONTENT_TYPE.HTML);
        System.out.println(okResponse.toString());
        R403Forbidden forbidden = new R403Forbidden("* some html code*", CONTENT_TYPE.HTML);
        System.out.println(forbidden);
    }
}
