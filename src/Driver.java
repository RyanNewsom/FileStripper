import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ryan on 1/24/2016.
 * The Driver for the Stripper program. Here file's will be opened, & any items to be stripped removed, with the new
 * text being outputted to a file.
 */
public class Driver {
    private static FileCoordinator mFileCoordinator;
    //Loop through the possible files
    //Open the current file
    //Look for any items to be stripped
    //Remove the items and output the new text to an output file
    public static void main(String [] args){
        loadFiles();
        readFiles();
    }

    /**
     * Reads all the files and produces a string builder which will then be written to a new file
     */
    private static void readFiles(){
        FileReader fileReader = new FileReader();
        for(File f = mFileCoordinator.getNextFile(); f != null;){
            StringBuilder newTextForFile = fileReader.parseFile(f);
        }
    }

    /**
     * Passes all the file names in the file coordinator
     */
    private static void loadFiles(){
        ArrayList<String> filesNames = (ArrayList<String>) Arrays.asList("striptest-1.txt", "striptest-2.txt", "striptest-3.txt"
        , "striptest-4.txt", "striptest-5.txt", "striptest-6.txt", "striptest-7.txt", "striptest-8.txt", "striptest-9.txt"
        , "striptest-10a.txt", "striptest-10b.txt", "striptest-10c.txt", "striptest-10d.txt", "striptest-11.txt"
        , "striptest-12.txt", "striptest-13.txt");
        mFileCoordinator = new FileCoordinator(filesNames);
    }


}
