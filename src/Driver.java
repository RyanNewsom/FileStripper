import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 1/24/2016.
 * The Driver for the Stripper program. Here file's will be opened, & any items to be stripped removed, with the new
 * text being outputted to a file.
 */
public class Driver {
    private static FileCoordinator mFileCoordinator;
    private static List<StringBuilder> mNewFiles = new ArrayList<>();

    //Loop through the possible files
    //Open the current file
    //Look for any items to be stripped
    //Remove the items and output the new text to an output file
    public static void main(String [] args){
        loadFiles();
        readFiles();
        outputFiles();
    }

    /**
     * Reads all the files and produces a string builder which will then be written to a new file
     */
    private static void readFiles(){
        FileReader fileReader = new FileReader();
        for(File f = mFileCoordinator.getNextFile(); f != null;f = mFileCoordinator.getNextFile()){
            StringBuilder newTextForFile = fileReader.parseFile(f);
            mNewFiles.add(newTextForFile);
        }
    }

    /**
     * Outputs the new files with blank lines & comments removed
     */
    private static void outputFiles() {
        BufferedWriter output = null;
        List<String> fileNames = Arrays.asList("striptest-1-out.txt", "striptest-2-out.txt", "striptest-3-out.txt"
                , "striptest-4-out.txt", "striptest-5-out.txt", "striptest-6-out.txt", "striptest-7-out.txt"
                , "striptest-8-out.txt", "striptest-9-out.txt"
                , "striptest-10a-out.txt", "striptest-10b-out.txt", "striptest-10c-out.txt", "striptest-10d-out.txt"
                , "striptest-11.txt-out", "striptest-12-out.txt", "striptest-13-out.txt");
        if(mNewFiles.size() != fileNames.size()){
            throw new RuntimeException("You must specify a filename for each new file to be built");
        }

        for(int i = 0; i < mNewFiles.size(); i++) {
            StringBuilder current = mNewFiles.get(i);
            try {
                output = new BufferedWriter(new FileWriter(fileNames.get(i)));
                output.write(current.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Passes all the file names in the file coordinator
     */
    private static void loadFiles(){
        List<String> filesNames = Arrays.asList("striptest-1.txt", "striptest-2.txt", "striptest-3.txt"
        , "striptest-4.txt", "striptest-5.txt", "striptest-6.txt", "striptest-7.txt", "striptest-8.txt", "striptest-9.txt"
        , "striptest-10a.txt", "striptest-10b.txt", "striptest-10c.txt", "striptest-10d.txt", "striptest-11.txt"
        , "striptest-12.txt", "striptest-13.txt");
        mFileCoordinator = new FileCoordinator(filesNames);
    }


}
