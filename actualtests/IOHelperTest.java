import org.junit.Test;
import utilities.IOHelper;

import static org.junit.Assert.assertEquals;

/**
 * Created by Steve on 2016-02-16.
 */
public class IOHelperTest
{
    public static IOHelper helper = new IOHelper();

    @Test
    public void fileExist_fileThatActuallyExist_returnsTrue()
    {
        boolean expected = true;
        boolean actualRes = helper.fileExist("src/png/alex.png");
        assertEquals("IO helper has fault in method for seeing if file exist", expected, actualRes);
    }

    @Test
    public void fileExist_fileDoesntExist_returnsFalse()
    {
        boolean expected = false;
        boolean actualRes = helper.fileExist("src/png/austinworshippingsatan.png");
        assertEquals("IO helper has fault in method for seeing if file exist", expected, actualRes);
    }
}
