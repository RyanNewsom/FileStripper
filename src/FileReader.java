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

    /**
     * Remove comments, blank lines
     * @param file - file to be parsed
     * @return
     */
    public StringBuilder parseFile(File file){
        Scanner scanner;
        StringBuilder stringBuilder = new StringBuilder();

        scanner = openFile(file);
        if (scanner == null){
            return null;
        }
        //Scan the file, if you run into a blank line/comment, remove it.
        while(scanner.hasNext()){
            stringBuilder.append(scanner.next());
        }
        return stringBuilder;
    }

    private Scanner openFile(File file) {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            CustomLogger.e(TAG, e.toString());
            return null;
        }
        return scanner;
    }
}
