package Common;

import ApiTests.DocumentTests;
import ApiTests.TripManagerTests;
import Base.BaseTestSuite;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

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

    public static String getDriverEmailbody  () throws IOException {
        String s = "{\n" +
                "  \"MODEL_TYPE\": \"driver\",\n" +
                "  \"username\": \"\",\n" +
                "  \"driverId\": \"\",\n" +
                "  \"name\": \"\",\n" +
                "  \"firstName\": \"Rodrigo\",\n" +
                "  \"lastName\": \"Pardo Fernandez\",\n" +
                "  \"shortName\": \"\",\n" +
                "  \"email\": \""+BaseTestSuite.getData().getProperty("DRIVER1_EMAIL")+"\",\n" +
                "  \"photo\": \"\",\n" +
                "  \"locale\": \"es_MX\",\n" +
                "  \"currentTaxiId\": \"\",\n" +
                "  \"currentTaxiInfo\": \"\",\n" +
                "  \"currentShiftId\": \"\",\n" +
                "  \"lastLoginTime\": null,\n" +
                "  \"lastLogoutTime\": null,\n" +
                "  \"rating\": 0,\n" +
                "  \"ratingsDoc\": {\n" +
                "    \n" +
                "  },\n" +
                "  \"forceChangePassword\": null,\n" +
                "  \"suspended\": null,\n" +
                "  \"countryCode\": \"+1\",\n" +
                "  \"phoneNumber\": \"123{{DRIVER1_PHONENUMBER}}\",\n" +
                "  \"phone\": \"\",\n" +
                "  \"rfc\": \"\",\n" +
                "  \"curp\": \"528983DC6B644027BF\",\n" +
                "  \"licenseId\": \"TEST-DRIVER01\",\n" +
                "  \"licenceExpiration\": 1525910400000,\n" +
                "  \"licenceType\": \"\",\n" +
                "  \"accessCardId\": \"\",\n" +
                "  \"dob\": 633887515407,\n" +
                "  \"cardCode\": \"\",\n" +
                "  \"licensePlate\": \"\",\n" +
                "  \"emergencyContacts\": \"\",\n" +
                "  \"gender\": \"m\",\n" +
                "  \"bloodType\": \"AP\",\n" +
                "  \"mobileCountryCode\": \"\",\n" +
                "  \"mobilePhoneNumber\": \"\",\n" +
                "  \"vehicleOwner\": \"\",\n" +
                "  \"licenceOwner\": \"\",\n" +
                "  \"medicalInsurance\": \"\",\n" +
                "  \"medInsuranceCompany\": \"\",\n" +
                "  \"medExpirationDate\": null,\n" +
                "  \"tarjetonId\": \"WM409801\",\n" +
                "  \"tarjetonType\": \"PP\",\n" +
                "  \"tarjetonExpDate\": 1738425171322,\n" +
                "  \"streetAddress\": \"1115 Laidlaw Dr\",\n" +
                "  \"intNum\": \"\",\n" +
                "  \"extNum\": \"11\",\n" +
                "  \"community\": \"Milton\",\n" +
                "  \"municipality\": \"Halton\",\n" +
                "  \"zipcode\": \"90210\",\n" +
                "  \"state\": \"ON\",\n" +
                "  \"_yz_rk\": \"\",\n" +
                "  \"disableExpiryDate\": true,\n" +
                "  \"loading\": false,\n" +
                "  \"noResponse\": false,\n" +
                "  \"notFound\": false,\n" +
                "  \"readonly\": true,\n" +
                "  \"whiteout\": false,\n" +
                "  \"alreadyInDB\": false,\n" +
                "  \"licenceExpiration_valid\": true,\n" +
                "  \"dob_valid\": true,\n" +
                "  \"tarjetonExpDate_valid\": true,\n" +
                "  \"medExpirationDate_valid\": true,\n" +
                "  \"goodToGo\": true\n" +
                "}";
        return s;
    }

    public static String getDriverNewPhoneEmail() throws IOException {
        String s = "{\n" +
                "  \"MODEL_TYPE\": \"driver\",\n" +
                "  \"username\": \"\",\n" +
                "  \"driverId\": \"\",\n" +
                "  \"name\": \"\",\n" +
                "  \"firstName\": \"Rodrigo\",\n" +
                "  \"lastName\": \"Pardo Fernandez\",\n" +
                "  \"shortName\": \"\",\n" +
                "  \"email\": \"notExistingDriver@gmail.com\",\n" +
                "  \"photo\": \"\",\n" +
                "  \"locale\": \"es_MX\",\n" +
                "  \"currentTaxiId\": \"\",\n" +
                "  \"currentTaxiInfo\": \"\",\n" +
                "  \"currentShiftId\": \"\",\n" +
                "  \"lastLoginTime\": null,\n" +
                "  \"lastLogoutTime\": null,\n" +
                "  \"rating\": 0,\n" +
                "  \"ratingsDoc\": {\n" +
                "    \n" +
                "  },\n" +
                "  \"forceChangePassword\": null,\n" +
                "  \"suspended\": null,\n" +
                "  \"countryCode\": \"+67\",\n" +
                "  \"phoneNumber\": \"8907654563\",\n" +
                "  \"phone\": \"\",\n" +
                "  \"rfc\": \"\",\n" +
                "  \"curp\": \"528983DC6B644027BF\",\n" +
                "  \"licenseId\": \"TEST-DRIVER01\",\n" +
                "  \"licenceExpiration\": 1525910400000,\n" +
                "  \"licenceType\": \"\",\n" +
                "  \"accessCardId\": \"\",\n" +
                "  \"dob\": 633887515407,\n" +
                "  \"cardCode\": \"\",\n" +
                "  \"licensePlate\": \"\",\n" +
                "  \"emergencyContacts\": \"\",\n" +
                "  \"gender\": \"m\",\n" +
                "  \"bloodType\": \"AP\",\n" +
                "  \"mobileCountryCode\": \"\",\n" +
                "  \"mobilePhoneNumber\": \"\",\n" +
                "  \"vehicleOwner\": \"\",\n" +
                "  \"licenceOwner\": \"\",\n" +
                "  \"medicalInsurance\": \"\",\n" +
                "  \"medInsuranceCompany\": \"\",\n" +
                "  \"medExpirationDate\": null,\n" +
                "  \"tarjetonId\": \"WM409801\",\n" +
                "  \"tarjetonType\": \"PP\",\n" +
                "  \"tarjetonExpDate\": 1738425171322,\n" +
                "  \"streetAddress\": \"1115 Laidlaw Dr\",\n" +
                "  \"intNum\": \"\",\n" +
                "  \"extNum\": \"11\",\n" +
                "  \"community\": \"Milton\",\n" +
                "  \"municipality\": \"Halton\",\n" +
                "  \"zipcode\": \"90210\",\n" +
                "  \"state\": \"ON\",\n" +
                "  \"_yz_rk\": \"\",\n" +
                "  \"disableExpiryDate\": true,\n" +
                "  \"loading\": false,\n" +
                "  \"noResponse\": false,\n" +
                "  \"notFound\": false,\n" +
                "  \"readonly\": true,\n" +
                "  \"whiteout\": false,\n" +
                "  \"alreadyInDB\": false,\n" +
                "  \"licenceExpiration_valid\": true,\n" +
                "  \"dob_valid\": true,\n" +
                "  \"tarjetonExpDate_valid\": true,\n" +
                "  \"medExpirationDate_valid\": true,\n" +
                "  \"goodToGo\": true\n" +
                "}";
        return s;
    }

    public static Timestamp getTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.getTime();
        return  timestamp;

    }

    public static String getDriver2SuspendBody() throws IOException {
        String s = "{\n" +"\"suspended\": \"true\"\n" +"}";
        return s;
    }

    public static String getDriver2LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER2_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER2_PASSWORD")+"\""+"}";
        return s;
    }

    public static String getDriver2UnSuspendBody() throws IOException {
        String s = "{\n" +"\"suspended\": \"false\"\n" +"}";
        return s;
    }

    public static String getDriverZipCodeBody() throws IOException {
        String s = "{\"zipcode\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_ZIP_CODE")
                +"\""+"}";
        return s;
    }
    public static String getDriver1LoginBody() throws IOException {
        String s = "{\"username\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_USERNAME")
                +"\""+","+"\"password\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_PASSWORD")+"\""+"}";
        return s;
    }
    public static String getDriverReplaceEmerContactsBody() throws IOException {
        String s = "{{\n" +
                "\"contacts\":[],\n" +
                "\"replace\":true\n" +
                "}";
        return s;
    }

    public static String getDriverShiftsTaxi1Body() throws IOException {
        String s = "{\"taxiId\":"+"\""+BaseTestSuite.getData().getProperty("TAXI1_TAXIID")
                +"\""+","+"\"shiftId\":"+"\""+getTimeStamp().getTime()+"\""+"}";
        return s;
    }

    public static String getTripDriver1BookTaxi1Body() throws IOException {
        String s = "{\"taxiId\":"+"\""+BaseTestSuite.getData().getProperty("TAXI1_TAXIID")
                +"\""+","+"\"driverId\":"+"\""+BaseTestSuite.getData().getProperty("DRIVER1_DRIVERID")+"\""+"}";
        return s;
    }

    public static String getTripCancelTripBody() throws IOException {
        String s = "{\"tripId\":"+"\""+ TripManagerTests.getTRIPID()
                +"\""+"}";
        return s;
    }

    public static String getTripTrip2EndBody() throws IOException {
        String s = "{\n" +
                "\"tripCostSummary\":{\n" +
                "\"baseFare\": 5.50,\n" +
                "\"distance\": 4.25,\n" +
                "\"time\": 6.50, \n" +
                "\"wifiCost\": 3,\n" +
                "\"total\":" +BaseTestSuite.getData().getProperty("TEMP_TOTAL_COST")+"\n" +
                "},\n" +
                "\"tripDistance\": 50,\n" +
                "\"isWiFiConsumed\": true\n" +
                "}";
        return s;
    }

    public static String getTripDriver1RateTrip2Body() throws IOException {
        String s = "{\"rating\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_DRIVER_RATE")
                +"\""+"}";
        return s;
    }

    public static String getTripPassengerRatingBody() throws IOException {
        String s = "{\"rating\":"+"\""+BaseTestSuite.getData().getProperty("TEMP_PASSENGER_TABLET_RATE")
                +"\""+","+"\"passengerTablet\":"+"\""+true+"\""+"}";
        return s;
    }







}
