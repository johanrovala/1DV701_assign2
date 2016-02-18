package response;

/**
 * Created by Jakob on 2016-02-16.
 * ENUM for content types to simplify for person using the responses
 */
public enum CONTENT_TYPE
{
    PNG("image.png"), HTML("text/html"), unknown("unknown");

    private final String cont_enum;

    /**
     * @param s is the string the enum will get
     */
    CONTENT_TYPE(final String s)   {cont_enum = s;}

    public String toString() {return cont_enum;}

   // private char[] toChars(CONTENT_TYPE t){
   //     return t.toString().toCharArray();
   // }

    public CONTENT_TYPE getContentType(String pathOfFile){
        for (CONTENT_TYPE t : values()){
            if(pathOfFile.matches("png")){
                return t;
            }
        }
        return unknown;
    }
}
