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
        Boolean isFirst = true;
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
                    if(lineToAdd.isEmpty()){
                        removeLine = true;
                    }
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
                if(!lineToAdd.isEmpty() && !removeLine) {
                    if(!isFirst){
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(lineToAdd);
                    isFirst = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}
