package response;

/**
 * Created by Steve on 2016-02-16.
 */
public enum CONTENT_TYPE
{
    PNG("image.png"), HTML("text/html");

    private final String httpEnum;

    /**
     * @param s is the string the enum will get
     */
    CONTENT_TYPE(final String s)   {httpEnum = s;}

    public String toString() {return httpEnum;}
}
