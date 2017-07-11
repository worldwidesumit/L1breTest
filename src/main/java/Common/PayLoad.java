package Common;

import ApiTests.DocumentTests;
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


    public static String getPassenger1LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER1_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER1_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassengerChangeLocale() throws IOException {
        String s = "{\"locale\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_PASSENGER_LOCALE")
                +"\""+"}";
        return s;
    }

    public static String getPassengerChangePasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassenger2NewPassLoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassengerRevertPasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getPassengerGenerateTempDataBody() throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_USERNAME")
                +"\""+"}";
        return s;
    }

    public static String getPassengerRefreshToken() throws IOException {
        String s = "{\"refresh_token\":"+"\""+BaseTestSuite.getData().getProperty("PASSENGER2_REFRESH_TOKEN")
                +"\""+"}";
        return s;
    }

    public static String getDocumentRenameBody() throws IOException {
        String s = "{\"fileName\":"+"\""+BaseTestSuite.getData().getProperty("NEWDOCUMENTNAME")
                +"\""+","+"\"documentId\":"+"\""+ DocumentTests.getDocumentId()+"\""+"}";
        return s;
    }

    public static String getDocumentAlreadyDeletedBody  () throws IOException {
        String s = "{\"documentId\":"+"\""+BaseTestSuite.getData().getProperty("ALREAD_DELETED_FILE_ID")
                +"\""+"}";
        return s;
    }

    public static String getWebUserForgotPasswordEmailBody  () throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN3_EMAIL")
                +"\""+"}";
        return s;
    }

    public static String getWebUserForgotPasswordUnameBody  () throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN3_USERNAME")
                +"\""+"}";
        return s;
    }

    public static String getWebUserForgotPasswordFakeBody  () throws IOException {
        String s = "{\"email\":"+"\""+"RandomAndFake"
                +"\""+"}";
        return s;
    }

    public static String getWebuserUpdateBody() throws IOException {
        String s = "{\"firstName\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_FIRST_NAME")
                +"\""+","+"\"lastName\":"+"\""+ BaseTestSuite.getData().getProperty("TEMP_LAST_NAME")+"\""+"}";
        return s;
    }

    public static String getWebUserUpdateDuplicateEmail  () throws IOException {
        String s = "{\"email\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_EMAIL")
                +"\""+"}";
        return s;
    }

    public static String getWebuserUpdatePhoneBody() throws IOException {
        String s = "{\"countryCode\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_COUNTRYCODE")
                +"\""+","+"\"phoneNumber\":"+"\""+ BaseTestSuite.getData().getProperty("ADMIN2_PHONENUMBER")+"\""+"}";
        return s;
    }

    public static String getWebUserAdmin2LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getWebusesrChangePasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getWebUserAdminLoginNewPasswordBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getWebusesrRevertPasswordBody() throws IOException {
        String s = "{\"oldPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN2_PASSWORD")
                +"\""+","+"\"newPassword\":"+"\""+BaseTestSuite.getData().getProperty("ADMIN_PASSWORD")+"\""+"}";
        return s;
    }



}
