/**
 * Created by Ryan on 1/24/2016.
 */
public class CustomLogger {
    private static String mErrorTag;

    public static void e(String tag, String message){
        mErrorTag = "ERROR -";
        System.out.println(mErrorTag + tag + ": " + message);
    }

    public static void i(String tag, String message){
        mErrorTag = "INFO -";
        System.out.println(mErrorTag + tag + ": " + message);
    }

}
