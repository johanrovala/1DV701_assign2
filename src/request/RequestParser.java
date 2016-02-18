package request;

/**
 * Created by johanrovala on 16/02/16.
 */
public class RequestParser {

    private String requestLine;

    private String requestType;
    private String path = "";
    private String protocol;


    public void setRequestLine(String request){
        requestLine = request;
    }

    public String getMethodType(){
        for(Object o : HTTP_RequestType.values()){
            if(requestLine.toLowerCase().contains(o.toString().toLowerCase())){
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
        for(int j = start; j < split.length; j++){
            if(split[j] == ' '){
                end = j;
                break;
            }
        }

        path = "src" + requestLine.substring(start, end);
        return path;
    }

    public String getOptions(){
        char[] split = requestLine.toCharArray();
        int start = 0;
        int end = requestLine.length();

        for(int i = 0; i < split.length; i++){
            if(split[i] == 'H'){
                start = i;
                break;
            }
        }
        protocol = requestLine.substring(start, end);
        return protocol;
    }

    public Request getRequest(){
        return new Request(path, requestType, protocol);
    }







}
