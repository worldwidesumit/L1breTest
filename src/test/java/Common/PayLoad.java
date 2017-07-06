package Common;

/**
 * Created by Chetna on 7/5/2017.
 */
public class PayLoad {

    private static String AdminUserName = "_for_api_monitoring_only316";
    private static String AdminPassword = "api12345";
    private static String DblQuote = "\"";

    public static String getWebUserLoginBody(){
        String s = "{\"username\":"+"\""+AdminUserName+"\""+","+"\"password\":"+"\""+AdminPassword+"\""+"}";
        return s;
    }
}
