package response;

/**
 * Created by Jakob on 2016-02-16.
 * ENUM for relevant content types of the application.
 */
public enum CONTENT_TYPE
{
    PNG("image/png"), HTML("text/html"), unknown("unknown");

    private final String cont_enum;

    /**
     * @param s is the string the enum will get
     */
    CONTENT_TYPE(final String s)   {cont_enum = s;}

    public String toString() {return cont_enum;}

}
