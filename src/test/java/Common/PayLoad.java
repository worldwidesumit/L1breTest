package Common;

/**
 * Created by Chetna on 7/5/2017.
 */
public class PayLoad {

    private static String AdminUserName = "_for_api_monitoring_only316";
    private static String AdminPassword = "api12345";
    private static String Passenger2UserName = "runscopePassengerPrd02@mailinator.com";
    private static String Passenger2Password = "password";
    private static String Passenger2OldPassword = "password";
    private static String Passenger2NewPassword = "admprd02";
    private static String DblQuote = "\"";

        public static String getWebUserLoginBody(){
        String s = "{\"username\":"+"\""+AdminUserName+"\""+","+"\"password\":"+"\""+AdminPassword+"\""+"}";
        return s;
    }

    public static String getPassenger2LoginBody(){
        String s = "{\"username\":"+"\""+Passenger2UserName+"\""+","+"\"password\":"+"\""+Passenger2Password+"\""+"}";
        return s;
    }

    public static String getPassenger2ChangePassword(){
        String s = "{\"oldPassword\":"+"\""+Passenger2NewPassword+"\""+","+"\"newPassword\":"+"\""+Passenger2OldPassword+"\""+"}";
        return s;
    }
}
