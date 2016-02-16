import java.util.ArrayList;

/**
 * Created by johanrovala on 16/02/16.
 */
public class HTTPRequest {

    private String requestLine;

    private String methodType;
    private String domain;
    private String options;

    public HTTPRequest(String line){
        requestLine = line;
    }

    public String getMethodType(){
        for(Object o : HTTP_RequestType.values()){
            if(requestLine.toLowerCase().contains(o.toString())){
                methodType = o.toString();
            }
        }
        return methodType;
    }

    public String getPath(){
        char[] split = requestLine.toCharArray();

        for(int i = 0; i < split.length; i++) {
            if (split[i] == '/') {

            }
        }
        return "";
    }





}
