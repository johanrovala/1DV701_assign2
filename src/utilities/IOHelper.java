package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public String readContentOfFile(String path) throws FileNotFoundException
    {
        File file = new File(path);
        if (file.exists())
        {
            String out = "";
            Scanner fileScan = new Scanner(file);
            while (fileScan.hasNextLine())
            {
                out += fileScan.nextLine() + "\n";
            }
            out.substring(0, out.length() - 1);     //Removing last new line character
            return out;
        }
        else
        {
            System.err.print("Error reading content of file\n");
        }
        return null;
    }
}
