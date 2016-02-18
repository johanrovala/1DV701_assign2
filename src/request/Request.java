package request;

import java.net.Authenticator;

/**
 * Created by johanrovala on 18/02/16.
 */
public class Request {

    private String requestType;
    private String path;
    private String protocol;

    public Request(String path, String requestType, String protocol){
        this.path = path;
        this.requestType = requestType;
        this.protocol = protocol;
    }

    public String getRequest(){
        return requestType + " " + path + " " + protocol;
    }

    public String getPath(){ return path; }

    public String getRequestType() { return requestType; }

    public String getProtocol() { return protocol; }

}
