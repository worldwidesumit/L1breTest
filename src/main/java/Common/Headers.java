package Common;

/**
 * Created by Chetna on 7/5/2017.
 */
public class Headers {

    static String HeaderKeyContentType = "Content-Type";
    static String HeaderValueApplicationJson = "application/json";
    static String HeaderAuthorization = "Authorization";
    static String HeaderAuthorizationValue = "Bearer ";


    public static String getHeaderKeyContentType(){
        String s = HeaderKeyContentType ;
        return s;
    }

    public static String getHeaderValueApplicationJson(){
        String s = HeaderValueApplicationJson;
        return s;
    }

    public static String getHeaderAuthorization(){
        String s = HeaderAuthorization;
        return s;
    }

    public static String getHeaderAuthorizationValue(String token){
        String s = HeaderAuthorizationValue+token;
        return s;
    }
}
