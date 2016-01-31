import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ryan on 1/24/2016.
 * Controls the files,
 */
public class FileCoordinator {
    private static final String TAG = "FileCoordinator";

    private List<File> mFiles;
    private List<String> mFileNames;

    public FileCoordinator(List<String> fileNames){
        mFileNames = fileNames;
        mFiles = new ArrayList<>();
        createFiles();
    }

    private void createFiles(){
        for(int i = 0; i < mFileNames.size(); i++){
            String fileName = mFileNames.get(i);
            File file = new File(fileName);
            mFiles.add(file);
        }
    }

    public File getNextFile(){
        if(!mFiles.isEmpty()) {
            return mFiles.remove(0);
        } else{
            return null;
        }
    }
}
