package utilities;

import java.io.File;

/**
 * Created by Jakob on 2016-02-16.
 * A class intended to help programmers with standardized method concerning IO
 */
public class IOHelper
{
    public boolean fileExist(String pathToFile)
    {
        File file = new File(pathToFile);
        return file.exists();
    }

    /**
     * Method for extracting path to file according to specified format
     * @return
     */
    public String extractPath()
    {
        //TODO - UNIMPLEMENTED
        return "";
    }
}
