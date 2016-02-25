package request;

import response.CONTENT_TYPE;
import utilities.IOHelper;

/**
 * Created by johanrovala on 16/02/16.
 * This class helps us work with the input gathered from the client and creates a POJO Request object.
 */
public class RequestParser
{

    private String requestLine;

    private String requestType;
    private String path = "";
    private String protocol;
    private CONTENT_TYPE type;

    public RequestParser(String request)
    {
        IOHelper helper = new IOHelper();
        this.requestLine = request;
        requestType = getMethodType();
        path = getPath();
        protocol = getProtocol();
        String fileEnding = helper.getFileEnding(path);
        type = getTypeFromEnding(fileEnding);
        printInfo();
    }

    private void printInfo()
    {
        System.out.println("\n\nThe request parser interpret following values:\n" +
                "Request type = " + requestType + "\n" +
                "Path = " + path + "\n"
                +"Protocol = " + protocol + "\n"
                +"Content type = " + type.toString() + "\n"
                );
    }


    public String getMethodType()
    {
        for(Object o : HTTP_RequestType.values())
        {
            if(requestLine.toLowerCase().contains(o.toString().toLowerCase()))
            {
                requestType = o.toString();
            }
        }
        return requestType;
    }


    public String getPath(){
        char[] split = requestLine.toCharArray();
        int start = 0;
        int end = 0;

        for(int i = 0; i < split.length; i++) {
            if (split[i] == '/') {
                start = i;
                break;
            }
        }
        for(int j = start; j < split.length; j++) {
            if(split[j] == ' '){
                end = j;
                break;
            }
        }
        path = "src" + requestLine.substring(start, end);
        if (path.endsWith("/")){
            path = path.substring(0, path.length()-1);
        }
        return path;
    }

    public String getProtocol()
    {
        char[] split = requestLine.toCharArray();
        int start = 0;
        int end = requestLine.length();


        //Lookup first capital H in HTTP
        for(int i = 0; i < split.length; i++)
        {
            if(split[i] == 'H')
            {
                start = i;
                end = i + 8;        //HTTP/x.x
                break;
            }
        }
        protocol = requestLine.substring(start, end);
        return protocol;
    }

    public Request getRequest()
    {
        return new Request(path, requestType, protocol);
    }


    public CONTENT_TYPE getTypeFromEnding(String fileEnd)
    {
        for (CONTENT_TYPE ct: CONTENT_TYPE.values())
        {
            if (ct.toString().contains(fileEnd))
            {
                return ct;
            }
        }
        return CONTENT_TYPE.unknown;
    }
}
