package utilities;

import java.util.ArrayList;

/**
 * Created by Steve on 2016-02-19.
 */
public class AllowedPaths
{
    private static final String[] allowedPaths =
            {
                    "src/html/index.html",
                    "src/png/alex.png",
                    "src/png/fishy.png",
                    "src/html",
                    "src/png"
            };

    public static boolean canAccessPath(String path)
    {
        for (int i = 0; i < allowedPaths.length; i++)
        {
            if (allowedPaths[i].equals(path))
            {
                return true;
            }
        }
        return false;
    }
}
