package request;

import response.*;
import utilities.IOHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by johanrovala on 17/02/16.
 */
public class RequestValidator {

    /**
     * Fields
     */

    IOHelper ioHelper;
    Request request;

    public RequestValidator(Request request){
        this.request = request;
        this.ioHelper = new IOHelper();
    }

    private boolean fileExists(String path){
        return ioHelper.fileExist(path);
    }

    private boolean isGet(String requestType){
        return requestType.equals(HTTP_RequestType.GET);
    }

    private boolean isPost(String requestType){
        return requestType.equals(HTTP_RequestType.POST);
    }

    private boolean isPut(String requestType){
        return requestType.equals(HTTP_RequestType.PUT);
    }


    public HTTPResponse getResponse() throws IOException {

        if(fileExists(request.getPath()) && ioHelper.isAllowedDir(request.getPath()))
        {
            System.out.println("File with path " + request.getPath() + " exists and gets returned." );
            return new R200OK(Paths.get(request.getPath()), getContentType(request.getPath()), true);
        }
        else if(!ioHelper.isAllowedDir(request.getPath()))
        {
            System.out.println("\nUser try to access a file that it is not allowed to access with path name" +
                    request.getPath() + "\n\n");
            return new R403FORBIDDEN(true);
        }
        else if(!fileExists(request.getPath()))
        {
            System.out.println("\nAn file that is not allowed for browser got a request for access but denied\n" +
                    "The file name is: " + request.getPath());
            return new R404NOTFOUND(true);
        }
        else
        {
            return new R500INTERNALSERVERERROR(true);
        }
    }

    private CONTENT_TYPE getContentType(String pathOfFile)
    {
        String test = ioHelper.getFileEnding(pathOfFile);

        for (CONTENT_TYPE t : CONTENT_TYPE.values()){

            if(t.toString().endsWith(test)){
                return t;
            }
        }
        return CONTENT_TYPE.unknown;
    }
}
