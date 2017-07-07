package Common;

import Base.BaseTestSuite;

import java.io.IOException;

/**
 * Created by Chetna on 7/5/2017.
 */
public class PayLoad extends BaseTestSuite{

        public static String getWebUserLoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassenger2LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassenger2ChangePassword() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("Passenger2NewPassword")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("Passenger2OldPassword")+"\""+"}";
        return s;
    }
}
