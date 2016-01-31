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
        boolean isFirst = true;
        boolean blockCommentActive = false;
        boolean blockCommentInitial = false;
        String currentLine;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        //Read File Line By Line
        try {
            while ((currentLine = br.readLine()) != null)   {
                boolean removeLine = false;
                String lineToAdd = currentLine;

                if(currentLine.contains("//")){
                    int index = currentLine.indexOf("//");
                    lineToAdd = currentLine.substring(0,index);
                }

                if(currentLine.contains("/*")){
                    int index = currentLine.indexOf("/*");
                    lineToAdd = currentLine.substring(0,index);

                    blockCommentActive = true;
                    blockCommentInitial = true;
                }
                //Loops through every line, and makes sure it has chars in it
                for(int i = 0; i < lineToAdd.length(); i++){
                    if(lineToAdd.substring(i, i+1).equals(" ") || lineToAdd.substring(i, i+1).equals("") || lineToAdd.substring(i, i+1).equals("\t")){
                        removeLine = true;
                    } else{
                        removeLine = false;
                        break;
                    }
                }
                if(blockCommentActive){
                    if(currentLine.contains("*/")){
                        int index = currentLine.indexOf("*/") + 2;

                        if(blockCommentInitial) {
                            lineToAdd += currentLine.substring(index, currentLine.length());
                        } else {
                            lineToAdd = currentLine.substring(index, currentLine.length());
                        }
                        blockCommentActive = false;

                    }
                }
                if(!lineToAdd.isEmpty() && !removeLine) {
                    if(!isFirst && (!blockCommentActive || blockCommentInitial)){
                        stringBuilder.append("\n");
                    }
                    if(!blockCommentActive || blockCommentInitial) {
                        stringBuilder.append(lineToAdd);
                    }
                    isFirst = false;
                }
                blockCommentInitial = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}
