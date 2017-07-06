package Common;

/**
 * Created by Chetna on 7/5/2017.
 */
public class Headers {

    static String HeaderKeyContentType = "Content-Type";

    static String HeaderValueApplicationJson = "application/json";

    public static String getHeaderKeyContentType(){
        String s = HeaderKeyContentType ;
        return s;
    }

    public static String getHeaderValueApplicationJson(){
        String s = HeaderValueApplicationJson;
        return s;
    }
}
