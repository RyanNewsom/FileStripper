import java.io.File;
import java.util.ArrayList;

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

    private static void readFiles(){
        FileReader fileReader = new FileReader();
        File f = mFileCoordinator.getNextFile();
        if(f != null) {
            StringBuilder newTextForFile = fileReader.parseFile(f);
        }
    }

    private static void loadFiles(){
        ArrayList<String> filesNames = new ArrayList<>();
        mFileCoordinator = new FileCoordinator(filesNames);
        int amount = filesNames.size();
        FileCoordinator fileCoordinator = new FileCoordinator(filesNames);
    }


}
