package Common;

/**
 * Created by Chetna on 7/5/2017.
 */
public class Resources {

    static String webUserLogin = "/user/1.0.0/webuser/login";
    static  String documentdocument = "/document/1.0.0/document";
    static String passengerLogin = "/user/1.0.0/passenger/login";
    static String passengerChangePassword = "/user/1.0.0/passenger/change-password";

    public static String getWebUserLogin(){

        String s = webUserLogin;
        return s;

    }


    public static String getDocumentupload(){

        String s = documentdocument;
        return s;

    }

    public static String getPassengerLogin(){

        String s = passengerLogin;
        return s;

    }

    public static String getPassengerChangePassword(){

        String s = passengerChangePassword;
        return s;

    }
}
