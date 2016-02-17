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
            if(requestLine.toLowerCase().contains(o.toString().toLowerCase())){
                methodType = o.toString();
            }
        }
        return methodType;
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

        domain = requestLine.substring(start, end);
        return domain;
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
        options = requestLine.substring(start, end);
        return options;
    }







}
