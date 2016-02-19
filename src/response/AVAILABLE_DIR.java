package response;

/**
 * Created by johanrovala on 19/02/16.
 */
public enum AVAILABLE_DIR {
    HTML("html"), PNG("png");

    private final String dir_enum;

    AVAILABLE_DIR (final String s){
        dir_enum = s;
    }

    public String toString(){ return dir_enum; }
}
