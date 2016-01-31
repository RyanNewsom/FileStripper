import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Ryan on 1/31/2016.
 */
public class FileReaderTest {
    File file = new File("striptest-12.txt");
    FileReader fileReader = new FileReader();
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFile(){
        fileReader.parseFile(file);
    }
}