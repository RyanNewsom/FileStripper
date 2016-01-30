import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Ryan on 1/24/2016.
 * Parses each file
 */
public class FileReader {
    private static final String TAG = "FileReader";
    public StringBuilder parseFile(File file){
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            CustomLogger.e(TAG, e.toString());
            return null;
        }

        scanner.next();
        return null;
    }
}
