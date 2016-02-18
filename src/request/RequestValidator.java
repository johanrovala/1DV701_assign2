package request;

import response.CONTENT_TYPE;
import response.HTTPResponse;
import response.R200OK;
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
    CONTENT_TYPE type;

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

        System.out.println("debug");
        if(fileExists(request.getPath())){
            return new R200OK(Paths.get(request.getPath()), CONTENT_TYPE.HTML, true);
        }//else if(!fileExists(request.getPath()))
           // return new Response400();
       // }
        System.out.println(request.getPath());
        return new R200OK(Paths.get(request.getPath()), CONTENT_TYPE.HTML, true);
    }
}
