package utilities;

import response.AVAILABLE_DIR;
import response.CONTENT_TYPE;

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

    public String getFileEnding(String pathOfFile)
    {
        int i = pathOfFile.length() -1;
        boolean foundEnding = false;
        while (i >= 0 && !foundEnding)
        {
            char temp = pathOfFile.charAt(i);
            if (!Character.isAlphabetic(temp))
            {
                return pathOfFile.substring(i+1);
            }
            i--;
        }
        return null;
    }

    public boolean isAllowedDir(String pathOfFile){
        String allowedPath = "src/";

        for(AVAILABLE_DIR d : AVAILABLE_DIR.values()){
            if (pathOfFile.startsWith(allowedPath+d.toString())){
                return true;
            }
        }

        return false;
    }
}
