package request;

import response.*;
import utilities.IOHelper;


import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by johanrovala on 17/02/16.
 */
public class RequestValidator {

    /*
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

    private boolean isAllowedDir(String path){
        return ioHelper.isAllowedDir(path);
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

        if(fileExists(request.getPath()) && isAllowedDir(request.getPath())){
            return new R200OK(Paths.get(request.getPath()), getContentType(request.getPath()), true);
        }
        else if(!fileExists(request.getPath())){
            return new R404NOTFOUND(true);
        }
        else if(!isAllowedDir(request.getPath())){
            return new R403FORBIDDEN(true);
        }else {
            return new R500INTERNALSERVERERROR(true);
        }
    }


    private CONTENT_TYPE getContentType(String pathOfFile){
        String test = ioHelper.getFileEnding(pathOfFile);

        for (CONTENT_TYPE t : CONTENT_TYPE.values()){

            if(t.toString().endsWith(test)){
                return t;
            }
        }
        return CONTENT_TYPE.unknown;
    }
}
