package request;

import utilities.IOHelper;

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

/*
    public HTTPResponse getResponse(){
        if(fileExists(request.getPath())){
            return new Response200(new File(request.getPath()));
        }else if(!fileExists(request.getPath())){
            return new Response400();
        }
    }
*/
}
