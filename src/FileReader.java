import sun.rmi.runtime.Log;

import java.io.*;
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
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String currentLine;

        //Read File Line By Line
        try {
            while ((currentLine = br.readLine()) != null)   {
                boolean removeLine = false;
                // Print the content on the console
                currentLine = currentLine.trim();
                String lineToAdd = currentLine;
                if(currentLine.contains("//")){
                    int index = currentLine.indexOf("//");
                    lineToAdd = currentLine.substring(0,index);
                    if(lineToAdd.isEmpty()){
                        removeLine = true;
                    }
                }

                if(currentLine.contains("\t")){
                    removeLine = true;
                    for(int i = 0; i < currentLine.length() - 1; i++){
                        String subString = currentLine.substring(i,i+1);
                        if(subString.equals("\t")){
                            removeLine = true;
                        } else{
                            removeLine = false;
                        }
                    }
                }

                if(!currentLine.isEmpty() && !removeLine) {
                    stringBuilder.append(lineToAdd);
                    stringBuilder.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
